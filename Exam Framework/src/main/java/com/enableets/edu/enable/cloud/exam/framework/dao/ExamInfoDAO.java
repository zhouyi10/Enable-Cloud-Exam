package com.enableets.edu.enable.cloud.exam.framework.dao;

import com.enableets.edu.enable.cloud.exam.framework.po.ExamInfoPO;
import com.enableets.edu.framework.core.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author caleb_liu@enable-ets.com
 * @date 2021/05/13
 **/

public interface ExamInfoDAO extends BaseDao<ExamInfoPO> {

    ExamInfoPO getExamV2(@Param(value = "examId") Long examId);

    List<ExamInfoPO> query(Map<String, Object> condition);

    Integer count(Map<String, Object> condition);

    /**
     * Delete administrator's exam_point_input_Setting table information
     * @param examId
     */
    int deleteExamPointInputSetting(@Param(value = "examId") Long examId);


    /**
     * Delete administrator's exam_details_info table information
     * @param examId
     */
    int deleteExamDetailsInfo(@Param(value = "examId") Long examId);


    /**
     * Delete administrator's exam_info table information
     * @param examId
     */
    int deleteExamInfo(@Param(value = "examId") Long examId);

    /**
     * update exam publish status by exam id
     * @param examId exam id
     * @return update count
     */
    int updatePublishStatus(@Param(value = "examId") Long examId);

}
