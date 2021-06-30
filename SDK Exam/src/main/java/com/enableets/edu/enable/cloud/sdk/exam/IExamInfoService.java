package com.enableets.edu.enable.cloud.sdk.exam;

import com.enableets.edu.enable.cloud.sdk.exam.dto.*;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IExamInfoService {

    /**
     * get exam info
     * @param examId exam id
     * @return exam info
     */
    QueryExamInfoResultDTO get(Long examId);

    /**
     * query exam infos
     * @param param condition
     * @return exam infos
     */
    List<QueryExamInfoResultDTO> query(QueryExamInfoDTO param);

    /**
     * query exam count
     * @param param condition
     * @return count
     */
   Integer count(QueryExamInfoDTO param);

    /**
     * get question assignees
     * @param examId exam id
     * @param courseId course id
     * @return question assignee infos
     */
    List<QuestionMarkAssigneeDTO> getQuestionAssignees(String examId, String courseId);

    /**
     * query exam infos
     * @param param condition
     * @return exam infos
     */
    List<ExamStatisticsResultV2DTO> queryExamDetailsInfo(QueryExamStatisticsV2DTO param);

    /**
     * query exam count
     * @param param condition
     * @return count
     */
    Integer countExamDetailsInfo(QueryExamStatisticsV2DTO param);

    /**
     * 根据考试详情id查询考试信息和考试结果
     * @param examDetailsId
     * @return
     */
    public QueryExamDetailsInfoResultDTO getExamDetailsByExamDetailsId(Long examDetailsId);

    /**
     * Delete all administrator-related information through examId
     * @param examId
     *
     */
    public Boolean deleteAllExamInfoV2(Long examId);

    /**
     * edit exam info
     * @param param
     * @return
     */
    public Boolean edit(@RequestBody EditExamInfoV2DTO param);

    /**
     * add exam info
     * @param param exam info
     * @return exam id
     */
    public QueryExamInfoResultV2DTO add(@RequestBody AddExamInfoV2DTO param);

    /**
     * bind activity id to detail
     * @param examDetailsIds exam details ids, join them with comma if multiple
     * @param activityId related activity id
     * @return true/false
     */
    public Boolean bindStepTask(String examDetailsIds, String activityId);

}
