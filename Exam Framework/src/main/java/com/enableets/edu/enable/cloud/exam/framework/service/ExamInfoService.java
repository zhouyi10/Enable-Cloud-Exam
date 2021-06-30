package com.enableets.edu.enable.cloud.exam.framework.service;

import com.enableets.edu.enable.cloud.exam.framework.bo.*;
import com.enableets.edu.enable.cloud.exam.framework.dao.*;
import com.enableets.edu.enable.cloud.exam.framework.po.*;
import com.enableets.edu.framework.core.util.BeanUtils;
import com.enableets.edu.framework.core.util.token.ITokenGenerator;
import com.enableets.edu.sdk.school3.ICourseInfoService;
import com.enableets.edu.sdk.school3.dto.GetCourseInfoResultDTO;
import com.enableets.edu.sdk.school3.dto.Response;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.*;

/**
 * @author caleb_liu@enable-ets.com
 * @date 2021/05/13
 **/

@Service
public class ExamInfoService {

    @Autowired
    public ITokenGenerator getTokenGenerator;

    @Autowired
    public ExamInfoDAO examInfoDAO;

    @Autowired
    public ExamDetailsInfoDAO examDetailsDAO;

    @Autowired
    private ExamDetailsMarkAssigneeDAO examDetailsMarkAssigneeDAO;

    @Autowired
    private ExamDetailsStepTaskInfoDAO examDetailsStepTaskInfoDAO;

    /** exam question assignees */
    @Autowired
    private ExamQuestionMarkAssigneeDAO examQuestionMarkAssigneeDAO;

    @Autowired
    private ExamPointInputSettingDAO examPointInputSettingDAO;

    @Autowired
    private ICourseInfoService courseInfoServiceSDK;

    @Autowired
    private ExamQuestionMarkAssigneeService examQuestionMarkAssigneeService;

    /**
     * get exam info
     * @param examId
     * @return exam info
     */
    public ExamInfoV2BO getV2(Long examId) {
        // 1. get exam and details
        ExamInfoPO examInfoPO = examInfoDAO.getExamV2(examId);
        ExamInfoV2BO result = BeanUtils.convert(examInfoPO, ExamInfoV2BO.class);
        if (result == null || CollectionUtils.isEmpty(result.getDetails())) {
            return result;
        }
        // 2. rebuild classes info
        List<IdNameMapBO> classes = new ArrayList<IdNameMapBO>();
        Set<String> classIds = new HashSet<String>();
        for (ExamDetailsInfoV2BO detail : result.getDetails()) {
            if (StringUtils.isNotBlank(detail.getClassId()) && !classIds.contains(detail.getClassId())) {
                IdNameMapBO classInfo = new IdNameMapBO(detail.getClassId(), detail.getClassName());
                classInfo.setStudentAmount(detail.getActualStudentNumber().toString());
                classes.add(classInfo);
                classIds.add(detail.getClassId());
            }
        }
        result.setClasses(classes);
        //fixme: 3. merge mark assignee info and step task info
        for (ExamDetailsInfoV2BO detailsInfoV2BO : result.getDetails()) {
            // MarkAssignee
            Map<String, Object> map = new HashMap<>();
            map.put("examDetailsId", detailsInfoV2BO.getExamDetailsId());
            List<ExamDetailsMarkAssigneePO> examDetailsMarkAssigneePOS = examDetailsMarkAssigneeDAO.queryById(map);
            detailsInfoV2BO.setMarkAssignees(BeanUtils.convert(examDetailsMarkAssigneePOS, ExamDetailsMarkAssigneeBO.class));
            //StepTaskInfo
            ExamDetailsStepTaskInfoPO examDetailsStepTaskInfoPO = examDetailsStepTaskInfoDAO.selectByPrimaryKey(detailsInfoV2BO.getExamDetailsId());
            detailsInfoV2BO.setStepTaskInfo(BeanUtils.convert(examDetailsStepTaskInfoPO, ExamDetailsStepTaskInfoBO.class));
        }
        return result;
    }

    public List<ExamInfoV2BO> query(Map<String, Object> condition) {
        List<ExamInfoPO> examInfoPOList = examInfoDAO.query(condition);
        return BeanUtils.convert(examInfoPOList, ExamInfoV2BO.class);
    }

