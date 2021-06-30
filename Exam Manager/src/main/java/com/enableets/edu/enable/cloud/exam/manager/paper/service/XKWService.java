package com.enableets.edu.enable.cloud.exam.manager.paper.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HtmlUtil;
import com.enableets.edu.enable.cloud.exam.manager.bo.CodeNameMapBO;
import com.enableets.edu.enable.cloud.exam.manager.bo.xkw.*;
import com.enableets.edu.enable.cloud.exam.manager.core.BaseInfoManager;
import com.enableets.edu.enable.cloud.exam.manager.core.Constants;
import com.enableets.edu.enable.cloud.exam.manager.core.CustomRestTemplate;
import com.enableets.edu.enable.cloud.exam.manager.core.PaperConfigReader;
import com.enableets.edu.enable.cloud.exam.manager.utils.XkwBaseInfoTransformUtils;
import com.enableets.edu.framework.core.util.BeanUtils;
import com.enableets.edu.sdk.content.dto.ContentFileInfoDTO;
import com.enableets.edu.sdk.content.dto.ContentInfoDTO;
import com.enableets.edu.sdk.content.service.IContentInfoService;
import com.enableets.edu.sdk.pakage.ppr.dto.*;
import com.enableets.edu.sdk.pakage.ppr.service.IPPRPaperInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.*;

/**
 * 学科网服务
 *
 * @author caleb_liu@enable-ets.com
 * @since 2020/09/02 09:56
 **/

@Service
@Slf4j
public class XKWService {

    private static final String QUES_BODY_PREFIX = "【题文】";

    private static final String QUES_ANSWER_PREFIX = "【答案】";

    private static final String QUES_ANSWER_ANALYSIS = "【解析】";

    private static final String SOURCE_CODE = "_xkw_cc_paper";

    private static final String SOURCE_NAME = "_xkw_cc_paper";

    private final static Logger LOGGER = LoggerFactory.getLogger(XKWService.class);


    @Autowired
    private IPPRPaperInfoService pprPaperInfoServiceSDK;

    @Autowired
    private IContentInfoService contentInfoServiceSDK;

    @Autowired
    private PaperConfigReader paperConfigReader;

    @Autowired
    private BaseInfoManager baseInfoManager;

