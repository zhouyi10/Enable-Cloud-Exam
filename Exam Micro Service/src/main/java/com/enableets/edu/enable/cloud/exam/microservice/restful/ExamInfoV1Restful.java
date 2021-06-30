package com.enableets.edu.enable.cloud.exam.microservice.restful;

import com.enableets.edu.enable.cloud.exam.framework.bo.ExamDetailsInfoBO;
import com.enableets.edu.enable.cloud.exam.framework.bo.ExamInfoV2BO;
import com.enableets.edu.enable.cloud.exam.framework.bo.ExamQuestionMarkAssigneeBO;
import com.enableets.edu.enable.cloud.exam.framework.bo.ExamStatisticsInfoV2BO;
import com.enableets.edu.enable.cloud.exam.framework.service.ExamDetailsService;
import com.enableets.edu.enable.cloud.exam.framework.service.ExamInfoService;
import com.enableets.edu.enable.cloud.exam.framework.service.ExamQuestionMarkAssigneeService;
import com.enableets.edu.enable.cloud.exam.framework.utils.Utils;
import com.enableets.edu.enable.cloud.exam.microservice.annotation.ResponseResult;
import com.enableets.edu.enable.cloud.exam.microservice.vo.*;
import com.enableets.edu.framework.core.util.BeanUtils;
import com.enableets.edu.module.service.ETSOpenAPI;
import com.enableets.edu.module.service.controller.ServiceControllerAdapter;
import com.enableets.edu.module.service.core.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author duffy_ding
 * @since 2020/05/29
 */
@ETSOpenAPI
@Api(tags = "(v1) exam info", description = "exam info management")
@RestController
@ResponseResult
@RequestMapping("/microservice/cloud/examservice/exam")
public class ExamInfoV1Restful extends ServiceControllerAdapter<String> {

    /** exam info service */
    @Autowired
    public ExamInfoService examInfoService;

    @Autowired
    public ExamDetailsService examDetailsService;

    /** exam question assignee info service */
    @Autowired
    private ExamQuestionMarkAssigneeService examQuestionMarkAssigneeService;

    /**
     * get exam info
     * @param examId exam id
     * @return exam info
     */
    @ApiOperation(value="get exam info", notes="get exam info")
    @RequestMapping(value = "/{examId}", method = RequestMethod.GET)
    public QueryExamInfoResultVO get(@ApiParam(value="examId", required=true) @PathVariable(value = "examId", required = true) Long examId){
        ExamInfoV2BO exam = examInfoService.getV2(examId);
        return BeanUtils.convert(exam, QueryExamInfoResultVO.class);
    }

    @ApiOperation(value = "query exam info", notes = "query exam info")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<QueryExamInfoResultVO> query(
            @ApiParam(value = "school id", required = true) @RequestParam(value = "schoolId", required = true) String schoolId,
            @ApiParam(value = "term id", required = false) @RequestParam(value = "termId", required = false) String termId,
            @ApiParam(value = "user id", required = false) @RequestParam(value = "userId", required = false) String userId,
            @ApiParam(value = "exam name, fuzzy", required = false) @RequestParam(value = "examName", required = false) String examName,
            @ApiParam(value = "class id", required = false) @RequestParam(value = "classId", required = false) String classId,
            @ApiParam(value = "course id", required = false) @RequestParam(value = "courseId", required = false) String courseId,
            @ApiParam(value = "offset", required = false) @RequestParam(value = "offset", required = false) Integer offset,
            @ApiParam(value = "rows", required = false) @RequestParam(value = "rows", required = false) Integer rows) {
        Map<String, Object> condition = buildCondition(schoolId, termId, userId, examName, classId, courseId);
        condition.put("offset", Utils.offset(offset));
        condition.put("rows", Utils.rows(rows));
        return BeanUtils.convert(examInfoService.query(condition), QueryExamInfoResultVO.class);
    }

    @ApiOperation(value = "count exam info", notes = "count exam info")
    @RequestMapping(value = "/list/count", method = RequestMethod.GET)
    public Integer count(
            @ApiParam(value = "school id", required = true) @RequestParam(value = "schoolId", required = true) String schoolId,
            @ApiParam(value = "term id", required = false) @RequestParam(value = "termId", required = false) String termId,
            @ApiParam(value = "user id", required = false) @RequestParam(value = "userId", required = false) String userId,
            @ApiParam(value = "exam name, fuzzy", required = false) @RequestParam(value = "examName", required = false) String examName,
            @ApiParam(value = "class id", required = false) @RequestParam(value = "classId", required = false) String classId,
            @ApiParam(value = "course id", required = false) @RequestParam(value = "courseId", required = false) String courseId){
        Map<String, Object> condition = buildCondition(schoolId, termId, userId, examName, classId, courseId);
        return examInfoService.count(condition);
    }

