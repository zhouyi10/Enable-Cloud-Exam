package com.enableets.edu.enable.cloud.exam.manager.bo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Map;

/**
 * @author justice_zhou@enable-ets.com
 * @date 2021/6/28
 **/

@Data
public class TeacherBaseInfoBO {

    private String schoolId;

    private String schoolName;

    private String termId;

    private String termName;

    private String stageCode;

    private String stageName;

    private String gradeCode;

    private String gradeName;

    private String subjectCode;

    private String subjectName;

    private CodeNameMapBO materialVersion;

    private Map<String, String> classMap;

}
