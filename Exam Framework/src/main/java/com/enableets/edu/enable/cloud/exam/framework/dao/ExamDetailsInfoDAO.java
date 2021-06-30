package com.enableets.edu.enable.cloud.exam.framework.dao;

import com.enableets.edu.enable.cloud.exam.framework.po.ExamDetailsInfoPO;
import com.enableets.edu.enable.cloud.exam.framework.po.ExamStatisticsInfoPO;
import com.enableets.edu.framework.core.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23
 * @Description: 考试明细DAO
 */
public interface ExamDetailsInfoDAO extends BaseDao<ExamDetailsInfoPO> {

    List<ExamDetailsInfoPO> queryDetailsByExamId(Long examId);

    List<ExamStatisticsInfoPO> queryExamDetailsInfoV2(Map<String, Object> condition);

    Integer countV2(Map<String, Object> condition);

    List<ExamDetailsInfoPO> queryExamDetails(Map<String,Object> map);

    void batchInsert(List<ExamDetailsInfoPO> detailList);
}
