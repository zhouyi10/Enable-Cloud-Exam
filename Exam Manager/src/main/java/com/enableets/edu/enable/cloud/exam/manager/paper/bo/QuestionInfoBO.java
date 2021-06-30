package com.enableets.edu.enable.cloud.exam.manager.paper.bo;


import lombok.Data;

import java.util.List;

@Data
public class QuestionInfoBO {

	/** 题目资源标识*/
	private Long questionContentId;

	/**源资源*/
	private String providerContentId;

	/** 题目类型 */
	private String questionId;

	/** 资源来源*/
	private String providerCode;

	/** 题目类型 */
	private CodeNameMapBO type;

	/** 学段标识 */
	private CodeNameMapBO stage;

	/** 年级标识 */
	private CodeNameMapBO grade;

	/** 学科标识 */
	private CodeNameMapBO subject;

	/** 能力标识 */
	private CodeNameMapBO ability;

	/* 学习表现 */
	private List<PreformanceBO> preformanceList;

	/** 难易度标识 */
	private CodeNameMapBO difficulty;

	/**题号*/
	private String questionNo;

	/** 知识点信息列表 */
	private List<KnowledgeInfoBO> knowledgeList;

	/** 题目分数 */
	private Float points;

	/** 子题目个数 */
	private Integer childAmount;

	/** 题干信息 */
	private QuestionStemInfoBO stem;

	/** 选项信息 */
	private List<QuestionOptionBO> options;
/*
	*//** 答案信息 *//*
	private AnswerInfoDTO answer;*/

	/** 听力原文*/
	private String listen;

	/** 听力文件url */
	private String affixId;

	/** 听力文件url */
	private String affix;

/*	*//** 子题目信息 *//*
	private List<QueryQuestionChildInfoResultDTO> children;*/

	/** 标签信息 */
	private List<CodeNameMapBO> tags;

	/** 学校信息 */
	private IdNameMapBO school;

	/** 用户信息 */
	private IdNameMapBO user;

	/**版本*/
	private CodeNameMapBO materialVersion;

	private String source;

	/**使用次数*/
	private Integer downloadNumber;

	/* 用途 */
	private String usageCode;
}
