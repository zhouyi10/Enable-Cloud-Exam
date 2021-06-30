package com.enableets.edu.enable.cloud.exam.microservice.restful;

import com.enableets.edu.enable.cloud.exam.framework.bo.ExamResultInfoBO;
import com.enableets.edu.enable.cloud.exam.framework.service.ExamResultInfoService;
import com.enableets.edu.enable.cloud.exam.microservice.vo.ExamResultInfoVO;
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
 * 考试结果管理
 * 
 * @author 作者 E-mail:Jack_Dong@enable-ets.com
 * @date:2018年12月3日 下午4:00:30
 */

@Api(tags = "(06)考试结果查询", description = "考试结果查询")
@RestController
@RequestMapping("/microservice/cloud/examservice/result")
public class ExamResultInfoRestful extends ServiceControllerAdapter<ExamResultInfoVO> {

	@Autowired
	private ExamResultInfoService examResultInfoService;

	/**
	 * 批量添加或修改学生考试成绩
	 * 
	 * @param examResultInfoVOList
	 * @return
	 */
	@ApiOperation(value = "批量添加/修改考试成绩", notes = "批量添加/修改考试成绩")
	@RequestMapping(value = "/addoredit", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	public Response<Boolean> addOrEditExamResultInfo(
			@ApiParam(value = "修改考试成绩VOList", required = true) @RequestBody List<ExamResultInfoVO> examResultInfoVOList) {

		Boolean resultInfo = examResultInfoService
				.addOrEditExamResultInfo(BeanUtils.convert(examResultInfoVOList, ExamResultInfoBO.class));

		return responseTemplate.format(resultInfo);
	}
}
