package com.enableets.edu.enable.cloud.exam.manager.core;

import cn.hutool.json.JSONUtil;
import com.enableets.edu.enable.cloud.exam.manager.bo.CodeNameMapBO;
import com.enableets.edu.enable.cloud.exam.manager.bo.TeacherBaseInfoBO;
import com.enableets.edu.enable.cloud.exam.manager.paper.core.PPRConstants;
import com.enableets.edu.framework.core.util.JsonUtils;
import com.enableets.edu.framework.core.util.StringUtils;
import com.enableets.edu.module.security.oauth2.client.core.UserIdentifierInfo;
import com.enableets.edu.sdk.account.IAccountService;
import com.enableets.edu.sdk.account.dto.AccountBindingDTO;
import com.enableets.edu.sdk.account.dto.QueryAccountBindingDTO;
import com.enableets.edu.sdk.acm.IFieldSocialInfoService;
import com.enableets.edu.sdk.acm.dto.FieldSocialInfoDTO;
import com.enableets.edu.sdk.content.dto.ContentDictionaryInfoDTO;
import com.enableets.edu.sdk.content.dto.ContentMaterialVersionInfoDTO;
import com.enableets.edu.sdk.content.service.IContentDictionaryInfoService;
import com.enableets.edu.sdk.content.service.IContentInfoService;
import com.enableets.edu.sdk.school3.*;
import com.enableets.edu.sdk.school3.dto.*;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author caleb_liu@enable-ets.com
 * @date 2021/06/18
 **/

@Component
public class BaseInfoManager {

    @Autowired
    private IAccountService accountServiceSDK;

    @Autowired
    private IFieldSocialInfoService fieldSocialInfoServiceSDK;

    /** 用户角色sdk */
    @Autowired
    private IUserIdentityService userIdentityServiceSDK;
    /** 学校信息sdk */
    @Autowired
    private ISchoolInfoService schoolInfoServiceSDK;
    @Autowired
    private ICourseTeacherService courseTeacherService;

    @Autowired
    private IContentDictionaryInfoService contentDictionaryInfoServiceSDK;

    /** 学期信息sdk */
    @Autowired
    private ITermInfoService termInfoServiceSDK;



    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /** Content SDK Client*/
    @Autowired
    private IContentInfoService contentInfoServiceSDK;
    /**
     * 获取当前userid
     * @return
     */
    public String getUserId() {
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext().getAuthentication();
        UserIdentifierInfo userIdentifierInfo = (UserIdentifierInfo) oAuth2Authentication.getUserAuthentication().getDetails();
        return userIdentifierInfo.getUserId();
    }

    public String getAccountOriginDomain(){
        QueryAccountBindingDTO accountBindingDTO = new QueryAccountBindingDTO();
        accountBindingDTO.setUserId(this.getUserId());
        List<AccountBindingDTO> accountBindingDTOS = accountServiceSDK.queryAccountBinding(accountBindingDTO);
        if (CollectionUtils.isNotEmpty(accountBindingDTOS)){
            String socialCode = accountBindingDTOS.get(0).getSocialCode();
            List<FieldSocialInfoDTO> fieldSocials = fieldSocialInfoServiceSDK.query(null, socialCode, null, null, null, null, 0, 1);
            if (CollectionUtils.isNotEmpty(fieldSocials)){
                return fieldSocials.get(0).getUrl();
            }
        }
        return null;
    }


    public String getUserZone(String userId){
        SchoolInfoDTO school = new SchoolInfoDTO();
        school.setSchoolId(this.getSchoolId(userId));
        List<SchoolInfoDTO> list = schoolInfoServiceSDK.query(school);
        String zoneCode = "R01";
        if (CollectionUtils.isNotEmpty(list)){
            SchoolInfoDTO schoolInfoDTO = list.get(0);
            zoneCode += "-" + schoolInfoDTO.getProvinceCode() + "-" + schoolInfoDTO.getCityCode() + "-" + schoolInfoDTO.getAreaCode();
        }
        return zoneCode;
    }
    /**
     * 获取当前学校id
     *
     * @param userId
     * @return
     */
    public String getSchoolId(String userId) {
        UserIdentityDTO userInfo = getUserInfo(userId);
        if (userInfo != null) {
            return userInfo.getSchoolId();
        }
        return null;
    }


