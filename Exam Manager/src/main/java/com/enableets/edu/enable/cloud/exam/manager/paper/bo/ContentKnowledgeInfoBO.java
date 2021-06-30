package com.enableets.edu.enable.cloud.exam.manager.paper.bo;

import lombok.Data;

/**
 * @author walle_yu@enable-ets.com
 * @since 2020/08/06
 **/
@Data
public class ContentKnowledgeInfoBO {

    private String knowledgeId;

    private String parentId;

    private String knowledgeName;

    private String gradeCode;

    private String subjectCode;

    private String materialVersion;

    private String materialVersionName;

    private String searchCode;
}
