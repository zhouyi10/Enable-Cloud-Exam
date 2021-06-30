package com.enableets.edu.enable.cloud.exam.manager.report.vo;

import lombok.Data;

@Data
public class ErrorQuestionInfoVO {
    private String questionId;
    private String questionContent;
    private Integer questionCount;
    private Integer notMasterCount;
    private Integer unmarkedCauseCount;
}
