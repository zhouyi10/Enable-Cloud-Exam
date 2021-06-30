package com.enableets.edu.enable.cloud.exam.microservice.restful;

import com.enableets.edu.enable.cloud.exam.framework.bo.ExamDictionaryBO;
import com.enableets.edu.enable.cloud.exam.framework.service.ExamDictionaryService;
import com.enableets.edu.enable.cloud.exam.microservice.annotation.ResponseResult;
import com.enableets.edu.enable.cloud.exam.microservice.vo.ExamDictionaryVO;
import com.enableets.edu.enable.cloud.exam.microservice.vo.QueryExamDictionaryResultVO;
import com.enableets.edu.enable.cloud.exam.microservice.vo.QueryExamDictionaryVO;
import com.enableets.edu.framework.core.util.BeanUtils;
import com.enableets.edu.module.service.controller.ServiceControllerAdapter;
import com.enableets.edu.module.service.core.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 考试等级管理
 *@author 作者 E-mail:Jack_Dong@enable-ets.com
 *@date:2018年12月3日 下午4:00:30
 */
@Api(tags="(10)考试字典数据",description ="考试字典数据")
@RestController
@ResponseResult
@RequestMapping("/microservice/cloud/examservice/dictionary")
public class ExamDictionaryRestful extends ServiceControllerAdapter<ExamDictionaryVO> {

    @Autowired
    private ExamDictionaryService examDictionaryService;

    @ApiOperation(value = "查询考试字典数据", notes = "查询考试字典数据")
    @RequestMapping(value = "/query", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    public List<QueryExamDictionaryResultVO> queryAppTotal(@ApiParam(value = "queryExamDictionaryVO", required = true)@RequestBody QueryExamDictionaryVO query) {
        List<ExamDictionaryBO> list = examDictionaryService.query(BeanUtils.convert(query , ExamDictionaryBO.class));
        return BeanUtils.convert(list , QueryExamDictionaryResultVO.class);
    }
}