    public String get(String paperId, String openId){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String paperUrl = paperConfigReader.getGetPaperUrl().replace("{openId}", openId).replace("{paperId}", paperId);
        HttpGet httpGet = new HttpGet(paperUrl);
        String key = new StringBuilder(paperConfigReader.getXkwAppId()).append(":").append(paperConfigReader.getXkwSecret()).toString();
        try {
            String code = Base64.getEncoder().encodeToString(key.getBytes("UTF-8"));
            httpGet.setHeader("Authorization", "Basic " + code);
            CloseableHttpResponse execute = httpClient.execute(httpGet);
            return EntityUtils.toString(execute.getEntity());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return null;
    }

    public String add(XKWPaperBO xkwPaper) {
        QueryPaperInfoResultDTO paper = pprPaperInfoServiceSDK.add(buildPaper(xkwPaper));
        //推动到账号所在的场域
        String fieldDomainUrl = baseInfoManager.getAccountOriginDomain();
        if (StringUtils.isBlank(fieldDomainUrl)){
            LOGGER.error("Field Domain Url Not Found!", "(UserId="+baseInfoManager.getUserId()+")Field Domain Url Not Found!");
        }else{
            ContentInfoDTO content = contentInfoServiceSDK.get(paper.getPaperId()).getData();
            String fileId = null;
            String paperUrl = null;
            if (CollectionUtils.isNotEmpty(content.getFileList())){
                for (ContentFileInfoDTO contentFileInfoDTO : content.getFileList()) {
                    if (contentFileInfoDTO.getFileExt().toLowerCase().equals("paper")){
                        fileId = contentFileInfoDTO.getFileId();
                        paperUrl = contentFileInfoDTO.getUrl(); break;

                    }
                }
            }
            if (StringUtils.isBlank(fileId) || StringUtils.isBlank(paperUrl)) {
                LOGGER.error(".paper File Not Found!", "Paper("+paper.getPaperId()+") .paper File Not Found!");
            }
            try {
                //String translationUrl = "http://192.168.118.12:9116" + "/microservice/paper/transform/v2/transfrom";
                String translationUrl = fieldDomainUrl + "/microservice/paper/transform/v2/transfrom";
                Map<String, Object> params = new HashMap<>();
                params.put("contentId", paper.getPaperId());
                params.put("typeCode", Constants.DICTIONARY_CONTENT_TYPE_PAPER);
                params.put("url", paperUrl);
                params.put("fileId", fileId);
                params.put("providerCode", Constants.PROVIDER_CODE_DEFAULT);
                params.put("userId", baseInfoManager.getUserId());
                params.put("sourceCode", SOURCE_CODE);
                params.put("sourceName", SOURCE_NAME);
                CustomRestTemplate restTemplate = new CustomRestTemplate(paperConfigReader.getSsoClientId(), paperConfigReader.getSsoSecret());
                restTemplate.post(translationUrl, params);
            }catch (Exception e){
                LOGGER.error("Push Domain["+fieldDomainUrl+"] fail!", e);
            }
        }
        return fieldDomainUrl;
    }

    public AddPaperInfoDTO buildPaper(XKWPaperBO xkwPaper) {
        if (ObjectUtil.isNull(xkwPaper.getHead()) || CollectionUtil.isEmpty(xkwPaper.getBody())) return null;
        AddPaperInfoDTO paper = new AddPaperInfoDTO();
        buildBaseInfo(xkwPaper, paper);
        buildPart(xkwPaper, paper);
        return paper;
    }

    private void buildBaseInfo(XKWPaperBO xkwPaper, AddPaperInfoDTO paper) {
        paper.setProviderCode(Constants.PROVIDER_CODE_DEFAULT);
        String name = "";
        if (ObjectUtil.isNotNull(xkwPaper.getHead())) name = xkwPaper.getHead().getMainTitle();
        paper.setName(name);
        if (ObjectUtil.isNotNull(xkwPaper.getBankId())) {
            int bankId = xkwPaper.getBankId();
            paper.setSubject(XkwBaseInfoTransformUtils.getSubjectByBankId(bankId));
            paper.setStage(XkwBaseInfoTransformUtils.getStageByBankId(bankId));
        }
    }

    private void buildPart(XKWPaperBO xkwPaper, AddPaperInfoDTO paper) {
        List<PaperNodeInfoDTO> nodes = new ArrayList<>();
        paper.setNodes(nodes);

        CodeNameMapDTO subject = paper.getSubject();

        float totalPoints = 0f;
        for (XKWPartBO xkwPart : xkwPaper.getBody()) {
            PaperNodeInfoDTO partNode = creatNode(nodes, 1);

            Float points = 0f;
            String name = "";
            String description = "";
            if (ObjectUtil.isNotNull(xkwPart.getPartHead())) {
                name = xkwPart.getPartHead().getName();
                description = xkwPart.getPartHead().getNote();
            }
            partNode.setName(name);
            partNode.setDescription(description);

            for (XKWPartBodyBO partBody : xkwPart.getPartBody()) { // 大题
                PaperNodeInfoDTO quesTypeNode = buildQuesType(partBody, nodes, subject);
                quesTypeNode.setParentNodeId(partNode.getNodeId());
                points += quesTypeNode.getPoints();
            }
            partNode.setPoints(points);
            totalPoints += points;
        }
        paper.setTotalPoints(totalPoints);

        // 获取最高年级
        for (PaperNodeInfoDTO node : paper.getNodes()) {
            if (node.getLevel() >= 3 && node.getQuestion() != null && node.getQuestion().getGrade() != null) {
                if (paper.getGrade() == null) {
                    paper.setGrade(node.getQuestion().getGrade());
                } else {
                    if (Integer.parseInt(paper.getGrade().getCode()) < Integer.parseInt(node.getQuestion().getGrade().getCode()))
                        paper.setGrade(node.getQuestion().getGrade());
                }
            }
        }
    }

    private PaperNodeInfoDTO buildQuesType(XKWPartBodyBO partBody, List<PaperNodeInfoDTO> nodes, CodeNameMapDTO subjectCN) {
        PaperNodeInfoDTO quesTypeNode = creatNode(nodes, 2);

        Float points = 0f;
        String name = "";
        String description = "";
        if (ObjectUtil.isNotNull(partBody.getType())) {
            name = partBody.getType().getName();
            description = partBody.getType().getNote();
        }
        quesTypeNode.setName(name);
        quesTypeNode.setDescription(description);

        for (XKWQuestionBO question : partBody.getQuestions()) {
            PaperNodeInfoDTO questionNode = buildQuestion(question, nodes, subjectCN);
            questionNode.setParentNodeId(quesTypeNode.getNodeId());
            points += questionNode.getPoints();
        }
        quesTypeNode.setPoints(points);
        return quesTypeNode;
    }

    private PaperNodeInfoDTO buildQuestion(XKWQuestionBO xkwQuestion, List<PaperNodeInfoDTO> nodes, CodeNameMapDTO subjectCN) {
        PaperNodeInfoDTO quesNode = creatNode(nodes, 3);

        PaperQuestionDTO question = new PaperQuestionDTO();
        quesNode.setQuestion(question);

        question.setQuestionId(String.valueOf(xkwQuestion.getId()));
//        question.setProviderCode(Constants.PROVIDER_CODE_XKW);
//        question.setSource(Constants.XKW_QUESTION_SOURCE_CODE);

        question.setSubject(subjectCN);

        CodeNameMapDTO questionType = new CodeNameMapDTO();
        if (ObjectUtil.isNotNull(xkwQuestion.getQuesType())) {
            questionType = XkwBaseInfoTransformUtils.getQuestionType(String.valueOf(xkwQuestion.getQuesType().getId()));
        }
        question.setType(questionType);

        QuestionStemInfoDTO stm = new QuestionStemInfoDTO();
        question.setStem(stm);
        String quesBody =  cleanPrefix(xkwQuestion.getQuesBody(), QUES_BODY_PREFIX);
        stm.setRichText(quesBody);
        if (StringUtils.isNotBlank(quesBody)) stm.setPlaintext(HtmlUtil.cleanHtmlTag(quesBody));

        QuestionAnswerDTO answer = new QuestionAnswerDTO();
        question.setAnswer(answer);
        String xkwQuesAnswer = cleanPrefix(xkwQuestion.getQuesAnswer(), QUES_ANSWER_PREFIX);
        answer.setLabel(xkwQuesAnswer);
        answer.setStrategy(xkwQuesAnswer);

        String analysis = cleanPrefix(xkwQuestion.getQuesParse(), QUES_ANSWER_ANALYSIS);
        answer.setAnalysis(analysis);

        CodeNameMapDTO grade = new CodeNameMapDTO();
        CodeNameMapDTO stage = new CodeNameMapDTO();
        if (CollectionUtil.isNotEmpty(xkwQuestion.getGrades()) && xkwQuestion.getGrades().size() > 0) {
            CodeNameMapDTO gradeTemp = null;
            XKWGradeBO xkwGradeBO = null;
            for (XKWGradeBO xkwGrade : xkwQuestion.getGrades()) { // 取最高年级
                CodeNameMapDTO temp = XkwBaseInfoTransformUtils.getGrade(xkwGrade.getId());
                if(gradeTemp == null || (Integer.parseInt(temp.getCode()) > Integer.parseInt(gradeTemp.getCode()))) {
                    gradeTemp = temp;
                    xkwGradeBO = xkwGrade;
                }
            }
            stage = XkwBaseInfoTransformUtils.getStage(xkwGradeBO.getStageId());
            grade = gradeTemp;
        }
        question.setStage(stage);
        question.setGrade(grade);

        CodeNameMapDTO abilityCN = new CodeNameMapDTO();
        if (ObjectUtil.isNotNull(xkwQuestion.getQuesAttribute())) {
            abilityCN.setCode(String.valueOf(xkwQuestion.getQuesAttribute().getId()));
            abilityCN.setName(xkwQuestion.getQuesAttribute().getName());
        }
        question.setAbility(abilityCN);

        CodeNameMapDTO difficultyCN = new CodeNameMapDTO();
        if (ObjectUtil.isNotNull(xkwQuestion.getQuesDiff()))
            difficultyCN = XkwBaseInfoTransformUtils.getDifficulty(String.valueOf(xkwQuestion.getQuesDiff().getId()));
        question.setDifficulty(difficultyCN);

        question.setQuestionNo(String.valueOf(xkwQuestion.getId()));

        List<QuestionKnowledgeInfoDTO> knowledgeList = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(xkwQuestion.getCategories())) {
            Map<String, QuestionKnowledgeInfoDTO> knowledgeMap = buildKnowledge(xkwQuestion.getCategories(), "XKW_ML_");
            knowledgeList.addAll(new ArrayList<>(knowledgeMap.values()));
        }
        if (CollectionUtil.isNotEmpty(xkwQuestion.getChapters())) {
            Map<String, QuestionKnowledgeInfoDTO> knowledgeMap = buildKnowledge(xkwQuestion.getChapters(), "XKW_ZJ_");
            knowledgeList.addAll(new ArrayList<>(knowledgeMap.values()));
        }
        question.setKnowledges(knowledgeList);

        /* 子题目 暂无数据*/
        Float points = 1f;
        if (xkwQuestion.getQuesScore() != null && xkwQuestion.getQuesScore() > 0) points = xkwQuestion.getQuesScore();
        if (CollectionUtil.isNotEmpty(xkwQuestion.getChildQues())) {
            int childNum = xkwQuestion.getChildQues().size();
            points = 0f;
            float childPoint = 1f;
            if (xkwQuestion.getQuesScore() != null && xkwQuestion.getQuesScore() > 0) childPoint = xkwQuestion.getQuesScore()/childNum;
            /*List<QueryQuestionChildInfoResultDTO> childQues = new ArrayList<>();
            for (int i = 0; i < childNum; i++) {
                XKWChildQuestionBO xkwChildQue = xkwQuestion.getChildQues().get(i);
                PaperNodeInfoBO childQueNode = buildChildQuestion(nodes, xkwChildQue, question);
                childQueNode.setParentId(quesNode.getNodeId());
                childQueNode.setExternalNo(quesNode.getExternalNo() + "." + childQueNode.getInternalNo()); // 设置小题题号
                childQueNode.setPoints(childPoint);
                QueryQuestionChildInfoResultDTO childQuestion = BeanUtils.convert(childQueNode.getQuestion(), QueryQuestionChildInfoResultDTO.class);
                if (childQuestion != null) {
                    childQuestion.setPoints(childPoint);
                    childQuestion.setSequencing(i+1);
                    childQues.add(childQuestion);
                }
                points += childPoint;
            }
            question.setChildren(childQues);*/
            question.setChildAmount(childNum);
        } else {
            if (("01, 02").contains(questionType.getCode())) {
                question.setOptions(buildOptions(quesBody));
            }
        }
        question.setPoints(points);
        quesNode.setPoints(points);
        return quesNode;
    }

