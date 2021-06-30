package com.enableets.edu.enable.cloud.exam.manager.paper.bo;

import java.util.List;

/**
 * 试卷信息对象bo
 * 
 * @author duffy_ding
 * @since 2018/01/02
 */
public class PaperInfoBO {

	/** 试卷标识 */
	private Long paperId;
	
	/** 3.0资源标识*/
	private Long contentId;
	
	/** 2.0资源标识*/
	private String providerContentId;

	/** 试卷名称 */
	private String name;

	/**
	 * 学段标识
	 * 1 幼儿园, 2 小学, 3 初中, 4 高中
	 */
	private CodeNameMapBO stage;

	/**
	 * 年级标识
	 * 12 思想品德(政治), 13 语文, 14 数学, 16 物理, 17 化学, 18 生物, 20 地理
	 * 21 历史, 40 英语,
	 */
	private CodeNameMapBO grade;

	/** 学科标识 */
	private CodeNameMapBO subject;

	/** 试卷总分 */
	private Float totalPoints;

	/** 标签信息 */
	private List<CodeNameMapBO> tags;

	/** 试卷节点信息 */
	private List<PaperNodeInfoBO> nodes;

	/** 派卷人员信息 */
	private IdNameMapBO user;

	/** 学校信息 */
	private IdNameMapBO school;

	/** 创建时间 */
	private java.util.Date createTime;

	/** 更新者 */
	private String updator;

	/** 更新时间 */
	private java.util.Date updateTime;

	/** 资源来源的系统编码 */
	private String providerCode;

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
	 * 教材版本
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
	private String examName;

	/**
	 * 标签
	 */
	private String tag;

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

	private String usageCode;

	/**
	 * 区域编码
	 */
	private String zoneCode;

	/**
	 * 区域名称
	 */
	private String zoneName;

	/**
	 * 资本作业文件集合
	 **/
	private List<PaperWorkFileBO> paperWorkFileList;

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

	private List<KnowledgeInfoBO> knowledges;

	public List<KnowledgeInfoBO> getKnowledges() {
		return knowledges;
	}

	public void setKnowledges(List<KnowledgeInfoBO> knowledges) {
		this.knowledges = knowledges;
	}

	public Integer getDispatchRecordsNum() {
		return dispatchRecordsNum;
	}

	public void setDispatchRecordsNum(Integer dispatchRecordsNum) {
		this.dispatchRecordsNum = dispatchRecordsNum;
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

	public CodeNameMapBO getStage() {
		return stage;
	}

	public void setStage(CodeNameMapBO stage) {
		this.stage = stage;
	}

	public CodeNameMapBO getGrade() {
		return grade;
	}

	public void setGrade(CodeNameMapBO grade) {
		this.grade = grade;
	}

	public CodeNameMapBO getSubject() {
		return subject;
	}

	public void setSubject(CodeNameMapBO subject) {
		this.subject = subject;
	}

	public Float getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(Float totalPoints) {
		this.totalPoints = totalPoints;
	}

	public List<CodeNameMapBO> getTags() {
		return tags;
	}

	public void setTags(List<CodeNameMapBO> tags) {
		this.tags = tags;
	}

	public List<PaperNodeInfoBO> getNodes() {
		return nodes;
	}

	public void setNodes(List<PaperNodeInfoBO> nodes) {
		this.nodes = nodes;
	}

	public IdNameMapBO getUser() {
		return user;
	}

	public void setUser(IdNameMapBO user) {
		this.user = user;
	}

	public IdNameMapBO getSchool() {
		return school;
	}

	public void setSchool(IdNameMapBO school) {
		this.school = school;
	}

	public java.util.Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdator() {
		return updator;
	}

	public void setUpdator(String updator) {
		this.updator = updator;
	}

	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getProviderCode() {
		return providerCode;
	}

	public void setProviderCode(String providerCode) {
		this.providerCode = providerCode;
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

	public String getZoneCode() {
		return zoneCode;
	}

	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public List<PaperWorkFileBO> getPaperWorkFileList() {
		return paperWorkFileList;
	}

	public void setPaperWorkFileList(List<PaperWorkFileBO> paperWorkFileList) {
		this.paperWorkFileList = paperWorkFileList;
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
