package com.enableets.edu.enable.cloud.exam.manager.core;

/**
 * Constants Class
 *
 * @author caleb_liu@enable-ets.com
 * @date 2021/05/13
 **/

public class Constants {

    public static final String CONTEXT_PATH = "/manager/examination";

    /** 日期时间格式  */
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /** Default time zone */
    public static final String DEFAULT_DATE_ZONE = "GMT+8";

    /** 个人来源编码*/
    public static final String PROVIDER_CODE_DEFAULT = "R00";

    /** 字典 资源类型：试卷*/
    public static final String DICTIONARY_CONTENT_TYPE_PAPER = "C15";

    /** 当前学期状态  */
    public static final String STATUS_CURRENT_TERM = "2";

    /** 年级字典类型  */
    public static final String DICTIONARY_TYPE_GRADE = "03";

    /** 学段字典类型 **/
    public static final String DICTIONARY_STAGE_TYPE_CODE = "02";

    /** 难易度字典类型 **/
    public static final String DICTIONARY_DIFFICULTY_TYPE_CODE = "08";

    /** 字典 科目类型*/
    public static final String DICTIONARY_SUBJECT_TYPE_CODE = "01";

    /** 字典 教材版本类型*/
    public static final String DICTIONARY_MATERIAL_TYPE_CODE = "12";

    /** 题型字典类型 **/
    public static final String DICTIONARY_QUESTONTYPE_TYPE_CODE = "11";

    /** 能力值字典类型 **/
    public static final String DICTIONARY_ABILITY_TYPE_CODE = "09";

    /** 默认学校id **/
    public static final String DEFAULT_SCHOOL_ID = "999999";

    /** Cache Expire Time : 30 Min*/
    public static final Long DEFAULT_REDIS_CACHE_EXPIRE_TIME = 30 * 60L;


    public static final String PACKAGE_CACHE_KEY_PREFIX = "com:enableets:edu:package:";



 /*   *//** Default date and time format *//*
    public static final String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    *//** Default time zone *//*
    public static final String DEFAULT_DATE_ZONE = "GMT+8";*/

    public static final String CONTENT_PUBLIC_TYPE = "R01";

    public static final String CONTENT_SCHOOL_TYPE = "R02";

    public static final String CONTENT_PRIVATE_TYPE = "R00";

    public static final String DEFAULT_SCHOOL = "999999";

    /**content:stage type*/
    public static final String CONTENT_DICTIONARY_TYPE_STAGE = "02";

    /**content:grade type*/
    public static final String CONTENT_DICTIONARY_TYPE_GRADE = "03";

    /**content:subject type*/
    public static final String CONTENT_DICTIONARY_TYPE_SUBJECT = "01";

    /**content:materialVersion type*/
    public static final String CONTENT_DICTIONARY_TYPE_MATERIAL_VERSION = "12";

    /**content:ability type*/
    public static final String CONTENT_DICTIONARY_TYPE_ABILITY = "09";

    /**content:questionType type*/
    public static final String CONTENT_DICTIONARY_TYPE_QUESTION_TYPE = "11";

    /**content:difficulty type*/
    public static final String CONTENT_DICTIONARY_TYPE_DIFFICULTY = "08";

    /** Content: type Code*/
    public static final String CONTENT_TYPE_EXAM = "C15";

    /***/
    public static final String HEAD_X_FRAME_OPTIONS = "X-Frame-Options";

    /***/
    public static final String HEAD_ALLOWALL = "ALLOWALL";

    public static final String MODEL_KEY_CONTENT_MANAGER_URL = "contentManagerUrl";

    /** Course type:obligatory */
    public static final String COURSE_SELECTION_TYPE_REQUIRED = "1";

    /**teaching methods: Offline */
    public static final String COURSE_TEACHING_METHOD_OFFLINE = "2";



    /** Assign review type*/
    public static final String ASSIGNER_ACTION_TYPE = "1";

    /** Review completed*/
    public static final String MARK_TYPE_COMPLETE = "1";


    /** Teacher role code**/
    public static final String TEACHER_IDENTITY_CODE = "1";

    /** Student role code */
    public static final String STUDENT_IDENTITY_CODE = "2";

    /** Administrator role code*/
    public static final String ADMIN_IDENTITY_CODE = "3";
    public static final String ANSWERCARD_ADD_QUESTION_TYPE = "@@word@@";
    public static final String SELECT_QUESTION_TYPE_CODE = "@@03@@02@@";
    /** 真题迁移库 */
    public static final String ZT_CODE = "RZT";
    public static final String ZT_NAME = "真题迁移库";
    /** 求解答资源编码*/
    public static final String PROVIDER_CODE_QIUJIEDA = "R04";

/*
    */
/** 老师角色代码**//*

    public static final String TEACHER_IDENTITY_CODE = "1";

    */
/** 学生角色代码 *//*

    public static final String STUDENT_IDENTITY_CODE = "2";

    */
/** 管理员角色代码*//*

    public static final String ADMIN_IDENTITY_CODE = "3";
*/

}
