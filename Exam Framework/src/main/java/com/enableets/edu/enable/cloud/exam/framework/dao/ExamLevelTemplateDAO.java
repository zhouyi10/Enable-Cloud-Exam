package com.enableets.edu.enable.cloud.exam.framework.dao;

import com.enableets.edu.enable.cloud.exam.framework.po.ExamLevelTemplatePO;
import com.enableets.edu.framework.core.dao.BaseDao;

import java.util.List;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 14:02
 * @Description: 分数等级模板DAO
 */
public interface ExamLevelTemplateDAO extends BaseDao<ExamLevelTemplatePO> {

    //无条件查询模板列表信息
    List<ExamLevelTemplatePO> getLevelTemlate();
}
