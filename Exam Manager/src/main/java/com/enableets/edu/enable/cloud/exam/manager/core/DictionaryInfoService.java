package com.enableets.edu.enable.cloud.exam.manager.core;

import com.enableets.edu.enable.cloud.exam.manager.bo.CodeNameMapBO;
import com.enableets.edu.enable.cloud.exam.manager.paper.bo.ContentKnowledgeInfoBO;
import com.enableets.edu.enable.cloud.exam.manager.paper.core.PPRConstants;
import com.enableets.edu.framework.core.util.BeanUtils;
import com.enableets.edu.framework.core.util.JsonUtils;
import com.enableets.edu.sdk.content.dto.ContentDictionaryInfoDTO;
import com.enableets.edu.sdk.content.dto.ContentKnowledgeInfoDTO;
import com.enableets.edu.sdk.content.service.IContentDictionaryInfoService;
import com.enableets.edu.sdk.content.service.IContentInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Base Info Service
 * @author walle_yu@enable-ets.com
 * @since 2020/08/06
 **/
@Component
public class DictionaryInfoService {

    /** Content SDK Client*/
    @Autowired
    private IContentDictionaryInfoService contentDictionaryInfoServiceSDK;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /** Content SDK Client*/
    @Autowired
    private IContentInfoService contentInfoServiceSDK;


    /**
     * Content Dictionary Stage Info
     * @return List
     */
    public List<CodeNameMapBO> contentStage(){
        return contentDictionary(Constants.DICTIONARY_STAGE_TYPE_CODE);
    }

    /**
     * Get Stage Name By Code
     * @param code Code
     * @return
     */
    public String matchStageName(String code){
        return getName(Constants.DICTIONARY_STAGE_TYPE_CODE, code);
    }

    /**
     * Content Dictionary Grade Info
     * @return List
     */
    public List<CodeNameMapBO> contentGrade(){
        return contentDictionary(Constants.DICTIONARY_TYPE_GRADE);
    }

    /**
     * Get Grade Name By Code
     * @param code
     * @return
     */
    public String matchGradeName(String code){
        return getName(Constants.DICTIONARY_TYPE_GRADE, code);
    }

    /**
     * Content Dictionary Subject Info
     * @return List
     */
    public List<CodeNameMapBO> contentSubject(){
        return contentDictionary(Constants.DICTIONARY_SUBJECT_TYPE_CODE);
    }

    /**
     * Get Subject Name By Code
     * @param code Code
     * @return
     */
    public String matchSubjectName(String code){
        return getName(Constants.DICTIONARY_SUBJECT_TYPE_CODE, code);
    }

    /**
     * Content Dictionary MaterialVersion Info
     * @return
     */
    public List<CodeNameMapBO> contentMaterialVersion(){
        return contentDictionary(Constants.DICTIONARY_MATERIAL_TYPE_CODE);
    }

    /**
     * Get Material Version Name By Code
     * @param code
     * @return
     */
    public String matchMaterialVersionName(String code){
        return getName(Constants.DICTIONARY_MATERIAL_TYPE_CODE, code);
    }

    /**
     * Content Dictionary Question Type Info
     * @return
     */
    public List<CodeNameMapBO> contentQuestionType(){
        return contentDictionary(Constants.DICTIONARY_QUESTONTYPE_TYPE_CODE);
    }

    /**
     * Get Question Type Name By Id
     */
    public String matchQuestionTypeName(String id){
        return getName(Constants.DICTIONARY_QUESTONTYPE_TYPE_CODE, id);
    }

    /**
     * Content Dictionary Ability Info
     * @return
     */
    public List<CodeNameMapBO> contentAbility(){
        return contentDictionary(Constants.DICTIONARY_ABILITY_TYPE_CODE);
    }

    /**
     * Get Ability Name by Id
     * @param id
     * @return
     */
    public String matchAbilityName(String id){
        return getName(Constants.DICTIONARY_ABILITY_TYPE_CODE, id);
    }

