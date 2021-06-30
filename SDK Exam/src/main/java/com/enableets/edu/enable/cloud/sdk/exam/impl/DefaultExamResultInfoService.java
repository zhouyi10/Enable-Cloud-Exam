package com.enableets.edu.enable.cloud.sdk.exam.impl;

import com.enableets.edu.enable.cloud.sdk.exam.IExamResultInfoService;
import com.enableets.edu.enable.cloud.sdk.exam.dto.AddExamResultInfoDTO;
import com.enableets.edu.enable.cloud.sdk.exam.dto.QueryExamResultInfoResultDTO;
import com.enableets.edu.enable.cloud.sdk.exam.feign.IExamResultInfoServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DefaultExamResultInfoService implements IExamResultInfoService {


    @Autowired
    private IExamResultInfoServiceFeignClient examResultInfoServiceFeignClient;

    public DefaultExamResultInfoService(IExamResultInfoServiceFeignClient examResultInfoServiceFeignClient) {
        this.examResultInfoServiceFeignClient=examResultInfoServiceFeignClient;
    }

    /**
     * 添加/修改学生成绩
     * @param resultInfoDTOList
     * @return
     */
    @Override
    public Boolean addOrEditExamResultInfo(List<AddExamResultInfoDTO> resultInfoDTOList) {
        return examResultInfoServiceFeignClient.addOrEditExamResultInfo(resultInfoDTOList).getData();
    }

}
