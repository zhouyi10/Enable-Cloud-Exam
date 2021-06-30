package com.enableets.edu.enable.cloud.sdk.exam.feign;

import com.enableets.edu.enable.cloud.sdk.exam.dto.AddExamResultInfoDTO;
import com.enableets.edu.enable.cloud.sdk.exam.dto.QueryExamResultInfoResultDTO;
import com.enableets.edu.sdk.core.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "${sdk.enable-cloud-exam-microservice.name:enable-cloud-exam-manager}")
public interface IExamResultInfoServiceFeignClient {

    /**
     * 批量添加或修改
     * @param resultInfoDTOList
     * @return
     */
    @RequestMapping(value="/microservice/cloud/examservice/result/addoredit", method = RequestMethod.POST)
    public Response<Boolean>  addOrEditExamResultInfo(@RequestBody List<AddExamResultInfoDTO> resultInfoDTOList);

}

