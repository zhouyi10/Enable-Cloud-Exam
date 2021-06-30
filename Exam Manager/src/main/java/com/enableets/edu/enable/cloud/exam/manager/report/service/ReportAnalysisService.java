package com.enableets.edu.enable.cloud.exam.manager.report.service;

import com.enableets.edu.enable.cloud.exam.manager.report.bo.QueryTestReportBO;
import com.enableets.edu.enable.cloud.exam.manager.report.bo.TeacherTestResultBO;
import com.enableets.edu.framework.core.util.BeanUtils;
import com.enableets.edu.sdk.pakage.ppr.dto.QueryTeacherTestDTO;
import com.enableets.edu.sdk.pakage.ppr.service.IPPRTestInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author justice_zhou@enable-ets.com
 * @date 2021/6/22
 **/

@Service
public class ReportAnalysisService {

    @Autowired
    private IPPRTestInfoService pprTestInfoServiceSDK;


    public List<TeacherTestResultBO> queryResultForTeacher(QueryTestReportBO condition) {
        QueryTeacherTestDTO param = BeanUtils.convert(condition, QueryTeacherTestDTO.class);
        return BeanUtils.convert(pprTestInfoServiceSDK.queryResultForTeacher(param), TeacherTestResultBO.class);
    }

    public Integer countResultForTeacher(QueryTestReportBO condition) {
        QueryTeacherTestDTO param = BeanUtils.convert(condition, QueryTeacherTestDTO.class);
        return pprTestInfoServiceSDK.countResultForTeacher(param);
    }


}