package com.enableets.edu.enable.cloud.exam.manager.paper.service;


import com.enableets.edu.acm.menu.provider.util.BeanUtils;
import com.enableets.edu.enable.cloud.exam.manager.core.Constants;
import com.enableets.edu.enable.cloud.exam.manager.paper.bo.PaperInfoBO;
import com.enableets.edu.framework.core.service.ServiceAdapter;
import com.enableets.edu.sdk.assessment.ITestInfoService;
import com.enableets.edu.sdk.paper.dto.QueryPaperDTO;
import com.enableets.edu.sdk.paper.dto.QueryPaperInfoResultDTO;
import com.enableets.edu.sdk.paper.service.IPaperInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author tony_liu@enable-ets.com
 * @since 2021/6/18
 **/
@Service
@Configurable
public class PaperInfoService extends ServiceAdapter<PaperInfoBO, QueryPaperDTO> {

   /* *//** School SDK Client*//*
    @Autowired
    private IDictionaryInfoV2Service dictionaryInfoV2ServiceSDK;

    *//** School SDK Client*//*
    @Autowired
    private IGradeInfoV2Service gradeInfoV2ServiceSDK;*/

/*
    */
/** School SDK Client*//*

    @Autowired
    private IOrgSubjectService orgSubjectServiceSDK;
*/

    @Autowired
    private IPaperInfoService paperInfoServiceSDK;

/*    @Autowired
    private com.enableets.edu.enable.cloud.sdk.exam.IExamInfoService iExamInfoService;*/

    @Qualifier("paperInfoRemoteServiceSDK")
    private IPaperInfoService paperInfoRemoteServiceSDK;

    @Autowired
    private ITestInfoService testInfoServiceSDK;


/*
    */
/**
     * School Base Condition Info
     * @param schoolId
     * @return
     *//*

    @Cacheable(value = PPRConstants.PACKAGE_PPR_CACHE_KEY_PREFIX + "paper:school:condition", key = "#schoolId", unless = "#result == null")
    public BaseSearchConditionBO schoolConditionDictionary(String schoolId){
        if (StringUtils.isBlank(schoolId)) return null;
        List<QueryDictionaryInfoDTO> stageInfos = dictionaryInfoV2ServiceSDK.query(schoolId, "02", null, null, null, null, null);
        if (CollectionUtils.isEmpty(stageInfos)) return null;
        BaseSearchConditionBO condition = new BaseSearchConditionBO();
        condition.setStages(stageInfos.stream().map(e -> new StageInfoBO(e.getCode(), e.getName())).collect(Collectors.toList()));
        List<QueryGradeStageResultDTO> gradeStageInfos = gradeInfoV2ServiceSDK.query(schoolId, null, null);
        if (CollectionUtils.isEmpty(gradeStageInfos)) {
            //logger.error("Get Base Condition From School is Null, School Id is " + schoolId);
            return condition;
        }
        condition.setGrades(gradeStageInfos.stream().map(e -> new GradeInfoBO(e.getGradeCode(), e.getGradeName(), e.getStageCode())).collect(Collectors.toList()));
        List<QuerySubjectResultDTO> subjectInfos = orgSubjectServiceSDK.queryV2(schoolId, null);
        if (CollectionUtils.isEmpty(subjectInfos)) return condition;
        List<QueryStudentSelectionsResultDTO.SubjectInfoBO> subjects = new ArrayList<>();
        for (QuerySubjectResultDTO subjectInfo : subjectInfos) {
            if (CollectionUtils.isEmpty(subjectInfo.getItems())){
                for (GradeInfoBO grade : condition.getGrades()) {
                    subjects.add(new SubjectInfoBO(subjectInfo.getSubjectCode(), subjectInfo.getSubjectName(), grade.getGradeCode()));
                }
            }else{
                for (GradeInfoBO gradeBO : condition.getGrades()) {
                    for (QuerySubjectResultDTO.ItemInfoDTO subjectItemInfo : subjectInfo.getItems()) {
                        if (CollectionUtils.isNotEmpty(subjectItemInfo.getGrades())) {
                            for (QuerySubjectResultDTO.GradeInfoDTO grade : subjectItemInfo.getGrades()) {
                                if (grade.getGradeCode().equals(gradeBO.getGradeCode())) {
                                    subjects.add(new SubjectInfoBO(subjectInfo.getSubjectCode(), subjectInfo.getSubjectName(), grade.getGradeCode()));
                                }
                            }
                        }
                    }
                }
            }

        }
        condition.setSubjects(subjects);
        return condition;
    }
*/




    /**
     * 查询试卷信息列表
     *
     * @param paperInfoBO
     * @return
     */
    public HashMap<String, Object>  query(PaperInfoBO paperInfoBO) {
        HashMap<String, Object> map = new HashMap<>();
        List<QueryPaperInfoResultDTO> result = null;
        if (Constants.ZT_CODE.equals(paperInfoBO.getProviderCode()) || Constants.PROVIDER_CODE_QIUJIEDA.equals(paperInfoBO.getProviderCode())) {
            result = paperInfoRemoteServiceSDK.queryByProviderCode(BeanUtils.convert(paperInfoBO, QueryPaperDTO.class), Constants.ZT_CODE);
            Long count = paperInfoRemoteServiceSDK.count(BeanUtils.convert(paperInfoBO, QueryPaperDTO.class));
            map.put("paperList",BeanUtils.convert(result, PaperInfoBO.class));
            map.put("paperCount",count);
        } /*else if (Constants.PROVIDER_CODE_QIUJIEDA.equals(paperInfoBO.getProviderCode())) {
            long startTime = System.currentTimeMillis();
            result = qjdPaperInfoServiceSDK.query(BeanUtils.convert(paperInfoBO, QueryQJDPaperDTO.class));
            long endTime = System.currentTimeMillis();
            LOGGER.info("求解答试卷搜索耗时：" + (new BigDecimal(endTime).subtract(new BigDecimal(startTime))).
                    divide(new BigDecimal(1000)) + "S");
        }*/ else {
            QueryPaperDTO paperInfoDTO = BeanUtils.convert(paperInfoBO, QueryPaperDTO.class);
            result = paperInfoServiceSDK.query(paperInfoDTO);
            Long count = paperInfoServiceSDK.count(paperInfoDTO);
            map.put("paperList",getDispatchRecords(BeanUtils.convert(result, PaperInfoBO.class)));
            map.put("paperCount",count);
            return map;
        }
        return map;
    }

    private List<PaperInfoBO> getDispatchRecords(List<PaperInfoBO> list) {
        if(CollectionUtils.isNotEmpty(list)) {
            for (PaperInfoBO bo : list) {
                if(bo.getPaperId() != null) {
                    Integer count = testInfoServiceSDK.countDispatchRecords(bo.getPaperId().toString());
                    bo.setDispatchRecordsNum(count);
                }
            }
        }
        return list;
    }

}
