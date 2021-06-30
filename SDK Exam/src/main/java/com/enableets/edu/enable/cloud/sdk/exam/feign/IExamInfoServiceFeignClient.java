package com.enableets.edu.enable.cloud.sdk.exam.feign;

import com.enableets.edu.enable.cloud.sdk.exam.dto.*;
import com.enableets.edu.sdk.core.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * exam info manager
 * @author duffy_ding
 * @since 2020/05/29
 */
@FeignClient(value = "${sdk.enable-cloud-exam-microservice.name:enable-cloud-exam-manager}")
public interface IExamInfoServiceFeignClient {

    /**
     * get exam info
     * @param examId exam id
     * @return exam info
     */
    @RequestMapping(value = "/microservice/cloud/examservice/exam/{examId}", method = RequestMethod.GET)
    public Response<QueryExamInfoResultDTO> get(@PathVariable(value="examId", required = true) Long examId);


    /**
     * query exam infos
     * @param schoolId school id
     * @param termId term id
     * @param userId user id
     * @param examName exam name
     * @param classId class id
     * @param courseId course id
     * @param offset offset
     * @param rows rows
     * @return exam infos
     */
    @RequestMapping(value = "/microservice/cloud/examservice/exam/list", method = RequestMethod.GET)
    Response<List<QueryExamInfoResultDTO>> query(
            @RequestParam(value = "schoolId", required = true) String schoolId,
            @RequestParam(value = "termId", required = false) String termId,
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "examName", required = false) String examName,
            @RequestParam(value = "classId", required = false) String classId,
            @RequestParam(value = "courseId", required = false) String courseId,
            @RequestParam(value = "offset", required = false) Integer offset,
            @RequestParam(value = "rows", required = false) Integer rows);

    /**
     * query exam count
     * @param schoolId school id
     * @param termId term id
     * @param userId user id
     * @param examName exam name
     * @param classId class id
     * @param courseId course id
     * @return count
     */
    @RequestMapping(value = "/microservice/cloud/examservice/exam/list/count", method = RequestMethod.GET)
    Response<Integer> count(
            @RequestParam(value = "schoolId", required = true) String schoolId,
            @RequestParam(value = "termId", required = false) String termId,
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "examName", required = false) String examName,
            @RequestParam(value = "classId", required = false) String classId,
            @RequestParam(value = "courseId", required = false) String courseId);

    /**
     * get question assignees
     * @param examId exam id
     * @param courseId course id
     * @return question assignee infos
     */
    @RequestMapping(value = "/microservice/cloud/examservice/exam/{examId}/questionassinees", method = RequestMethod.GET)
    public Response<List<QuestionMarkAssigneeDTO>> getQuestionAssignees(
            @PathVariable(value = "examId", required = true) String examId, @RequestParam(value = "courseId", required = false) String courseId);

    /**
     * query exam details info
     * @param schoolId
     * @param termId
     * @param classIds
     * @param subjectCodes
     * @param courseId
     * @param offset
     * @param rows
     * @return exam details
     */
    @RequestMapping(value = "/microservice/cloud/examservice/exam/detail/list", method = RequestMethod.GET)
    Response<List<ExamStatisticsResultV2DTO>> queryExamDeailsInfo(
            @RequestParam(value = "schoolId", required = true) String schoolId,
            @RequestParam(value = "termId", required = true) String termId,
            @RequestParam(value = "classIds", required = false) String classIds,
            @RequestParam(value = "subjectCodes", required = false) String subjectCodes,
            @RequestParam(value = "courseId", required = false) String courseId,
            @RequestParam(value = "examName", required = false) String examName,
            @RequestParam(value = "offset", required = false) Integer offset,
            @RequestParam(value = "rows", required = false) Integer rows);

    /**
     * query exam details count
     * @param schoolId
     * @param termId
     * @param classIds
     * @param subjectCodes
     * @param courseId
     * @return count
     */
    @RequestMapping(value = "/microservice/cloud/examservice/exam/detail/list/count", method = RequestMethod.GET)
    Response<Integer> countExamDeailsInfo(
            @RequestParam(value = "schoolId", required = true) String schoolId,
            @RequestParam(value = "termId", required = true) String termId,
            @RequestParam(value = "classIds", required = false) String classIds,
            @RequestParam(value = "subjectCodes", required = false) String subjectCodes,
            @RequestParam(value = "courseId", required = false) String courseId,
            @RequestParam(value = "examName", required = false) String examName);

    /**
     * 根据考试详情id查询考试详情和考试结果
     * @param examDetailsId
     * @return
     */
    @RequestMapping(value="/microservice/cloud/examservice/exam/detail/{examDetailsId}", method = RequestMethod.GET)
    public Response<QueryExamDetailsInfoResultDTO> getExamDetailsByExamDetailsId(@PathVariable(value="examDetailsId", required = true) Long examDetailsId);
    /**
     * delete exam info
     * @param examId
     * @return
     */
    @RequestMapping(value = "/microservice/cloud/examservice/exam/exams/{examId}", method = RequestMethod.DELETE)
    public Response<Boolean> removeAllExamInfo(@PathVariable(value = "examId", required = true)Long examId);

    /**
     * edit exam info
     * @param param exam info
     * @return exam id
     */
    @RequestMapping(value = "/microservice/cloud/examservice/exam/exams/{examId}", method = RequestMethod.PUT)
    public Response<Boolean> edit(@PathVariable(value = "examId", required = true)Long examId,@RequestBody EditExamInfoV2DTO param);

    /**
     * add exam info
     * @param param exam info
     * @return exam id
     */
    @RequestMapping(value = "/microservice/cloud/examservice/exam/exams", method = RequestMethod.POST)
    public Response<QueryExamInfoResultV2DTO> add(@RequestBody AddExamInfoV2DTO param);

    /**
     * bind activity id to detail
     *
     * @param examDetailsIds exam details ids, join them with comma if multiple
     * @param activityId     related activity id
     * @return true/false
     */
    @RequestMapping(value = "/microservice/cloud/examservice/exam/exams/details/steptask/bind", method = RequestMethod.PUT)
    public Response<Boolean> bindStepTask(
            @RequestParam(value = "examDetailsIds", required = true) String examDetailsIds, @RequestParam(value = "activityId", required = true) String activityId);

}
