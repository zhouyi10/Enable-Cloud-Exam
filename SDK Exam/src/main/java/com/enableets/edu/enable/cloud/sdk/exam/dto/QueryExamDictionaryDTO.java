package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 
 * @Description: 查询字典DTO
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryExamDictionaryDTO {

    private String schoolId;

    private String type;

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
