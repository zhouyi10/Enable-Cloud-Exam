package com.enableets.edu.enable.cloud.sdk.exam;

import com.enableets.edu.enable.cloud.sdk.exam.dto.ExamLevelInfoDTO;
import com.enableets.edu.enable.cloud.sdk.exam.dto.ExamLevelTemplateDTO;

import java.util.List;

/**
 * 考试等级接口
 */
public interface IExamLevelInfoService {

    /**
     * 查询考试等级
     * @param schoolId,gradeCode
     * @return
     */
   public List<ExamLevelInfoDTO> getExamLevelList(String schoolId, String gradeCode);

    /**
     * 管理员管理考试分数等级信息
     * jackli
     * @param
     * @return
     */
    public List<ExamLevelTemplateDTO> getLevelTemplate();

}
