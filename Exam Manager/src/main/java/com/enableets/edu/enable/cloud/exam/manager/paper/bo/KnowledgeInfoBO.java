package com.enableets.edu.enable.cloud.exam.manager.paper.bo;

/**
 * 知识点相关信息
 * @author duffy_ding
 * @since 2018/03/08
 */
public class KnowledgeInfoBO {

	/**
	 * 知识点id
	 */
	private String knowledgeId;

	/**
	 * 知识点名称
	 */
	private String knowledgeName;
	
	/**
	 * 检索码
	 */
	private String searchCode;

	/**
	 * 版本
	 */
	private String materialVersion;

	/**
	 * 版本名称
	 */
	private String materialVersionName;

	/** 知识点编号*/
	private String knowledgeNo;

	/** 教纲searchCode*/
	private String outlineId;

	public String getKnowledgeId() {
		return knowledgeId;
	}

	public void setKnowledgeId(String knowledgeId) {
		this.knowledgeId = knowledgeId;
	}

	public String getKnowledgeName() {
		return knowledgeName;
	}

	public void setKnowledgeName(String knowledgeName) {
		this.knowledgeName = knowledgeName;
	}

	public String getSearchCode() {
		return searchCode;
	}

	public void setSearchCode(String searchCode) {
		this.searchCode = searchCode;
	}

	public String getMaterialVersion() {
		return materialVersion;
	}

	public void setMaterialVersion(String materialVersion) {
		this.materialVersion = materialVersion;
	}

	public String getMaterialVersionName() {
		return materialVersionName;
	}

	public void setMaterialVersionName(String materialVersionName) {
		this.materialVersionName = materialVersionName;
	}

	public String getKnowledgeNo() {
		return knowledgeNo;
	}

	public void setKnowledgeNo(String knowledgeNo) {
		this.knowledgeNo = knowledgeNo;
	}

	public String getOutlineId() {
		return outlineId;
	}

	public void setOutlineId(String outlineId) {
		this.outlineId = outlineId;
	}
}
