package com.enableets.edu.enable.cloud.exam.microservice.restful;

import com.enableets.edu.enable.cloud.exam.framework.bo.ExamLevelInfoBO;
import com.enableets.edu.enable.cloud.exam.framework.bo.ExamLevelTemplateBO;
import com.enableets.edu.enable.cloud.exam.framework.service.ExamLevelInfoService;
import com.enableets.edu.enable.cloud.exam.microservice.annotation.ResponseResult;
import com.enableets.edu.enable.cloud.exam.microservice.vo.ExamLevelInfoVO;
import com.enableets.edu.enable.cloud.exam.microservice.vo.ExamLevelTemplateVO;
import com.enableets.edu.framework.core.util.BeanUtils;
import com.enableets.edu.module.service.controller.ServiceControllerAdapter;
import com.enableets.edu.module.service.core.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 考试等级管理
 *@author 作者 E-mail:Jack_Dong@enable-ets.com
 *@date:2018年12月3日 下午4:00:30
 */
@Api(tags="(05)考试级别管理",description ="考试级别管理")
@RestController
@ResponseResult
@RequestMapping("/microservice/cloud/examservice/level")
public class ExamLevelInfoRestful {

    @Autowired
    private ExamLevelInfoService examLevelInfoService;

    /**
     * 考试等级查询
     * @param schoolId
     * @return
     */
    @ApiOperation(value = "考试级别查询",notes = "考试级别查询")
    @RequestMapping(value = "/list" ,method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public List<ExamLevelInfoVO> getExamLevelList(
                       @ApiParam(value="学校标识", required=true) @RequestParam(value="schoolId", required=true) String  schoolId,
                       @ApiParam(value="年级标识", required=true) @RequestParam(value="gradeCode", required=false)String  gradeCode){

        List<ExamLevelInfoBO> examLevelList = examLevelInfoService.getExamLevelList(schoolId,gradeCode);
        return BeanUtils.convert(examLevelList,ExamLevelInfoVO.class);
    }

    @ApiOperation(value = "查询模板分数等级信息", notes = "查询分数等级信息")
    @RequestMapping(value = "/template", method = RequestMethod.POST)
    public List<ExamLevelTemplateVO> queryTemplate( ){
        List<ExamLevelTemplateBO> levelTemlate = examLevelInfoService.getLevelTemlate();
        return BeanUtils.convert(levelTemlate, ExamLevelTemplateVO.class);
    }
}
