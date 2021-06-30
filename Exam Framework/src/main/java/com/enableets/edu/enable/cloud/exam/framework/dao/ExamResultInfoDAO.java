package com.enableets.edu.enable.cloud.exam.framework.dao;

import com.enableets.edu.enable.cloud.exam.framework.bo.ExamResultInfoBO;
import com.enableets.edu.enable.cloud.exam.framework.po.ExamResultInfoPO;
import com.enableets.edu.framework.core.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 14:27
 * @Description: 考试成绩DAO
 */
public interface ExamResultInfoDAO extends BaseDao<ExamResultInfoPO> {

    /**
     * 查询考试结果
     * @param examDetailsId
     * @return
     */
    List<ExamResultInfoPO> getExamResultInfo(@Param("examDetailsId") Long examDetailsId);

    Integer batchInsert(List<ExamResultInfoPO> examResultInfoPOList);

}
