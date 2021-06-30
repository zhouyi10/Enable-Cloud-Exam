package com.enableets.edu.enable.cloud.exam.manager.paper.bo;

/**
 * 纸本作业文件信息
 *
 * @author caleb_liu@enable-ets.com
 * @date 2019/7/29 13:52
 */

public class PaperWorkFileBO {

    /** 文件file id */
    private String fileId;

    /** 文件名称 */
    private String fileName;

    /** 文件url */
    private String url;

    /** 文件md5 */
    private String md5;

    /** 文件大小 */
    private String size;

    /** 文件顺序 */
    private Integer sequencing;

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getSequencing() {
        return sequencing;
    }

    public void setSequencing(Integer sequencing) {
        this.sequencing = sequencing;
    }
}
