package com.enableets.edu.enable.cloud.exam.framework.utils;


import com.enableets.edu.enable.cloud.exam.framework.core.Constants;

/**
 * @author duffy_ding
 * @since 2020/07/29
 */
public class Utils {

    /**
     * 查询资料总数量，默认50，最大单次200
     * @param rows 数量
     * @return 处理后查询数量
     */
    public static Integer rows(Integer rows) {
        if (rows == null || rows < 0) {
            rows = Constants.DEFAULT_QUERY_ROWS;
        } else if (rows > Constants.MAX_QUERY_ROWS) {
            rows = Constants.MAX_QUERY_ROWS;
        }
        return rows;
    }

    /**
     * 查询资料起始位置，默认为0
     * @param offset 起始位置
     * @return 处理后起始位置
     */
    public static Integer offset(Integer offset) {
        if (offset == null || offset < 0) {
            offset = 0;
        }
        return offset;
    }
}
