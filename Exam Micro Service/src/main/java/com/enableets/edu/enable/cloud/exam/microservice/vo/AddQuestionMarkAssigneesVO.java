package com.enableets.edu.enable.cloud.exam.microservice.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author duffy_ding
 * @since 2020/05/29
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(value = "addQuestionMarkAssigneesVO", description = "I_50_01_14_007")
public class AddQuestionMarkAssigneesVO {

    /** question id */
    @ApiModelProperty(value = "I_50_01_03_004")
    private String questionId;

    /** user id */
    @ApiModelProperty(value = "I_50_01_02_006")
    private String userId;

    /** full name */
    @ApiModelProperty(value = "I_50_01_02_008")
    private String fullName;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
