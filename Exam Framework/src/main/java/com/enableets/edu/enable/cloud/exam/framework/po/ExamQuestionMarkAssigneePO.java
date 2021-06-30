package com.enableets.edu.enable.cloud.exam.framework.po;

import com.enableets.edu.framework.core.dao.BasePO;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * the teacher info in exam which marked the question
 * @author duffy_ding
 * @since 2020/05/29
 */
@Entity
@Table(name = "exam_question_mark_assignee")
public class ExamQuestionMarkAssigneePO extends BasePO {

    /** exam id */
    @Id
    @Column(name = "exam_id")
    private String examId;

    /** course id */
    @Id
    @Column(name = "course_id")
    private String courseId;

    /** question id */
    @Id
    @Column(name = "question_id")
    private String questionId;

    /** user id of teacher which marked the question */
    @Id
    @Column(name = "user_id")
    private String userId;

    /** user id of teacher which marked the question */
    @Column(name = "full_name")
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