    /**
     * 获取所教群组
     * @param userId
     * @param schoolId
     * @param termId
     * @return
     */
    public List<TeacherCourseInfoDTO> getTeachGroup(String userId, String schoolId, String termId) {
        if (StringUtils.isBlank(userId)) {
            userId = this.getUserId();
        }
        if (StringUtils.isBlank(schoolId)) {
            UserIdentityDTO userIdentityDTO = this.getUserInfo(userId);
            if (userIdentityDTO != null) {
                schoolId= userIdentityDTO.getSchoolId();
            }
        }
        List<TeacherCourseInfoDTO> teachCourses = courseTeacherService.queryByUserId(userId, schoolId, termId);
        if (CollectionUtils.isEmpty(teachCourses)) {
            return Collections.emptyList();
        }
        Set<String> classIds = new HashSet<String>();
        Iterator<TeacherCourseInfoDTO> iterator = teachCourses.iterator();
        while(iterator.hasNext()) {
            TeacherCourseInfoDTO dto = iterator.next();
            if (StringUtils.isBlank(dto.getClassId())) {
                iterator.remove();
            } else if (classIds.contains(dto.getClassId())) {
                iterator.remove();
            } else {
                classIds.add(dto.getClassId());
            }
        }
        return teachCourses;
    }

    /**
     * 获取用户信息
     *
     * @param userId
     *            用户标识
     * @return
     */
    public UserIdentityDTO getUserInfo(String userId) {
        if (StringUtils.isBlank(userId)) {
            userId = getUserId();
        }
        UserIdentityDTO userIdentity = new UserIdentityDTO();
        userIdentity.setUserId(userId);
        List<UserIdentityDTO> users = userIdentityServiceSDK.query(userIdentity);
        if (users != null && users.size() > 0) {
            return users.get(0);
        }
        return null;
    }

    /**
     * 获取教师基础信息
     * @param userId 教师标识
     * @return 教师基础信息
     */
    public TeacherBaseInfoBO getTeacherBaseInfo(String userId) {
        // 参数
        UserIdentityDTO userIdentityDTO = this.getUserInfo(userId);
        if (userIdentityDTO == null || userIdentityDTO.getSchool() == null || userIdentityDTO.getSchool().getTerm() == null) {
            return null;
        }
        userId = userIdentityDTO.getUserId();
        String schoolId= userIdentityDTO.getSchool().getId();
        String termId = userIdentityDTO.getSchool().getTerm().getId();
        // 查询所教课程信息
        List<TeacherCourseInfoDTO> teacherCourses = courseTeacherService.queryByUserId(userId, schoolId, termId);
        if (CollectionUtils.isEmpty(teacherCourses)) {
            return null;
        }
        //组装教师sgs基础信息
        TeacherCourseInfoDTO dto = teacherCourses.get(0);
        TeacherBaseInfoBO baseInfo = new TeacherBaseInfoBO();
        baseInfo.setSchoolId(schoolId);
        baseInfo.setSchoolName( userIdentityDTO.getSchool().getName());
        baseInfo.setTermId( termId);
        baseInfo.setTermName( userIdentityDTO.getSchool().getTerm().getName());
        // 学段信息
        String stageCode = CommFun.getSatgeCodeByGradeCode(dto.getGradeCode());
        baseInfo.setStageCode( stageCode);
        List<ContentDictionaryInfoDTO> stageList = contentDictionaryInfoServiceSDK.query(Constants.DEFAULT_SCHOOL_ID, Constants.DICTIONARY_STAGE_TYPE_CODE, null, null, null, "0");
        if (CollectionUtils.isNotEmpty(stageList)) {
            String stageName = stageList.stream().filter(dic -> dic.getCode().equals(stageCode)).limit(1).map(ContentDictionaryInfoDTO::getName).collect(Collectors.joining());
            baseInfo.setStageName(stageName);
        }
        Map<String, String> classMap = new HashMap<>();
        teacherCourses.stream().forEach(course->{
            classMap.put(course.getClassId(), course.getClassName());
        });
        baseInfo.setGradeCode( dto.getGradeCode());
        baseInfo.setGradeName(dto.getGradeName());
        baseInfo.setSubjectCode(dto.getSubjectCode());
        baseInfo.setSubjectName( dto.getSubjectName());
        List<CodeNameMapBO> courseInfo =contentMaterialVersion(dto.getGradeCode(),dto.getSubjectCode());
        baseInfo.setMaterialVersion(courseInfo.get(0));
       //baseInfo.setSubjectName( dto.materialVersion);
        baseInfo.setClassMap(classMap);
        return baseInfo;
    }


