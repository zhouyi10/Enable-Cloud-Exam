package com.enableets.edu.enable.cloud.exam.manager.paper.bo;

import lombok.Data;

import java.util.List;

/**
 * @author walle_yu@enable-ets.com
 * @since 2020/08/10
 **/
@Data
public class BaseSearchConditionBO {

    private List<StageInfoBO> stages;

    private List<GradeInfoBO> grades;

    private List<SubjectInfoBO> subjects;
}
