package com.enableets.edu.enable.cloud.exam.manager.utils;

import com.enableets.edu.enable.cloud.exam.manager.core.DictionaryInfoService;
import com.enableets.edu.framework.core.util.SpringBeanUtils;
import com.enableets.edu.sdk.pakage.ppr.dto.CodeNameMapDTO;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * @author walle_yu@enable-ets.com
 * @since 2020/09/02
 **/
public class XkwBaseInfoTransformUtils {

    private static final Map<Integer, String> xkwStageRelationShips = new HashMap<>();
    private static final Map<Integer, String> xkwGradeRelationShips = new HashMap<>();
    //小学对应的所有bankId
    private static final Integer[] STAGE_PRIMARY_RELATION_BANK_IDS = {23, 24, 25, 31, 32};
    //初中对应的所有bankId
    private static final Integer[] STAGE_JUNIOR_HIGH_RELATION_BANK_IDS = {1, 2, 3, 4, 5, 6, 7, 8, 9, 26, 29, 30};
    //高中对应的所有bankId
    private static final Integer[] STAGE_SENIOR_MIDDLE_RELATION_BANK_IDS = {10, 11, 12, 13, 14, 15, 16, 17, 18, 27, 28};
    private static final Map<String, String> xkwQuestionTypeRelationShips = new HashMap<>();

    private static final String[] simple_choice = {"201", "101", "1601", "1801", "1401", "1405", "1901", "1701", "2101", "1501", "1101", "1301", "2001", "1001", "3401", "3001", "3301", "3101", "2701", "3901", "3907", "2901", "3501", "2601", "3201"}; //单选题  01
    private static final String[] fill_blank = {"202", "102", "1602", "1802", "1402", "1902", "1702", "1502", "1102", "1302", "2002", "1002", "3402", "3003", "3303", "2702", "2705", "3902", "2902", "3502", "3203"}; //填空题 03
    private static final String[] charge_q = {"203", "110","1604", "1804", "1703", "1504", "2003", "3403", "3304", "3903", "3503", "3207"}; //判断题  04
    private static String[] multi_choice = {"2704"};  //多选题  02

    private static DictionaryInfoService dictionaryInfoService;

    static {
        init();
        dictionaryInfoService = SpringBeanUtils.getBean(DictionaryInfoService.class);
    }

    public static CodeNameMapDTO getStage(int xkwStageCode){
        String stageCode = xkwStageRelationShips.get(xkwStageCode);
        return new CodeNameMapDTO(stageCode, dictionaryInfoService.matchStageName(stageCode));
    }

    public static CodeNameMapDTO getGrade(int xkwGradeCode){
        String gradeCode = xkwGradeRelationShips.get(xkwGradeCode);
        return new CodeNameMapDTO(gradeCode, dictionaryInfoService.matchGradeName(gradeCode));
    }

    public static CodeNameMapDTO getDifficulty(String xkwDifficultyCode){
        return new CodeNameMapDTO(xkwDifficultyCode, dictionaryInfoService.matchDifficultyName(xkwDifficultyCode));
    }

    public static CodeNameMapDTO getQuestionType(String xkwQuestionTypeCode){
        String typeCode = xkwQuestionTypeRelationShips.get(xkwQuestionTypeCode);
        if (StringUtils.isBlank(typeCode)) typeCode = "09";  //默认都是解答题
        return new CodeNameMapDTO(typeCode, dictionaryInfoService.matchQuestionTypeName(typeCode));
    }

    public static CodeNameMapDTO getStageByBankId(Integer bankId){
        String stageCode = null;
        Set<Integer> stage_1 = new HashSet<>(Arrays.asList(STAGE_PRIMARY_RELATION_BANK_IDS));
        Set<Integer> stage_2 = new HashSet<>(Arrays.asList(STAGE_JUNIOR_HIGH_RELATION_BANK_IDS));
        Set<Integer> stage_3 = new HashSet<>(Arrays.asList(STAGE_SENIOR_MIDDLE_RELATION_BANK_IDS));
        if (stage_1.contains(bankId)) stageCode = "2";
        else if (stage_2.contains(bankId)) stageCode = "3";
        else if (stage_3.contains(bankId)) stageCode = "4";
        return new CodeNameMapDTO(stageCode, dictionaryInfoService.matchStageName(stageCode));
    }

    public static CodeNameMapDTO getSubjectByBankId(Integer bankId){
        int key = bankId.intValue();
        String subjectId = null;
        if (key == 1 || key == 10 || key == 24) subjectId = "13";  //语文
        else if (key == 2 || key == 11 || key == 23) subjectId = "14"; //数学
        else if (key == 3 || key == 12 || key == 25) subjectId = "40";  //英语
        else if (key == 4 || key == 13) subjectId = "16";  //物理
        else if (key == 5 || key == 14) subjectId = "17";  //化学
        else if (key == 6 || key == 15) subjectId = "18";  //生物
        else if (key == 7) subjectId = "99";  //道德与法治
        else if (key == 8 || key == 17) subjectId = "21";  //历史
        else if (key == 9 || key == 18) subjectId = "20";  //地理
        else if (key == 16) subjectId = "12";  //政治
        else if (key == 26) subjectId = "15";  //科学
        else if (key == 27 || key == 29) subjectId = "26";  //信息技术
        else if (key == 28) subjectId = "27";  //通用技术
        else if (key == 30) subjectId = "19";  //历史与社会
        return new CodeNameMapDTO(subjectId, dictionaryInfoService.matchSubjectName(subjectId));
    }

    private static void init(){
        //Init Xkw Stage associate Ourselves
        xkwStageRelationShips.put(1, "2");
        xkwStageRelationShips.put(2, "3");
        xkwStageRelationShips.put(3, "4");

        //Init Xkw Grade associate Ourselves
        xkwGradeRelationShips.put(1, "2101");
        xkwGradeRelationShips.put(2, "2102");
        xkwGradeRelationShips.put(3, "2103");
        xkwGradeRelationShips.put(4, "2105");
        xkwGradeRelationShips.put(5, "2107");
        xkwGradeRelationShips.put(6, "2109");
        xkwGradeRelationShips.put(7, "3101");
        xkwGradeRelationShips.put(8, "3102");
        xkwGradeRelationShips.put(9, "3103");
        xkwGradeRelationShips.put(10, "3401");
        xkwGradeRelationShips.put(11, "3402");
        xkwGradeRelationShips.put(12, "3403");

        //Init Xkw QuestionType associate Ourselves
        for (String type : simple_choice) {
            xkwQuestionTypeRelationShips.put(type, "01");
        }
        for (String type : fill_blank) {
            xkwQuestionTypeRelationShips.put(type, "03");
        }
        for (String type : charge_q) {
            xkwQuestionTypeRelationShips.put(type, "04");
        }
        for (String type : multi_choice) {
            xkwQuestionTypeRelationShips.put(type, "02");
        }
    }
}
