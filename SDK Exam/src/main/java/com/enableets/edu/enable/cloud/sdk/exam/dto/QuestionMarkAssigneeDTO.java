package com.enableets.edu.enable.cloud.sdk.exam.dto;

/**
 * @author duffy_ding
 * @since 2020/05/29
 */
public class QuestionMarkAssigneeDTO {

    /** exam id */
    private String examId;

    /** course id */
    private String courseId;

    /** question id */
    private String questionId;

    /** user id of teacher which marked the question */
    private String userId;

    /** user id of teacher which marked the question */
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
