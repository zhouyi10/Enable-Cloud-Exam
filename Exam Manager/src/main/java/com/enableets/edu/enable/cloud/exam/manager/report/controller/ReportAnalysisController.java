package com.enableets.edu.enable.cloud.exam.manager.report.controller;

import com.enableets.edu.enable.cloud.exam.manager.core.BaseInfoManager;
import com.enableets.edu.enable.cloud.exam.manager.core.Constants;
import com.enableets.edu.enable.cloud.exam.manager.core.OperationResult;
import com.enableets.edu.enable.cloud.exam.manager.report.bo.QueryTestReportBO;
import com.enableets.edu.enable.cloud.exam.manager.report.bo.TeacherTestResultBO;
import com.enableets.edu.enable.cloud.exam.manager.report.service.ReportAnalysisService;
import com.enableets.edu.enable.cloud.exam.manager.report.vo.QueryTestReportVO;
import com.enableets.edu.enable.cloud.exam.manager.report.vo.TeacherTestResultVO;
import com.enableets.edu.framework.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author justice_zhou@enable-ets.com
 * @date 2021/6/22
 **/

@Controller
@RequestMapping(value = Constants.CONTEXT_PATH + "/report")
public class ReportAnalysisController {


    private static String REPORT_DIAGNOSIS_INDEX_PAGE = "report/diagnosis";

    private static String REPORT_COMPREHENSIVE_INDEX_PAGE = "report/comprehensive";

    private static String VIEW_REPORT_URL = "/manager/diagnose/report/step/class";

    @Autowired
    private ReportAnalysisService analysisService;

    @Autowired
    private BaseInfoManager baseInfo;

    @RequestMapping(value = "/diagnosis")
    public String diagnosis(Model model) {
        model.addAttribute("userId", baseInfo.getUserId());
        model.addAttribute("teacherBaseInfo",baseInfo.getTeacherBaseInfo(null));
        model.addAttribute("viewReportUrl", VIEW_REPORT_URL);
        return REPORT_DIAGNOSIS_INDEX_PAGE;
    }

    @RequestMapping(value = "/comprehensive")
    public String comprehensive(Model model) {
        model.addAttribute("userId", baseInfo.getUserId());
        model.addAttribute("teacherBaseInfo",baseInfo.getTeacherBaseInfo(null));
        model.addAttribute("viewReportUrl", VIEW_REPORT_URL);
        return REPORT_COMPREHENSIVE_INDEX_PAGE;
    }
    
    @RequestMapping(value = "/testInfoList",method = RequestMethod.POST)
    @ResponseBody
    public OperationResult list(QueryTestReportVO condition) {
        List<TeacherTestResultBO> testInfoBOS = analysisService.queryResultForTeacher(BeanUtils.convert(condition, QueryTestReportBO.class));
        return new OperationResult<>(BeanUtils.convert(testInfoBOS, TeacherTestResultVO.class));
    }

    @RequestMapping(value = "/count",method = RequestMethod.POST)
    @ResponseBody
    public OperationResult count(QueryTestReportVO condition) {
        Integer count = analysisService.countResultForTeacher(BeanUtils.convert(condition, QueryTestReportBO.class));
        return new OperationResult<>(count);
    }
}