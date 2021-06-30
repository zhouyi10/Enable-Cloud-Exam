package com.enableets.edu.enable.cloud.exam.framework.bo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: yvonne_yu
 * @Date:  20200521
 * @Description: 考试信息BO
 */
@Data
@Accessors(chain = true)
public class ExamInfoV2BO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3241898777959719060L;


	/**
     * 考试标识
     */
    private Long examId;

    /**
     * 考试名称
     */
    private String name;

    /**
     * 考试类型
     */
    private String type;

    /**
     * 考试类型名称
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

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改者
     */
    private String updator;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 班级
     */
    private List<IdNameMapBO> classes;
    
    private  List<ExamDetailsInfoV2BO> details;

    /**
     * 笔数
     */
    private Integer rows;
    /**
     * 当前页
     */
    private Integer offset;

}
