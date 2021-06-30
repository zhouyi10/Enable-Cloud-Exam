package com.enableets.edu.enable.cloud.exam.framework.dao;

import com.enableets.edu.enable.cloud.exam.framework.po.ExamDetailsStepTaskInfoPO;
import com.enableets.edu.framework.core.dao.BaseDao;

import java.util.List;

/**
 * @author Yvonne_Yu@enable-ets.com
 * @since 2020/05/21
 */
public interface ExamDetailsStepTaskInfoDAO extends BaseDao<ExamDetailsStepTaskInfoPO> {

	public void batchInsert(List<ExamDetailsStepTaskInfoPO> stepTaskInfoPOList);
	
}
