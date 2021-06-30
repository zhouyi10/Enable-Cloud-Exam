package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author duffy_ding
 * @since 2020/07/29
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Accessors(chain = true)
public class QueryExamInfoDTO {

    /** school id */
    private String schoolId;

    /** term id */
    private String termId;

    /** user id */
    private String userId;

    /** exam name */
    private String examName;

    /** class id */
    private String classId;

    /** course id  */
    private String courseId;

    /** offset */
    private Integer offset;

    /** rows */
    private Integer rows;

}
