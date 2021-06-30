package com.enableets.edu.enable.cloud.exam.manager.bo.xkw;

import lombok.Data;

/**
 * 试卷头部信息
 *
 * @author caleb_liu@enable-ets.com
 * @since 2020/09/01 13:48
 **/

@Data
public class XKWPaperHeadBO {

    /* 2020-2021学年度???学校8月月考卷 */
    private String mainTitle;

    /* 1．答题前填写好自己的姓名、班级、考号等信息\\r\\n2．请将答案正确填写在答题卡上 */
    private String notice;

    /* 学校:___________姓名：___________班级：___________考号：___________ */
    private String studentInput;

    /* 试卷副标题 */
    private String subTitle;

    /* 考试范围：xxx；考试时间：100分钟；命题人：xxx */
    private String testInfo;
}
