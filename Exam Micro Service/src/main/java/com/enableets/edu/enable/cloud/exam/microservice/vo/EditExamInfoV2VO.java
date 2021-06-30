package com.enableets.edu.enable.cloud.exam.microservice.vo;

import com.enableets.edu.enable.cloud.exam.framework.core.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * @Auther: yvonne_yu
 * @Date:  2020/06/04
 * @Description: 考试信息
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class EditExamInfoV2VO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3241898777959719060L;


	/**
     * 考试标识
     */
	/** 考试标识*/
	@ApiModelProperty(value = "I_50_01_04_019", required = true)
    private String examId;

    /**
     * 考试名称
     */
	@ApiModelProperty(value = "I_50_01_04_034", required = false)
    private String name;

    /**
     * 考试类型
     */
	@ApiModelProperty(value = "I_50_01_04_035", required = false)
    private String type;

    /**
     * 学校标识
     */
    private String schoolId;

    /**
     * 学校编码
     */
    private String schoolCode;

    /**
     * 学校编码
     */
    private String schoolName;

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

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = Constants.DEFAULT_DATE_TIME_FORMAT)
    @JsonFormat(pattern = Constants.DEFAULT_DATE_TIME_FORMAT)
    private Date createTime;

    /**
     * 修改者
     */
    private String updator;

    /**
     * 修改时间
     */
    @DateTimeFormat(pattern = Constants.DEFAULT_DATE_TIME_FORMAT)
    @JsonFormat(pattern = Constants.DEFAULT_DATE_TIME_FORMAT)
    private Date updateTime;

    /**
     * 班级
     */
    private List<IdNameMapVO> classes;
    
    
    private  List<AddExamDetailsInfoV2VO> details;

    public String getExamId() {
        return examId;
    }

    public void setExamId(String examId) {
        this.examId = examId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getExcludeTermId() {
        return excludeTermId;
    }

    public void setExcludeTermId(String excludeTermId) {
        this.excludeTermId = excludeTermId;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getGradeStage() {
        return gradeStage;
    }

    public void setGradeStage(String gradeStage) {
        this.gradeStage = gradeStage;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdator() {
        return updator;
    }

    public void setUpdator(String updator) {
        this.updator = updator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public List<IdNameMapVO> getClasses() {
        return classes;
    }

    public void setClasses(List<IdNameMapVO> classes) {
        this.classes = classes;
    }

    public List<AddExamDetailsInfoV2VO> getDetails() {
        return details;
    }

    public void setDetails(List<AddExamDetailsInfoV2VO> details) {
        this.details = details;
    }
}
