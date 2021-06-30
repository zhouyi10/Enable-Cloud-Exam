package com.enableets.edu.enable.cloud.exam.framework.bo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23
 * @Description: 录分老师安排BO
 */
@Data
@Accessors(chain = true)
public class ExamPointInputSettingBO {

    /**
     * 考试明细标识
     */
    private Long examDetailsId;

    /**
     * 老师标识
     */
    private String userId;

    /**
     * 老师名称
     */
    private String fullName;
    
    private String type;
    
    
    private String classId;
    
    
    private String className;
    
    
    private String gradeCode;

}