    private PaperNodeInfoDTO buildChildQuestion(List<PaperNodeInfoDTO> nodes, XKWChildQuestionBO childQue, PaperQuestionDTO parentQuestion) {
        PaperNodeInfoDTO node = creatNode(nodes, 4);
        PaperQuestionDTO question = BeanUtils.convert(parentQuestion, PaperQuestionDTO.class);
        question.setQuestionNo(parentQuestion.getQuestionNo() + "-" + node.getInternalNo());
        question.setQuestionId(parentQuestion.getQuestionId() + "-" + node.getInternalNo());
        node.setQuestion(question);

        QuestionStemInfoDTO stm = new QuestionStemInfoDTO();
        question.setStem(stm);
        String childBody = cleanPrefix(childQue.getChildBody(), QUES_BODY_PREFIX);
        stm.setRichText(childBody);
        if (StringUtils.isNotBlank(childBody)) stm.setPlaintext(HtmlUtil.cleanHtmlTag(childBody));

        QuestionAnswerDTO answer = new QuestionAnswerDTO();
        question.setAnswer(answer);
        String childAnswer = cleanPrefix(childQue.getChildAnswer(), QUES_ANSWER_PREFIX);
        answer.setLabel(childAnswer);
        answer.setStrategy(childAnswer);

        List<QuestionOptionDTO> options = new ArrayList<>();
        if ( question.getType()!=null && ("01, 02").contains(question.getType().getCode())) {
            options = buildOptions(childBody);
        }
        question.setOptions(options);

        return node;
    }

