package com.enableets.edu.enable.cloud.exam.manager.paper.bo;

import java.util.List;

/**
 * 推荐题目条件BO
 * @author walle_yu@enable-ets.com
 * @since 2018年4月19日
 */
public class RecommendQuestionConditionBO {
	
	/** 年级编码*/
	private String gradeCode;
	
	/** 科目编码*/
	private String subjectCode;
	
	/** 教材版本*/
	private String materialVersion;
	
	/** 题型编码*/
	private String typeCode;
	
	/** 难易度编码*/
	private String difficultyCode;
	
	/** 知识点searchCode列表*/
	private List<String> knowledges;

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

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getDifficultyCode() {
		return difficultyCode;
	}

	public void setDifficultyCode(String difficultyCode) {
		this.difficultyCode = difficultyCode;
	}

	public List<String> getKnowledges() {
		return knowledges;
	}

	public void setKnowledges(List<String> knowledges) {
		this.knowledges = knowledges;
	}
}
