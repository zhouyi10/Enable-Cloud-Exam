package com.enableets.edu.enable.cloud.exam.manager.paper.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * learning performance BO
 *
 * @author caleb_liu@enable-ets.com
 * @date 2020/11/13
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreformanceBO {

    public PreformanceBO(String preformanceCode, String preformanceName) {
        this.preformanceCode = preformanceCode;
        this.preformanceName = preformanceName;
    }

    private String preformanceId;

    private String questionId;

    private String preformanceCode;

    private String preformanceName;

    private Integer type;

    private String creator;

    private Date createTime;

    private String updator;

    private Date updateTime;

}
