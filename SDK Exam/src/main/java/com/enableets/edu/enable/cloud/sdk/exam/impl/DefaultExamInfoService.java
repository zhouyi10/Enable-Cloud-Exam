package com.enableets.edu.enable.cloud.sdk.exam.impl;

import com.enableets.edu.enable.cloud.sdk.exam.IExamInfoService;
import com.enableets.edu.enable.cloud.sdk.exam.feign.IExamInfoServiceFeignClient;
import com.enableets.edu.enable.cloud.sdk.exam.dto.*;

import java.util.List;

/**
 * exam info service
 * @author duffy_ding
 * @since 2020/05/29
 */
public class DefaultExamInfoService implements IExamInfoService {

    private IExamInfoServiceFeignClient examInfoV1ServiceFeignClient;

    public DefaultExamInfoService(IExamInfoServiceFeignClient examInfoV1ServiceFeignClient) {
        this.examInfoV1ServiceFeignClient = examInfoV1ServiceFeignClient;
    }

    @Override
    public QueryExamInfoResultDTO get(Long examId) {
        return examInfoV1ServiceFeignClient.get(examId).getData();
    }

    @Override
    public List<QueryExamInfoResultDTO> query(QueryExamInfoDTO param) {
        return examInfoV1ServiceFeignClient.query(param.getSchoolId(), param.getTermId(), param.getUserId(), param.getExamName(), param.getClassId(), param.getCourseId(), param.getOffset(), param.getRows()).getData();
    }

    @Override
    public Integer count(QueryExamInfoDTO param) {
        return examInfoV1ServiceFeignClient.count(param.getSchoolId(), param.getTermId(), param.getUserId(), param.getExamName(), param.getClassId(), param.getCourseId()).getData();
    }

    @Override
    public List<QuestionMarkAssigneeDTO> getQuestionAssignees(String examId, String courseId) {
        return examInfoV1ServiceFeignClient.getQuestionAssignees(examId, courseId).getData();
    }

    @Override
    public List<ExamStatisticsResultV2DTO> queryExamDetailsInfo(QueryExamStatisticsV2DTO param) {
        return examInfoV1ServiceFeignClient.queryExamDeailsInfo(param.getSchoolId(), param.getTermId(), param.getClassIds(), param.getSubjectCodes(), param.getCourseId(), param.getExamName(), param.getOffset(), param.getRows()).getData();
    }

    @Override
    public Integer countExamDetailsInfo(QueryExamStatisticsV2DTO param) {
        return examInfoV1ServiceFeignClient.countExamDeailsInfo(param.getSchoolId(), param.getTermId(), param.getClassIds(), param.getSubjectCodes(), param.getCourseId(), param.getExamName()).getData();
    }

    @Override
    public QueryExamDetailsInfoResultDTO getExamDetailsByExamDetailsId(Long examDetailsId) {
        return examInfoV1ServiceFeignClient.getExamDetailsByExamDetailsId(examDetailsId).getData();
    }


    @Override
    public Boolean deleteAllExamInfoV2(Long examId) {
        return examInfoV1ServiceFeignClient.removeAllExamInfo(examId).getData();
    }

    @Override
    public Boolean edit(EditExamInfoV2DTO param) {
        return examInfoV1ServiceFeignClient.edit(Long.valueOf(param.getExamId()), param).getData();
    }

    @Override
    public QueryExamInfoResultV2DTO add(AddExamInfoV2DTO param) {
        return examInfoV1ServiceFeignClient.add(param).getData();
    }

    @Override
    public Boolean bindStepTask(String examDetailsIds, String activityId) {
        return examInfoV1ServiceFeignClient.bindStepTask(examDetailsIds, activityId).getData();
    }
}