    /**
     * Content Dictionary Difficulty Info
     * @return
     */
    public List<CodeNameMapBO> contentDifficulty(){
        return contentDictionary(Constants.DICTIONARY_DIFFICULTY_TYPE_CODE);
    }

    /**
     * Get Difficulty Name by Id
     * @param id
     * @return
     */
    public String matchDifficultyName(String id){
        return getName(Constants.DICTIONARY_DIFFICULTY_TYPE_CODE, id);
    }

    private String getName(String type, String code){
        List<CodeNameMapBO> codeNameMapBOS = this.contentDictionary(type);
        if (CollectionUtils.isEmpty(codeNameMapBOS)) return null;
        String name = null;
        for (CodeNameMapBO codeNameMapBO : codeNameMapBOS) {
            if (codeNameMapBO.getCode().equals(code)) {
                name = codeNameMapBO.getName(); break;
            }
        }
        return name;
    }

    /**
     * Get Base Info From Content
     * @param type Base Info Type
     * @return
     */
    private List<CodeNameMapBO> contentDictionary(String type){
        if (StringUtils.isBlank(type)) return null;
        String dictionaryKey = new StringBuilder("com:enableets:edu:paper:content:dictionary:type:").append(type).toString();
        String jsonStr = stringRedisTemplate.opsForValue().get(dictionaryKey);
        if (StringUtils.isNotBlank(jsonStr)) return JsonUtils.convert2List(jsonStr, CodeNameMapBO.class);
        List<ContentDictionaryInfoDTO> dictionaries = contentDictionaryInfoServiceSDK.query(Constants.DEFAULT_SCHOOL_ID, type, null, null, null, "0");//Query All
        if (CollectionUtils.isEmpty(dictionaries)) return null;
        List<CodeNameMapBO> dics = dictionaries.stream().map(e -> new CodeNameMapBO(e.getCode(), e.getName())).collect(Collectors.toList());
        stringRedisTemplate.opsForValue().set(dictionaryKey, JsonUtils.convert(dics), Constants.DEFAULT_REDIS_CACHE_EXPIRE_TIME, TimeUnit.SECONDS);
        return dics;
    }


    /**
     * Get Knowledge Info
     */
    public List<ContentKnowledgeInfoBO> contentKnowledge(String gradeCode, String subjectCode, String materialVersion){
        if (StringUtils.isBlank(subjectCode) || StringUtils.isBlank(materialVersion)) return null;
        StringBuilder sb = new StringBuilder(PPRConstants.PACKAGE_PPR_CACHE_KEY_PREFIX).append("paper:knowledge:");
        if (StringUtils.isNotBlank(gradeCode)) sb.append(gradeCode);
        String knowledgeCacheKey = sb.append(gradeCode).append(subjectCode).append(materialVersion).toString();
        String knowledgeStr = stringRedisTemplate.opsForValue().get(knowledgeCacheKey);
        if (StringUtils.isNotBlank(knowledgeStr)){
            return JsonUtils.convert2List(knowledgeStr, ContentKnowledgeInfoBO.class);
        }
        try {
            List<ContentKnowledgeInfoDTO> knowledgeDTOs = contentInfoServiceSDK.getKnowledgeList(gradeCode, subjectCode, materialVersion, Constants.CONTENT_PUBLIC_TYPE, null).getData();
            List<ContentKnowledgeInfoBO> knowledgeInfos = knowledgeDTOs.stream().map(e -> BeanUtils.convert(e, ContentKnowledgeInfoBO.class)).collect(Collectors.toList());
            stringRedisTemplate.opsForValue().set(knowledgeCacheKey, JsonUtils.convert(knowledgeInfos), Constants.DEFAULT_REDIS_CACHE_EXPIRE_TIME, TimeUnit.SECONDS);
            return knowledgeInfos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