    private Map<String, QuestionKnowledgeInfoDTO> buildKnowledge(List<List<XKWIdNameBO>> xkwIdNameList, String tag) {
        Map<String, QuestionKnowledgeInfoDTO> knowledgeMap = new HashMap<>();
        for (List<XKWIdNameBO> chapter : xkwIdNameList) {
            if (CollectionUtil.isNotEmpty(chapter) && chapter.size() >= 2) {
                CodeNameMapBO xkwMaterialVersion = new CodeNameMapBO(tag + chapter.get(0).getId(), chapter.get(0).getName());
                StringBuilder searchCode = new StringBuilder();
                for (XKWIdNameBO xkwKnowledge : chapter) {
                    if (xkwKnowledge == null) continue;
                    QuestionKnowledgeInfoDTO knowledgeInfo = new QuestionKnowledgeInfoDTO();
                    String id = tag + xkwKnowledge.getId();
                    knowledgeMap.put(id, knowledgeInfo);
                    knowledgeInfo.setKnowledgeId(id);
                    knowledgeInfo.setKnowledgeName(xkwKnowledge.getName());
                    knowledgeInfo.setMaterialVersion(xkwMaterialVersion.getCode());
                    knowledgeInfo.setMaterialVersionName(xkwMaterialVersion.getName());
                    searchCode.append(id).append("-");
                    knowledgeInfo.setSearchCode(searchCode.substring(0, searchCode.length() - 1));
                }
            }
        }
        return knowledgeMap;
    }

