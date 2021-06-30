package com.enableets.edu.enable.cloud.exam.manager.paper.vo;

import lombok.Data;

/**
 * @author walle_yu@enable-ets.com
 * @since 2020/10/22
 **/
@Data
public class FileInfoVO {

    private String fileId;

    private String fileName;

    private String fileExt;

    private String url;

    private String md5;

    private Long size;

    private String sizeDisplay;

    private Integer fileOrder;
}
