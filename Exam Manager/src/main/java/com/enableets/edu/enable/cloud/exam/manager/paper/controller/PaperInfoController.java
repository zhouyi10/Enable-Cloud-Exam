package com.enableets.edu.enable.cloud.exam.manager.paper.controller;

import com.alibaba.fastjson.JSON;
import com.enableets.edu.acm.menu.provider.util.BeanUtils;
import com.enableets.edu.enable.cloud.exam.manager.bo.TeacherBaseInfoBO;
import com.enableets.edu.enable.cloud.exam.manager.bo.xkw.XKWPaperBO;
import com.enableets.edu.enable.cloud.exam.manager.core.*;
import com.enableets.edu.enable.cloud.exam.manager.paper.bo.ContentKnowledgeInfoBO;
import com.enableets.edu.enable.cloud.exam.manager.paper.bo.PaperInfoBO;
import com.enableets.edu.enable.cloud.exam.manager.paper.service.PaperInfoService;
import com.enableets.edu.enable.cloud.exam.manager.paper.service.XKWService;
import com.enableets.edu.enable.cloud.exam.manager.paper.vo.QueryPaperVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caleb_liu@enable-ets.com
 * @date 2021/06/18
 **/

@Controller
@RequestMapping(value = Constants.CONTEXT_PATH + "/paper")
public class PaperInfoController {

    /** 基础信息 */
    @Autowired
    private BaseInfoManager baseInfo;

    @Autowired
    private PaperConfigReader paperConfigReader;

    @Autowired
    private XKWService xkwService;


    @Autowired
    private PaperInfoService paperInfoService;

    @Autowired
    private DictionaryInfoService dictionaryInfoService;


    @RequestMapping(value = "/xkw")
    public String xkw(){
        String userId = baseInfo.getUserId();
        return "redirect:" + paperConfigReader.getXkwMakePaperUrl() + userId;
    }

    @RequestMapping(value = "/xkw/notice")
    public String notice(String paperid, String openid, HttpServletRequest request, Model model){
//		String paperStr = xkwService.get(paperid, openid);
//		String fieldDomainUrl = xkwService.add(JSON.parseObject(paperStr, XKWPaperBO.class));
//		return "redirect:"+fieldDomainUrl+"/manager/paper/list";
        model.addAttribute("paperId", paperid);
        model.addAttribute("openId", openid);
        return "paperV3/progressing";
    }

    @ResponseBody
    @RequestMapping(value = "/xkw/download")
    public OperationResult<String> download(String paperId, String openId){
        String paperStr = xkwService.get(paperId, openId);
        String fieldDomainUrl = xkwService.add(JSON.parseObject(paperStr, XKWPaperBO.class));
        return new OperationResult<>(fieldDomainUrl + "/manager/paper/list");
    }

    @RequestMapping(value = "/index")
    public String index(){
        String userId = baseInfo.getUserId();
        return "paper/paperInfo";
    }



    /**
     * Query Knowledges
     *
     * @param gradeCode       Grade Code
     * @param subjectCode     Subject Code
     * @param materialVersion
     * @return
     */
    @RequestMapping(value = "/list")
    public String list(String providerCode, Model model) {
        String userId = baseInfo.getUserId();
        TeacherBaseInfoBO teacherBaseInfo = baseInfo.getTeacherBaseInfo(userId);
        QueryPaperVO queryPaperVO1 = new QueryPaperVO();
        //queryPaperVO1.setProviderCode("R01");
        /*queryPaperVO1.setStageCode(teacherBaseInfo.getStageCode());
        queryPaperVO1.setGradeCode(teacherBaseInfo.getGradeCode());
        queryPaperVO1.setSubjectCode(teacherBaseInfo.getSubjectCode());
        queryPaperVO1.setMaterialVersion(teacherBaseInfo.getMaterialVersion().getCode());*/
        //queryPaperVO1.setUsageCode("assessment");
        queryPaperVO1.setOffset(0);
        queryPaperVO1.setRows(10);
        PaperInfoBO paperInfoBO = BeanUtils.convert(queryPaperVO1, PaperInfoBO.class);
        paperInfoBO.setCreator(userId);
        paperInfoBO.setSchoolId(baseInfo.getSchoolId(userId));
        paperInfoBO.setZoneCode(baseInfo.getUserZone(baseInfo.getUserId()));
        //paperInfoBO.setSearchCode("310113VER72NR711");
        HashMap<String, Object> map = paperInfoService.query(paperInfoBO);
        model.addAttribute("paperList", map.get("paperList"));
        model.addAttribute("paperCount", map.get("paperCount"));
     /*   List<ContentKnowledgeInfoBO> knowledgeInfos = dictionaryInfoService.contentKnowledge(gradeCode, subjectCode, materialVersion);
        model.addAttribute("knowledgeInfos", knowledgeInfos);*/
        model.addAttribute("userId", userId);
        model.addAttribute("teacherBaseInfo", teacherBaseInfo);
        return "paper/paperInfo";
    }



    /**
     * Query Knowledges
     * @param gradeCode Grade Code
     * @param subjectCode Subject Code
     * @param materialVersion
     * @return
     */
    @RequestMapping(value = "/knowledge/query")
    @ResponseBody
    public HashMap<String, Object> queryKnowledge(){
        HashMap<String, Object> map = new HashMap<>();
        String userId = baseInfo.getUserId();
        TeacherBaseInfoBO teacherBaseInfo = baseInfo.getTeacherBaseInfo(userId);
        map.put("teacherBaseInfo",teacherBaseInfo);
        List<ContentKnowledgeInfoBO> knowledgeInfos = dictionaryInfoService.contentKnowledge(teacherBaseInfo.getGradeCode(), teacherBaseInfo.getSubjectCode(), teacherBaseInfo.getMaterialVersion().getCode());
        map.put("knowledgeInfos",knowledgeInfos);
        return map;
    }


    @RequestMapping(value = "/query")
    public String getPaperList(Model model) {
        String userId = baseInfo.getUserId();
        TeacherBaseInfoBO teacherBaseInfo = baseInfo.getTeacherBaseInfo(userId);
        QueryPaperVO queryPaperVO1 = new QueryPaperVO();
        queryPaperVO1.setProviderCode("R01");
        queryPaperVO1.setOffset(0);
        queryPaperVO1.setRows(10);
        PaperInfoBO paperInfoBO = BeanUtils.convert(queryPaperVO1, PaperInfoBO.class);
        paperInfoBO.setCreator(userId);
        paperInfoBO.setSchoolId(baseInfo.getSchoolId(userId));
        paperInfoBO.setZoneCode(baseInfo.getUserZone(baseInfo.getUserId()));
        HashMap<String, Object> map = paperInfoService.query(paperInfoBO);
        model.addAttribute("paperList", map.get("paperList"));
        return "paper/paperInfo::stepList";
        //return new OperationResult<List<QueryPaperVO>>(BeanUtils.convert(map.get("paperList"), QueryPaperVO.class));
    }




}
