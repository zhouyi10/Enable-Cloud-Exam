package com.enableets.edu.enable.cloud.sdk.exam;


import com.enableets.edu.enable.cloud.sdk.exam.dto.QueryExamDictionaryDTO;
import com.enableets.edu.enable.cloud.sdk.exam.dto.QueryExamDictionaryResultDTO;

import java.util.List;

/**
 * @Auther: ayu_chen@enable-ets.com
 * @Date: 2019/1/23 16:20
 * @Description: 数据字典接口
 */
public interface IExamDictionaryService {

    public List<QueryExamDictionaryResultDTO> query(QueryExamDictionaryDTO query);
}