    public Integer count(Map<String, Object> condition) {
        return examInfoDAO.count(condition);
    }


    /**
     * delete exam info
     * @param examId exam id
     * @return true/false
     */
    @Transactional
    public Boolean delAllExamInfoV2(Long examId) {
        // remove the origin data
        List<ExamDetailsInfoPO> list = examDetailsDAO.queryDetailsByExamId(examId);
        examInfoDAO.deleteExamPointInputSetting(examId);
        for(ExamDetailsInfoPO detail : list){
            //examDetailsDAO.deleteExamDetailsInfo(detail.getExamDetailsId());
            examDetailsMarkAssigneeDAO.deleteByDetailsId(detail.getExamDetailsId());
            examDetailsStepTaskInfoDAO.deleteByPrimaryKey(detail.getExamDetailsId());
        }

        examQuestionMarkAssigneeDAO.deleteByExamId(examId);
        examInfoDAO.deleteExamDetailsInfo(examId);
        int status4 = examInfoDAO.deleteExamInfo(examId);
        if (status4 > 0) {
            return true;
        }
        return false;
    }


    /**
     * edit exam info
     * @param examBO exam info
     */
    @Transactional
    public Boolean editExamV2(ExamInfoV2BO examBO) {
        //delete old data
        delAllExamInfoV2(examBO.getExamId());
        //update examInfo
        addExamV2(examBO);
        return Boolean.TRUE;
    }

    /**
     * add exam info
     * @param examBO exam info
     * @return exam info
     */
    @Transactional
    public ExamInfoV2BO addExamV2(ExamInfoV2BO examBO) {
        if (examBO == null) {
            return null;
        }
        saveExam(examBO);

        if (CollectionUtils.isEmpty(examBO.getClasses()) || CollectionUtils.isEmpty(examBO.getDetails())) {
            return examBO;
        }
        saveQuestionAssignees(examBO.getDetails(), examBO.getExamId().toString());

        //detail
        List<ExamDetailsInfoPO> detailList = new ArrayList<ExamDetailsInfoPO>();
        List<ExamDetailsStepTaskInfoPO> stepTaskInfoPOList = new ArrayList<ExamDetailsStepTaskInfoPO>();
        List<ExamDetailsMarkAssigneePO> markAssigneesPOList = new ArrayList<ExamDetailsMarkAssigneePO>();
        List<ExamPointInputSettingPO> teachers = new ArrayList<ExamPointInputSettingPO>();
        for (IdNameMapBO classInfo : examBO.getClasses()) {
            //class info
            for (ExamDetailsInfoV2BO detail : examBO.getDetails()) {
                // rebuild detail data
                detail.setGradeCode(examBO.getGradeCode());
                detail.setGradeName(examBO.getGradeName());
                detail.setClassId(classInfo.getId());
                detail.setClassName(classInfo.getName());
                detail.setActualStudentNumber(Integer.parseInt(classInfo.getStudentAmount()));
                Long examDetailsId = (Long) getTokenGenerator.getToken();
                detail.setExamDetailsId(examDetailsId);
                detail.setExamId(examBO.getExamId());
                detail.setCreator(examBO.getCreator());
                detail.setCreateTime(Calendar.getInstance().getTime());
                detail.setUpdator(detail.getCreator());
                detail.setUpdateTime(detail.getCreateTime());
                // if empty, query subject and set it
                if (StringUtils.isBlank(detail.getSubjectCode()) || StringUtils.isBlank(detail.getSubjectName())) {
                    Response<GetCourseInfoResultDTO> courseInfoResultDTO = courseInfoServiceSDK.getById(detail.getCourseId(), examBO.getSchoolId());
                    detail.setSubjectCode(courseInfoResultDTO.getData().getCourseInfo().getSubjectCode());
                    detail.setSubjectName(courseInfoResultDTO.getData().getCourseInfo().getSubjectName());
                }
                detailList.add(BeanUtils.convert(detail, ExamDetailsInfoPO.class));
                // steptask info
                ExamDetailsStepTaskInfoPO stepTaskInfoPO = BeanUtils.convert(detail.getStepTaskInfo(), ExamDetailsStepTaskInfoPO.class);
                stepTaskInfoPO.setExamDetailsId(examDetailsId);
                if ("1".equals(stepTaskInfoPO.getPublishNow())) {
                    stepTaskInfoPO.setPublishTime(Calendar.getInstance().getTime());
                }
                stepTaskInfoPO.setCreateTime(Calendar.getInstance().getTime());
                stepTaskInfoPO.setUpdator(examBO.getCreator());
                stepTaskInfoPO.setUpdateTime(stepTaskInfoPO.getCreateTime());
                stepTaskInfoPOList.add(stepTaskInfoPO);
                //mark
                List<ExamDetailsMarkAssigneeBO> markAssignees = detail.getMarkAssignees();
                if (CollectionUtils.isNotEmpty(markAssignees)) {
                    for (ExamDetailsMarkAssigneeBO markAssigneeBO : markAssignees) {
                        ExamDetailsMarkAssigneePO markAssigneePO = new ExamDetailsMarkAssigneePO();
                        if (classInfo.getId().equals(markAssigneeBO.getClassId())) {
                            markAssigneePO.setExamDetailsId(examDetailsId);
                            markAssigneePO.setUserId(markAssigneeBO.getUserId());
                            markAssigneePO.setCreateTime(Calendar.getInstance().getTime());
                            markAssigneePO.setUpdateTime(markAssigneePO.getCreateTime());
                            markAssigneesPOList.add(markAssigneePO);
                        }

                    }
                }
                ExamPointInputSettingPO pointSetTeacher = new ExamPointInputSettingPO();
                pointSetTeacher.setExamDetailsId(examDetailsId);
                pointSetTeacher.setUserId(detail.getCreator());
                teachers.add(pointSetTeacher);
            }
        }
        examDetailsDAO.batchInsert(detailList);

        if (CollectionUtils.isNotEmpty(markAssigneesPOList)) {
            examDetailsMarkAssigneeDAO.batchInsert(markAssigneesPOList);
        }

        if (CollectionUtils.isNotEmpty(stepTaskInfoPOList)) {
            examDetailsStepTaskInfoDAO.batchInsert(stepTaskInfoPOList);
        }
        if (CollectionUtils.isNotEmpty(teachers)) {
            examPointInputSettingDAO.insertList(teachers);
        }
        return examBO;
    }

