package com.enableets.edu.enable.cloud.exam.manager.bo.xkw;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 学科网题目信息
 *
 * @author caleb_liu@enable-ets.com
 * @since 2020/09/01 13:56
 **/

@Data
public class XKWQuestionBO {

    /* 区域信息*/
    private List<XKWIdNameBO> areas;


    private Date auditTime;

    /* 知识点目录 */
    private List<List<XKWIdNameBO>> categories;

    /* 章节目录 */
    private List<List<XKWIdNameBO>> chapters;

    /* 无数据 未知格式 */
    private List<XKWChildQuestionBO> childQues;

    private String from;

    private List<XKWGradeBO> grades;

    private Long id;

    private String knowledge;

    private List<XKWIdNameBO> options;

    private List<XKWIdNameBO> paperTypes;

    private String qbmId;

    private String quesAnswer;

    private XKWIdNameBO quesAttribute;

    private String quesBody;

    private Integer quesChildNum;

    private XKWIdNameBO quesDiff;

    private Float quesDiffValue;

    private String quesGuid;

    private String quesParse;

    private Float quesScore;

    private Integer quesStar;

    private XKWQuestionTypeBO quesType;

    private Date time;

    private String title;

    private Integer useSum;
}
