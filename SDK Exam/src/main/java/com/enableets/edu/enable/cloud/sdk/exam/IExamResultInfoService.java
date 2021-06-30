package com.enableets.edu.enable.cloud.sdk.exam;


import com.enableets.edu.enable.cloud.sdk.exam.dto.AddExamResultInfoDTO;

import java.util.List;

/**
 * 考试成绩相关接口
 */
public interface IExamResultInfoService {

    /**
     * 添加/修改学生成绩
     * @param resultInfoDTOList
     * @return
     */
    Boolean addOrEditExamResultInfo(List<AddExamResultInfoDTO> resultInfoDTOList);

}
