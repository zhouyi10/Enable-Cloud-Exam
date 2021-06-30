package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddExamResultInfoDTO {
    /**
     * 考试明细id
     */
    private Long examDetailsId;

    /**
     * 学生姓名
     */
    private String studentFullName;

    /**
     * 学籍号
     */
    private String studentCode;

    /**
     * 学号(座位号)
     */
    private String studentNo;

    /**
     * 学生标识
     */
    private String studentUserId;

    /**
     * 参考情况
     */
    private String status;

    /**
     * A卷分
     */
    private Float aPoint;

    /**
     * B卷分
     */
    private Float bPoint;

    /**
     * 附加分
     */
    private Float additionalPoint;

    /**
     * 标准分
     */
    private Float standardPoint;

    /**
     * 总分
     */
    private Float totalPoint;
    /**
     * 分数等级
     */
    private String level;

    /**
     * 评语
     */
    private String comment;

    private String contentId;
    
    private String creator;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    
    private String updator;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 教师id
     */
    private String teacherUserId;
    /**
     * 教师名字
     */
    private String teacherFullName;

    private String subjectName;
    
}