    public List<CodeNameMapBO> contentMaterialVersion(String gradeCode, String subjectCode){
        String materialVersionCacheKey = new StringBuilder(PPRConstants.PACKAGE_PPR_CACHE_KEY_PREFIX).append("paper:materialVersion:").append(org.apache.commons.lang3.StringUtils.isBlank(gradeCode) ? "all" : gradeCode).append("_").append(org.apache.commons.lang3.StringUtils.isBlank(subjectCode) ? "all" : subjectCode).toString();
        String materialVersionStr = stringRedisTemplate.opsForValue().get(materialVersionCacheKey);
        if (org.apache.commons.lang3.StringUtils.isNotBlank(materialVersionStr)){
            return JsonUtils.convert2List(materialVersionStr, CodeNameMapBO.class);
        }else {
            List<ContentMaterialVersionInfoDTO> materialVersions = contentInfoServiceSDK.getMaterialVersionList(gradeCode, subjectCode, Constants.CONTENT_PUBLIC_TYPE).getData();
            if (CollectionUtils.isNotEmpty(materialVersions)){
                List<CodeNameMapBO> materials = materialVersions.stream().map(e -> new CodeNameMapBO(e.getMaterialVersion(), e.getMaterialVersionName(), e.getGradeCode(), e.getSubjectCode())).collect(Collectors.toList());
                stringRedisTemplate.opsForValue().set(materialVersionCacheKey, JsonUtils.convert(materials), Constants.DEFAULT_REDIS_CACHE_EXPIRE_TIME, TimeUnit.SECONDS);
                return materials;
            }
        }
        return null;
    }
    /**
     * 获取当前学期id
     *
     * @param schoolId
     * @return
     */
    public String getCurrentTermId(String schoolId) {
        QueryTermInfoResultDTO currentTerm = getCurrentTerm(schoolId);
        if (currentTerm != null) {
            return currentTerm.getTermId();
        }
        return null;
    }


    /**
     * 返回当前学期信息
     *
     * @param schoolId
     *            学校标识
     * @return
     */
    public QueryTermInfoResultDTO getCurrentTerm(String schoolId) {
        List<QueryTermInfoResultDTO> terms = getTerms(schoolId);
        if (terms.size() > 0) {
            for (QueryTermInfoResultDTO term : terms) {
                if (term.getStatus().equals(Constants.STATUS_CURRENT_TERM)) {
                    return term;
                }
            }
        }
        return null;
    }

    /**
     * 获取学期信息list
     *
     * @param schoolId
     *            学校标识
     * @return
     */
    public List<QueryTermInfoResultDTO> getTerms(String schoolId) {
        if (StringUtils.isBlank(schoolId)) {
            schoolId = getSchoolId(null);
        }
        if (StringUtils.isNotBlank(schoolId)) {
            QueryTermInfoDTO queryTermInfo = new QueryTermInfoDTO();
            queryTermInfo.setSchoolId(schoolId);
            List<QueryTermInfoResultDTO> list = termInfoServiceSDK.query(queryTermInfo);
            if (list != null && list.size() > 0) {
                return list;
            }
        }
        return Collections.emptyList();
    }

}
