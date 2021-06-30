package com.enableets.edu.enable.cloud.exam.framework.service;

import com.enableets.edu.enable.cloud.exam.framework.bo.ExamDictionaryBO;
import com.enableets.edu.enable.cloud.exam.framework.dao.ExamDictionaryDAO;
import com.enableets.edu.enable.cloud.exam.framework.po.ExamDictionaryPO;
import com.enableets.edu.framework.core.service.ServiceAdapter;
import com.enableets.edu.framework.core.util.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 15:38
 * @Description: 考试字典Service
 */
@Service
public class ExamDictionaryService extends ServiceAdapter<ExamDictionaryBO, ExamDictionaryPO> {

    @Autowired
    private ExamDictionaryDAO examDictionaryDAO;

    /**
     * 查询字典数据
     * @return
     */
    public List<ExamDictionaryBO> query(ExamDictionaryBO query){
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("schoolId", query.getSchoolId());
        condition.put("type", query.getType());
        condition.put("code", query.getCode());
        List<ExamDictionaryPO> list = examDictionaryDAO.query(condition);
        return BeanUtils.convert(list , ExamDictionaryBO.class);
    }

}