    /**
     * get question assignees
     * @param examId exam id
     * @param courseId course id
     * @return true/false
     */
    @ApiOperation(value = "get question assignees", notes = "get question assignees")
    @RequestMapping(value = "/{examId}/questionassinees", method = RequestMethod.GET)
    public Response<List<QueryQuestionMarkAssigneesResultVO>> getQuestionAssignees(
            @ApiParam(required = true, value = "exam id") @PathVariable(value = "examId", required = true) String examId,
            @ApiParam(required = false, value = "course id") @RequestParam(value = "courseId", required = false) String courseId) {
        List<ExamQuestionMarkAssigneeBO> assignees = examQuestionMarkAssigneeService.getAssignees(examId, courseId);
        return responseTemplate.format(BeanUtils.convert(assignees, QueryQuestionMarkAssigneesResultVO.class));
    }

    @ApiOperation(value = "query exam details info", notes = "query exam details info")
    @RequestMapping(value = "/detail/list", method = RequestMethod.GET)
    public Response<List<ExamStatisticsResultV2VO>> queryExamDetailsInfo(
            @ApiParam(value = "school id", required = true) @RequestParam(value = "schoolId", required = true) String schoolId,
            @ApiParam(value = "term id", required = true) @RequestParam(value = "termId", required = true) String termId,
            @ApiParam(value = "class ids", required = false) @RequestParam(value = "classIds", required = false) String classIds,
            @ApiParam(value = "subject codes", required = false) @RequestParam(value = "subjectCodes", required = false) String subjectCodes,
            @ApiParam(value = "course id", required = false) @RequestParam(value = "courseId", required = false) String courseId,
            @ApiParam(value = "exam name", required = false) @RequestParam(value = "examName", required = false) String examName,
            @ApiParam(value = "offset", required = false) @RequestParam(value = "offset", required = false) Integer offset,
            @ApiParam(value = "rows", required = false) @RequestParam(value = "rows", required = false) Integer rows) {
        Map<String, Object> condition = buildConditionV2(schoolId, termId, classIds, subjectCodes, courseId, examName);
        condition.put("offset", Utils.offset(offset));
        condition.put("rows", Utils.rows(rows));
        List<ExamStatisticsInfoV2BO> exam = examDetailsService.queryExamDetailsInfoV2(condition);
        return responseTemplate.format(BeanUtils.convert(exam, ExamStatisticsResultV2VO.class));
    }

    @ApiOperation(value = "count exam details info", notes = "count exam details info")
    @RequestMapping(value = "/detail/list/count", method = RequestMethod.GET)
    public Response<Integer> countExamDetailsInfo(
            @ApiParam(value = "school id", required = true) @RequestParam(value = "schoolId", required = true) String schoolId,
            @ApiParam(value = "term id", required = true) @RequestParam(value = "termId", required = true) String termId,
            @ApiParam(value = "class ids", required = false) @RequestParam(value = "classIds", required = false) String classIds,
            @ApiParam(value = "subject codes", required = false) @RequestParam(value = "subjectCodes", required = false) String subjectCodes,
            @ApiParam(value = "course id", required = false) @RequestParam(value = "courseId", required = false) String courseId,
            @ApiParam(value = "exam name", required = false) @RequestParam(value = "examName", required = false) String examName) {
        Map<String, Object> condition = buildConditionV2(schoolId, termId, classIds, subjectCodes, courseId, examName);
        Integer result = examDetailsService.countExamDetailsInfoV2(condition);
        return responseTemplate.format(result);
    }

