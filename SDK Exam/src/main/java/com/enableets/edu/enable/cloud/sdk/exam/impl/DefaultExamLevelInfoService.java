package com.enableets.edu.enable.cloud.sdk.exam.impl;

import com.enableets.edu.enable.cloud.sdk.exam.IExamLevelInfoService;
import com.enableets.edu.enable.cloud.sdk.exam.dto.ExamLevelInfoDTO;
import com.enableets.edu.enable.cloud.sdk.exam.dto.ExamLevelTemplateDTO;
import com.enableets.edu.enable.cloud.sdk.exam.feign.IExamLevelInfoFeignClient;

import java.util.List;

public class DefaultExamLevelInfoService implements IExamLevelInfoService {

    private IExamLevelInfoFeignClient examLevelInfoFeignClient;


    public DefaultExamLevelInfoService(IExamLevelInfoFeignClient examDetailsServiceFeignClient) {
        this.examLevelInfoFeignClient = examDetailsServiceFeignClient;
    }

	/**
	 * 查询考试等级
	 * @param schoolId,gradeCode
	 * @param gradeCode
	 * @return
	 */
    @Override
    public List<ExamLevelInfoDTO> getExamLevelList(String schoolId, String  gradeCode) {
        return examLevelInfoFeignClient.getExamLevelList(schoolId,gradeCode).getData();
    }

    @Override
    public List<ExamLevelTemplateDTO> getLevelTemplate() {
        return examLevelInfoFeignClient.getLevelTemplate().getData();
    }

}
