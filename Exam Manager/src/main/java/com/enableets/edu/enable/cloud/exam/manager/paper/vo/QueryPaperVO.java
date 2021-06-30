package com.enableets.edu.enable.cloud.exam.manager.paper.vo;

import com.enableets.edu.enable.cloud.exam.manager.paper.core.LongJsonDeserializer;
import com.enableets.edu.enable.cloud.exam.manager.paper.core.LongJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 查询试卷信息对象
 * 
 * @author duffy_ding
 * @since 2018/03/14
 */
public class QueryPaperVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 学校id
	 */
	private String schoolId;

	/**
	 * 学段code
	 */
	private String stageCode;

	/**
	 * 年级code
	 */
	private String gradeCode;

	/**
	 * 科目code
	 */
	private String subjectCode;

	/**
	 * 资源来源code
	 */
	private String providerCode;

	/**
	 * 教材版本号
	 */
	private String materialVersion;

	/**
	 * 知识点
	 */
	private String searchCode;

	public String getSearchCode() {
		return searchCode;
	}

	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}

	/**
	 * 关键词
	 */
	// @Mapping(value = "keyword")
	private String examName;

	/**
	 * 标签
	 */
	private String tag;

	/**
	 * 资源状态
	 */
	private String status;

	/**
	 * 资源创建者id
	 */
	private String creator;

	/**
	 * 试卷类型 2 教师试卷 3 纸本作业
	 */
	private String paperType;

	/**
	 * 分页-起始位
	 */
	private Integer offset;

	/**
	 * 分页-查询笔数
	 */
	private Integer rows;

	/** 试卷标识 */
	@JsonSerialize(using = LongJsonSerializer.class)
	@JsonDeserialize(using = LongJsonDeserializer.class)
	private Long paperId;
	
	/** 3.0资源标识*/
	@JsonSerialize(using = LongJsonSerializer.class)
	@JsonDeserialize(using = LongJsonDeserializer.class)
	private Long contentId;
	
	/** 2.0资源标识*/
	private String providerContentId;

	/** 试卷名称 */
	private String name;

	/** 用户信息 */
	private IdNameMapVO user;

	/** 年级信息 */
	private CodeNameMapVO grade;

	/** 学科信息 */
	private CodeNameMapVO subject;

	/** 标签信息 */
	private List<CodeNameMapVO> tags;

	/** 创建时间 */
	private Date createTime;

	/** 在何处使用标识 */
	private String usageCode;

	/** 极值试卷年份 **/
	private String year;

	/** 极值省份id **/
	private String provinceId;

	/** 极值城市id **/
	private String cityId;

	/** 极值试卷类型id **/
	private String examTypeId;

	/**
	 * 派卷次数
	 */
	private Integer dispatchRecordsNum;

	public Integer getDispatchRecordsNum() {
		return dispatchRecordsNum;
	}

	public void setDispatchRecordsNum(Integer dispatchRecordsNum) {
		this.dispatchRecordsNum = dispatchRecordsNum;
	}

	public String getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(String schoolId) {
		this.schoolId = schoolId;
	}

	public String getStageCode() {
		return stageCode;
	}

	public void setStageCode(String stageCode) {
		this.stageCode = stageCode;
	}

	public String getGradeCode() {
		return gradeCode;
	}

	public void setGradeCode(String gradeCode) {
		this.gradeCode = gradeCode;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getProviderCode() {
		return providerCode;
	}

	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
	}

	public String getMaterialVersion() {
		return materialVersion;
	}

	public void setMaterialVersion(String materialVersion) {
		this.materialVersion = materialVersion;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Long getPaperId() {
		return paperId;
	}

	public void setPaperId(Long paperId) {
		this.paperId = paperId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IdNameMapVO getUser() {
		return user;
	}

	public void setUser(IdNameMapVO user) {
		this.user = user;
	}

	public CodeNameMapVO getGrade() {
		return grade;
	}

	public void setGrade(CodeNameMapVO grade) {
		this.grade = grade;
	}

	public CodeNameMapVO getSubject() {
		return subject;
	}

	public void setSubject(CodeNameMapVO subject) {
		this.subject = subject;
	}

	public List<CodeNameMapVO> getTags() {
		return tags;
	}

	public void setTags(List<CodeNameMapVO> tags) {
		this.tags = tags;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getContentId() {
		return contentId;
	}

	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}

	public String getProviderContentId() {
		return providerContentId;
	}

	public void setProviderContentId(String providerContentId) {
		this.providerContentId = providerContentId;
	}

	public String getUsageCode() {
		return usageCode;
	}

	public void setUsageCode(String usageCode) {
		this.usageCode = usageCode;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getExamTypeId() {
		return examTypeId;
	}

	public void setExamTypeId(String examTypeId) {
		this.examTypeId = examTypeId;
	}
}
