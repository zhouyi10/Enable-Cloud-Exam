package com.enableets.edu.enable.cloud.sdk.exam.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class QueryExamInfoResultDTO implements Serializable {

	/**
     * 考试标识
     */
    private String examId;

    /**
     * 考试名称
     */
    private String name;

    /**
     * 考试类型
     */
    private String type;

    /**
     * 考试类型
     */
    private String typeName;

    /**
     * 学校标识
     */
    private String schoolId;

    /**
     * 学校编码
     */
    private String schoolCode;

    /**
     * 学年
     */
    private String schoolYear;

	/**
	 * 不包含的学期标识
	 */
	private String excludeTermId;

    /**
     * 学期标识
     */
    private String termId;

    /**
     * 学期名称
     */
    private String termName;

    /**
     * 学段
     */
    private String gradeStage;

    private String gradeCode;

    private String gradeName;

    /** exam publish status, default 0, if all details is published, it's 1, else 2 */
    private String publishStatus;

    /** 创建者*/
    private String creator;

    /**
     * 班级
     */
    private List<IdNameMapDTO> classes;

    private List<QueryExamDetailsResultDTO> details;

}
