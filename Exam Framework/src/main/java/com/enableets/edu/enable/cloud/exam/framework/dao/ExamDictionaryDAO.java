package com.enableets.edu.enable.cloud.exam.framework.dao;

import com.enableets.edu.enable.cloud.exam.framework.po.ExamDictionaryPO;
import com.enableets.edu.framework.core.dao.BaseDao;

import java.util.List;
import java.util.Map;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23
 * @Description: 字典DAO
 */
public interface ExamDictionaryDAO extends BaseDao<ExamDictionaryPO> {

    /**
     * 查询字典数据
     * @param condition
     * @return
     */
    List<ExamDictionaryPO> query(Map<String, Object> condition);
}
