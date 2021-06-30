package com.enableets.edu.enable.cloud.sdk.exam.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author caleb_liu@enable-ets.com
 * @date 2021/05/17
 **/

@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FileInfoDTO {
    private String headName;
    private String fileId;
    private String name;
    private String md5;
    private Long size;
    private String slaveId;
    private String uuid;
    private String status;
    private String sizeDisplay;
    private String encoding;
    private String path;
    private String[] aliasName;
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    private Date createTime;
    private String description;
    private String ext;
    private List<String> downloadUrls;
}
