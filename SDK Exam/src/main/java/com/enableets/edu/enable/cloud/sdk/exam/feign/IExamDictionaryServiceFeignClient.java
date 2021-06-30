package com.enableets.edu.enable.cloud.sdk.exam.feign;

import com.enableets.edu.enable.cloud.sdk.exam.dto.QueryExamDictionaryDTO;
import com.enableets.edu.enable.cloud.sdk.exam.dto.QueryExamDictionaryResultDTO;
import com.enableets.edu.sdk.core.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 16:21
 * @Description: 考试字典数据
 */
@FeignClient(value = "${sdk.enable-cloud-exam-microservice.name:enable-cloud-exam-manager}")
public interface IExamDictionaryServiceFeignClient {

    /**
     * 查询字典数据
     * @param query
     * @return
     */
    @RequestMapping(value="/microservice/cloud/examservice/dictionary/query", method = RequestMethod.POST)
    public Response<List<QueryExamDictionaryResultDTO>> query(@RequestBody QueryExamDictionaryDTO query);
}
