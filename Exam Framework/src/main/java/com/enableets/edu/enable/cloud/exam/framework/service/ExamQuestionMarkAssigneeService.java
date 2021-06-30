package com.enableets.edu.enable.cloud.exam.framework.service;

import com.enableets.edu.enable.cloud.exam.framework.bo.ExamQuestionMarkAssigneeBO;
import com.enableets.edu.enable.cloud.exam.framework.core.Constants;
import com.enableets.edu.enable.cloud.exam.framework.dao.ExamQuestionMarkAssigneeDAO;
import com.enableets.edu.enable.cloud.exam.framework.po.ExamQuestionMarkAssigneePO;
import com.enableets.edu.framework.core.service.ServiceAdapter;
import com.enableets.edu.framework.core.util.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * question assignee info
 * @author duffy_ding
 * @since 2020/05/29
 */
@Service
public class ExamQuestionMarkAssigneeService extends ServiceAdapter<ExamQuestionMarkAssigneeBO, ExamQuestionMarkAssigneePO> {

    /** exam question assignees */
    @Autowired
    private ExamQuestionMarkAssigneeDAO examQuestionMarkAssigneeDAO;

    /**
     * get assignees by exam id and course id
     * @param examId exam id
     * @param courseId course id
     * @return assignees
     */
    public List<ExamQuestionMarkAssigneeBO> getAssignees(String examId, String courseId) {
        Assert.hasText(examId, "examId cannot be empty!");
        List<ExamQuestionMarkAssigneePO> assignees = examQuestionMarkAssigneeDAO.getAssignees(examId, courseId, null);
        return BeanUtils.convert(assignees, ExamQuestionMarkAssigneeBO.class);
    }


    /**
     * add assignees
     * @param assignees assignees
     */
    public void add(List<ExamQuestionMarkAssigneeBO> assignees) {
        if (CollectionUtils.isEmpty(assignees)) {
            return ;
        }
        List<ExamQuestionMarkAssigneePO> subList = new ArrayList<>();
        for (ExamQuestionMarkAssigneeBO bo : assignees) {
            if (bo.getCreateTime() == null) {
                bo.setCreateTime(Calendar.getInstance().getTime());
                bo.setUpdateTime(bo.getCreateTime());
            }
            subList.add(BeanUtils.convert(bo, ExamQuestionMarkAssigneePO.class));
            if (subList.size() >= Constants.DEFAULT_BATCH_SAVE_COUNT) {
                examQuestionMarkAssigneeDAO.batchAdd(subList);
                subList.clear();
            }
        }
        if (CollectionUtils.isNotEmpty(subList)) {
            examQuestionMarkAssigneeDAO.batchAdd(subList);
        }
    }
}
