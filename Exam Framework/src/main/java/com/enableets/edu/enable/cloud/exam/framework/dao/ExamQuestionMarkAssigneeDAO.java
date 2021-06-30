package com.enableets.edu.enable.cloud.exam.framework.dao;

import com.enableets.edu.enable.cloud.exam.framework.po.ExamQuestionMarkAssigneePO;
import com.enableets.edu.framework.core.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author duffy_ding
 * @since 2020/05/29
 */
public interface ExamQuestionMarkAssigneeDAO extends BaseDao<ExamQuestionMarkAssigneePO> {

    /**
     * query exam question assignee info by condition
     * @param examId exam id
     * @param courseId course id
     * @param questionId question id
     * @return assignee infos
     */
    public List<ExamQuestionMarkAssigneePO> getAssignees(@Param("examId") String examId, @Param("courseId") String courseId, @Param("questionId") String questionId);

    /**
     * Delete administrator's exam_details_Info table information
     * @param examId
     */
    int deleteByExamId(@Param(value = "examId") Long examId);

    /**
     * batch add exam question assignees
     * @param list list
     */
    int batchAdd(List<ExamQuestionMarkAssigneePO> list);
}
