package com.enableets.edu.enable.cloud.exam.microservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 
 * @Description: 查询字典VO
 */
@ApiModel(value="queryExamDictionaryVO", description="查询字典VO")
public class QueryExamDictionaryVO {

    @ApiModelProperty(value="学校标识")
    private String schoolId;

    @ApiModelProperty(value="字典类型")
    private String type;

    @ApiModelProperty(value="字典编号")
    private String code;

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
}
