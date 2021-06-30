package com.enableets.edu.enable.cloud.exam.microservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 
 * @Description: 字典BO
 */
@ApiModel(value="examDictionaryVO", description="字典VO")
public class ExamDictionaryVO {

    @ApiModelProperty(value="学校标识")
    private String schoolId;

    @ApiModelProperty(value="字典类型")
    private String type;

    @ApiModelProperty(value="字典编号")
    private String code;

    private String name;

    private String description;

    private String status;

    private Byte sequenceNumber;

    private String parentCode;

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Byte getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(Byte sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}
