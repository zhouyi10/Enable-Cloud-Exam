package com.enableets.edu.enable.cloud.exam.framework.dao;

import com.enableets.edu.enable.cloud.exam.framework.po.ExamDetailsMarkAssigneePO;
import com.enableets.edu.framework.core.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Yvonne_Yu@enable-ets.com
 * @since 2020/05/21
 */
public interface ExamDetailsMarkAssigneeDAO extends BaseDao<ExamDetailsMarkAssigneePO> {

	public List<ExamDetailsMarkAssigneePO> queryById(Map<String, Object> map);

	int deleteByDetailsId(@Param(value = "examDetailsId")Long examDetailsId);

	public void batchInsert(List<ExamDetailsMarkAssigneePO> markAssigneesPOList);

}
