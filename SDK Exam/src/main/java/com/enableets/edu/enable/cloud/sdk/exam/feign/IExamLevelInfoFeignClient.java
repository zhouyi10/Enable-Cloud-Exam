package com.enableets.edu.enable.cloud.sdk.exam.feign;

import com.enableets.edu.enable.cloud.sdk.exam.dto.ExamLevelInfoDTO;
import com.enableets.edu.enable.cloud.sdk.exam.dto.ExamLevelTemplateDTO;
import com.enableets.edu.sdk.core.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "${sdk.enable-cloud-exam-microservice.name:enable-cloud-exam-manager}")
public interface IExamLevelInfoFeignClient {

    /**
     * 查询考试等级
     * @param schoolId,gradeCode
     * @return
     */
    @RequestMapping(value="/microservice/cloud/examservice/level/list", method = RequestMethod.GET)
    public Response<List<ExamLevelInfoDTO>> getExamLevelList(@RequestParam(value = "schoolId", required = true) String schoolId,
                                                             @RequestParam(value = "gradeCode", required = false) String gradeCode);

    /**
     * 管理員管理考試分數等級
     */
    @RequestMapping(value="/microservice/cloud/examservice/level/template", method = RequestMethod.POST)
    public Response<List<ExamLevelTemplateDTO>> getLevelTemplate();

}
