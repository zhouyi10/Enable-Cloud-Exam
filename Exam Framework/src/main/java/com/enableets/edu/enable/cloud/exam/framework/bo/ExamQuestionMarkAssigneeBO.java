package com.enableets.edu.enable.cloud.exam.framework.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * the teacher info in exam which marked the question
 * @author duffy_ding
 * @since 2020/05/29
 */
@Data
@Accessors(chain = true)
public class ExamQuestionMarkAssigneeBO {

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

    /** creator */
    private String creator;

    /** create time */
    private Date createTime;

    /** updater*/
    private String updator;

    /** update time */
    private Date updateTime;

}
