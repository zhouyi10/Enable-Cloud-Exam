package com.enableets.edu.enable.cloud.exam.framework.service;

import com.enableets.edu.enable.cloud.exam.framework.bo.ExamResultInfoBO;
import com.enableets.edu.enable.cloud.exam.framework.dao.ExamResultInfoDAO;
import com.enableets.edu.enable.cloud.exam.framework.po.ExamResultInfoPO;
import com.enableets.edu.framework.core.service.ServiceAdapter;
import com.enableets.edu.framework.core.util.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Jack_Dong@enable-ets.com
 * @since 2018/11/30
 */
@Service
public class ExamResultInfoService extends ServiceAdapter<ExamResultInfoBO, ExamResultInfoPO> {

    @Autowired
    private ExamResultInfoDAO examResultInfoDAO;

    /**
     * 批量添加/修改学生成绩
     * @param examResultInfoBOList
     * @return
     */
    @Transactional
    public Boolean addOrEditExamResultInfo(List<ExamResultInfoBO> examResultInfoBOList){
       if (!examResultInfoBOList.isEmpty()){
           Integer num = examResultInfoDAO.batchInsert(BeanUtils.convert(examResultInfoBOList,ExamResultInfoPO.class));
           if(num > 0){
        	   return true;
           }else{
        	   return false;
           }
       }else{
    	   return false;
       }
    }

    public List<ExamResultInfoBO> getExamResultInfo(Long examDetailsId){
        List<ExamResultInfoPO> examResultInfoList = examResultInfoDAO.getExamResultInfo(examDetailsId);
        return CollectionUtils.isNotEmpty(examResultInfoList) ? BeanUtils.convert(examResultInfoList, ExamResultInfoBO.class) : null;
    }
}
