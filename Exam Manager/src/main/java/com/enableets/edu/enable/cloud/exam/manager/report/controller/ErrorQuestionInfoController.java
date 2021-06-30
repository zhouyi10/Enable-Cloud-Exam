package com.enableets.edu.enable.cloud.exam.manager.report.controller;

import com.enableets.edu.enable.cloud.exam.manager.core.BaseInfoManager;
import com.enableets.edu.enable.cloud.exam.manager.core.Constants;
import com.enableets.edu.sdk.pakage.ppr.dto.ErrorQuestionInfoDTO;
import com.enableets.edu.sdk.pakage.ppr.dto.QueryErrorQuestionInfoDTO;
import com.enableets.edu.sdk.pakage.ppr.dto.TeacherCourseInfoDTO;
import com.enableets.edu.sdk.pakage.ppr.service.IPPRErrorQuestionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = Constants.CONTEXT_PATH + "/error/question")
public class ErrorQuestionInfoController {

    private static final String PAGE_TEACHER_ERROR_QUESTIONS = "errorQuestion/indexTeacher";

    @Autowired
    private IPPRErrorQuestionInfoService errorQuestionInfoServiceSDK;

    @Autowired
    private BaseInfoManager baseInfoManager;

    @RequestMapping(value = "/list")
    public String list(Model model) {
        String userId = baseInfoManager.getUserId();
        List<TeacherCourseInfoDTO> subjects = errorQuestionInfoServiceSDK.getTeachSubject(userId, baseInfoManager.getSchoolId(userId), getTermId());
        model.addAttribute("teachCourseList", subjects);
        model.addAttribute("teachGroups", baseInfoManager.getTeachGroup(userId, null, null));
        model.addAttribute("termId", getTermId());
        return PAGE_TEACHER_ERROR_QUESTIONS;
    }

    @PostMapping(value = "/getErrorQuestions")
    @ResponseBody
    public List<ErrorQuestionInfoDTO> getErrorQuestionsData(@RequestBody QueryErrorQuestionInfoDTO queryErrorQuestionInfoDTO){
        List<ErrorQuestionInfoDTO> list = errorQuestionInfoServiceSDK.getErrorQuestionMasterList(queryErrorQuestionInfoDTO);
        return list;
    }

    @PostMapping(value = "/getErrorQuestionCount")
    @ResponseBody
    public Integer getErrorQuestionCount(@RequestBody QueryErrorQuestionInfoDTO queryErrorQuestionInfoDTO){
        Integer num = errorQuestionInfoServiceSDK.getErrorQuestionCount(queryErrorQuestionInfoDTO);
        return num;
    }

    public String getTermId() {
        String userId = baseInfoManager.getUserId();
        String schoolId = baseInfoManager.getSchoolId(userId);
        return baseInfoManager.getCurrentTermId(schoolId);
    }
}
