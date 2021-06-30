package com.enableets.edu.enable.cloud.sdk.exam.impl;

import com.enableets.edu.enable.cloud.sdk.exam.IExamDictionaryService;
import com.enableets.edu.enable.cloud.sdk.exam.dto.QueryExamDictionaryDTO;
import com.enableets.edu.enable.cloud.sdk.exam.dto.QueryExamDictionaryResultDTO;
import com.enableets.edu.enable.cloud.sdk.exam.feign.IExamDictionaryServiceFeignClient;

import java.util.List;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 16:25
 * @Description: 考试字典数据
 */
public class DefaultExamDictionaryService implements IExamDictionaryService {

    private IExamDictionaryServiceFeignClient examDictionaryServiceFeignClient;

    public DefaultExamDictionaryService(IExamDictionaryServiceFeignClient examDictionaryServiceFeignClient){
        this.examDictionaryServiceFeignClient = examDictionaryServiceFeignClient;
    }

    @Override
    public List<QueryExamDictionaryResultDTO> query(QueryExamDictionaryDTO query) {
        return examDictionaryServiceFeignClient.query(query).getData();
    }
}
