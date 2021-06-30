package com.enableets.edu.enable.cloud.exam.framework.dao;

import com.enableets.edu.enable.cloud.exam.framework.po.ExamLevelInfoPO;
import com.enableets.edu.framework.core.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 14:02
 * @Description: 分数等级DAO
 */
public interface ExamLevelInfoDAO extends BaseDao<ExamLevelInfoPO> {

    /**
     * 查询考试等级
     * @param schoolId
     * @param gradeCode
     * @return
     */
    List<ExamLevelInfoPO> getExamInfo(@Param("schoolId") String schoolId, @Param("gradeCode") String gradeCode);

}