    /**
     * 根据考试详情id查询考试详情和考试结果
     *
     * @param examDetailsId
     * @return
     */
    @ApiOperation(value = "查询考试详情和考试结果", notes = "查询考试详情和考试结果")
    @RequestMapping(value = "/detail/{examDetailsId}", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
    public Response<QueryExamDetailsInfoResultVO> getExamDetailsByExamDetailsId(
            @ApiParam(value="考试详情标识", required=true) @PathVariable(value = "examDetailsId", required = true) Long examDetailsId) {
        ExamDetailsInfoBO examDetailsBO = examDetailsService.getExamDetailsByExamDetailsId(examDetailsId);
        return responseTemplate.format(BeanUtils.convert(examDetailsBO, QueryExamDetailsInfoResultVO.class));
    }

    private Map<String, Object> buildConditionV2(String schoolId, String termId, String classIds, String subjectCodes, String courseId, String examName) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("schoolId", schoolId);
        condition.put("termId", termId);
        condition.put("courseId", courseId);
        condition.put("name", examName);
        if (StringUtils.isNotBlank(classIds)) {
            condition.put("classIdList", Arrays.asList(classIds.split(",")));
        }
        if (StringUtils.isNotBlank(subjectCodes)) {
            condition.put("subjectCodeList", Arrays.asList(subjectCodes.split(",")));
        }
        return condition;
    }

    /**
     * build query condition
     * @param schoolId school id
     * @param termId term id
     * @param userId user id
     * @param examName exam name
     * @param classId class id
     * @param courseId course id
     * @return condition map
     */
    private Map<String, Object> buildCondition(String schoolId, String termId, String userId, String examName, String classId, String courseId) {
        Map<String, Object> condition = new HashMap<>();
        condition.put("schoolId", schoolId);
        condition.put("termId", termId);
        condition.put("userId", userId);
        condition.put("name", examName);
        condition.put("classId", classId);
        condition.put("courseId", courseId);
        return condition;
    }


    /**
     * 通过条件，删除：exam_info，exam_details_info，
     * exam_details_step_task_info;exam_details_mark_assignee的有关数据
     * @param examId
     * @return Boolean
     */
    @ApiOperation(value = "I_50_01_v1_011", notes = "I_50_01_v1_011")
    @RequestMapping(value = "/exams/{examId}", method = RequestMethod.DELETE)
    public Response<Boolean> deleteByExamIdV2(
            @ApiParam(required = true, value = "I_50_01_01_006")@PathVariable(value="examId", required=true) Long examId){
        //执行删除，返回状态
        Boolean status = examInfoService.delAllExamInfoV2(examId);

        return responseTemplate.format(status);
    }

    /**
     * edit exam info
     * @param examId exam id
     * @param editExamInfoV2VO exam info
     * @return
     */
    @ApiOperation(value="I_50_01_v1_009", notes="I_50_01_v1_009")
    @RequestMapping(value="/exams/{examId}", method = RequestMethod.PUT)
    public Response<Boolean> editExam(
            @ApiParam(required = true, value = "I_50_01_01_006") @PathVariable(value = "examId", required = true) String examId,
            @ApiParam(value="I_50_01_v1_010", required=true) @RequestBody EditExamInfoV2VO editExamInfoV2VO){
        examInfoService.editExamV2(BeanUtils.convert(editExamInfoV2VO, ExamInfoV2BO.class));
        return responseTemplate.format(Boolean.TRUE);
    }

    /**
     * add exam info
     * @param param exam info
     * @return exam id
     */
    @ApiOperation(value = "I_50_01_v1_006", notes = "I_50_01_v1_006")
    @RequestMapping(value = "/exams", method = RequestMethod.POST)
    public Response<QueryExamInfoResultV2VO> add(@ApiParam(value="I_50_01_v1_008", required=true) @RequestBody AddExamInfoV2VO param){
        ExamInfoV2BO exam = examInfoService.addExamV2(BeanUtils.convert(param, ExamInfoV2BO.class));
        return responseTemplate.format(BeanUtils.convert(exam, QueryExamInfoResultV2VO.class));
    }


    /**
     * bind activity id to detail
     * @param examDetailsIds exam details ids, join them with comma if multiple
     * @param activityId related activity id
     * @return true/false
     */
    @ApiOperation(value = "I_50_01_v1_012", notes = "I_50_01_v1_012")
    @RequestMapping(value = "/exams/details/steptask/bind", method = RequestMethod.PUT)
    public Response<Boolean> bindStepTask(
            @ApiParam(required = true, value = "I_50_01_v1_013") @RequestParam(value = "examDetailsIds", required = true) String examDetailsIds,
            @ApiParam(required = true, value = "I_50_01_v1_014") @RequestParam(value = "activityId", required = true) String activityId) {
        boolean result = examDetailsService.bindStepTask(examDetailsIds, activityId);
        return responseTemplate.format(result);
    }

}