    private String cleanPrefix(String body, String prefixTag) {
        if (StringUtils.isNotBlank(body) && body.contains(prefixTag)) {
            String[] split = body.split(prefixTag);
            if (split.length > 1) {
                body = split[1];
            }
        }
        return body;
    }

    public List<QuestionOptionDTO> buildOptions(String quesBody) {
        // 从题干中获取选项
        List<QuestionOptionDTO> options = new ArrayList<>();
        int optionSize = 4;
        /*if (StringUtils.isNotBlank(quesBody)) {
            Document document = Jsoup.parse(quesBody);
            Elements optionsTable = document.getElementsByAttributeValue("name", "optionsTable");
            Elements optionTd = optionsTable.get(0).select("td");
            optionSize = optionTd.size();
        }
        for (int i = 0; i < optionSize; i++) {
            QuestionOptionDTO option = new QuestionOptionDTO(null, String.valueOf((char) (65 + i)),
                    "", i+"");
            options.add(option);
        }*/
        return options;
    }

    private PaperNodeInfoDTO creatNode(List<PaperNodeInfoDTO> nodes, int level) {
        PaperNodeInfoDTO node = new PaperNodeInfoDTO();
        node.setLevel(level);

        long nodeId = 1;
        int sequencing = 1;
        int internalNo = 1;
        String externalNo = "1";
        if (CollectionUtil.isNotEmpty(nodes) && nodes.size() > 0) {
            PaperNodeInfoDTO lastNode = nodes.get(nodes.size()-1);

            nodeId += lastNode.getNodeId();
            sequencing += lastNode.getSequencing();

            boolean isResetInternalNo = false; // 第二卷重置题号
            if (level != lastNode.getLevel()) {
                lastNode = null;
                for (int i = nodes.size()-1; i >=0 ; i--) {
                    PaperNodeInfoDTO nodeTemp = nodes.get(i);
                    if (nodeTemp.getLevel() == 1 && level == 3) {
                        isResetInternalNo = true;
                    }
                    if (nodeTemp.getLevel() == level) {
                        lastNode = nodeTemp;
                        break;
                    }
                }
            }

            if (lastNode!= null && lastNode.getLevel() == level) {
                if (level != 3 || !isResetInternalNo) {
                    internalNo += lastNode.getInternalNo();
                    externalNo = String.valueOf(internalNo);
                }
            }
        }
        node.setNodeId(nodeId);
        node.setSequencing(sequencing);
        node.setInternalNo(internalNo);
        node.setExternalNo(externalNo);
        nodes.add(node);
        return node;
    }
}