    /**
     * save exam info
     * @param examBO exam info
     */
    private void saveExam(ExamInfoV2BO examBO) {
        if(examBO.getExamId()==null){
            Long examId = (Long) getTokenGenerator.getToken();
            examBO.setExamId(examId);
        }
        examBO.setUpdator(examBO.getCreator());
        examBO.setCreateTime(Calendar.getInstance().getTime());
        examBO.setUpdateTime(examBO.getCreateTime());
        examInfoDAO.insertSelective(BeanUtils.convert(examBO, ExamInfoPO.class));
    }

    /**
     * save question assignees
     * @param details details
     * @param examId exam id
     */
    private void saveQuestionAssignees(List<ExamDetailsInfoV2BO> details, String examId) {
        List<ExamQuestionMarkAssigneeBO> assignees = new ArrayList<>();
        for (ExamDetailsInfoV2BO detail : details) {
            if (CollectionUtils.isEmpty(detail.getQuestionMarkAssignees())) {
                continue;
            }
            for (ExamQuestionMarkAssigneeBO assignee : detail.getQuestionMarkAssignees()) {
                assignee.setExamId(examId);
                assignee.setCourseId(detail.getCourseId());
                assignee.setCreateTime(Calendar.getInstance().getTime());
                assignee.setUpdateTime(assignee.getCreateTime());
            }
            assignees.addAll(detail.getQuestionMarkAssignees());
        }
        examQuestionMarkAssigneeService.add(assignees);
    }


    /**
     * update exam publish status, if all details has been published, modify it to 1, else to 2
     * @param examId exam id
     * @return true/false
     */
    public Boolean updatePublishStatus(Long examId) {
        Assert.notNull(examId, "exam id cannot be null!");
        return examInfoDAO.updatePublishStatus(examId) > 0;
    }
}
