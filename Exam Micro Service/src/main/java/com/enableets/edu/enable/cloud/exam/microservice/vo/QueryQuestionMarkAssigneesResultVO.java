package com.enableets.edu.enable.cloud.exam.microservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author duffy_ding
 * @since 2020/05/29
 */
@ApiModel(value = "queryQuestionMarkAssigneesResultVO", description = "the teacher info in exam which marked the question")
public class QueryQuestionMarkAssigneesResultVO {

    /** exam id */
    @ApiModelProperty(value = "exam id")
    private String examId;

    /** course id */
    @ApiModelProperty(value = "course id")
    private String courseId;

    /** question id */
    @ApiModelProperty(value = "question id")
    private String questionId;

    /** user id of teacher which marked the question */
    @ApiModelProperty(value = "user id of teacher which marked the question")
    private String userId;

    /** user id of teacher which marked the question */
    @ApiModelProperty(value = "user name of teacher which marked the question")
    private String fullName;

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
