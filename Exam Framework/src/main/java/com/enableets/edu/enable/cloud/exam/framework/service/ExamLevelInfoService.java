package com.enableets.edu.enable.cloud.exam.framework.service;

import com.enableets.edu.enable.cloud.exam.framework.bo.ExamLevelInfoBO;
import com.enableets.edu.enable.cloud.exam.framework.bo.ExamLevelTemplateBO;
import com.enableets.edu.enable.cloud.exam.framework.dao.ExamLevelInfoDAO;
import com.enableets.edu.enable.cloud.exam.framework.dao.ExamLevelTemplateDAO;
import com.enableets.edu.enable.cloud.exam.framework.po.ExamLevelInfoPO;
import com.enableets.edu.enable.cloud.exam.framework.po.ExamLevelTemplatePO;
import com.enableets.edu.framework.core.service.ServiceAdapter;
import com.enableets.edu.framework.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamLevelInfoService extends ServiceAdapter<ExamLevelInfoBO, ExamLevelInfoPO> {

    @Autowired
    private ExamLevelInfoDAO examLevelInfoDAO;

    @Autowired
    private ExamLevelTemplateDAO adminExamLevelTemplateDAO;


    /**
     * 查询考试等级
     * @param schoolId
     * @param gradeCode
     * @return
     */
    public List<ExamLevelInfoBO> getExamLevelList(String  schoolId,String  gradeCode){
        List<ExamLevelInfoPO> examInfoList = examLevelInfoDAO.getExamInfo(schoolId,gradeCode);

        if(examInfoList.isEmpty()){
            List<ExamLevelTemplatePO> levelTemlate = adminExamLevelTemplateDAO.getLevelTemlate();
            return BeanUtils.convert(levelTemlate,ExamLevelInfoBO.class);
        }

        return BeanUtils.convert(examInfoList,ExamLevelInfoBO.class);
    }

    // 从sms_exam_level_template表查询考试分数等级
    public List<ExamLevelTemplateBO> getLevelTemlate() {
        return BeanUtils.convert(adminExamLevelTemplateDAO.getLevelTemlate(), ExamLevelTemplateBO.class);
    }

}
