package com.enableets.edu.enable.cloud.exam.framework.core;

import com.alibaba.druid.pool.DruidDataSource;
import com.enableets.edu.framework.core.dao.datasource.DruidProperties;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author walle_yu@enable-ets.com
 * @since 2020/08/04
 **/
public class DataSourceCreator {

    private DruidProperties properties;

    public DataSourceCreator(DruidProperties properties) {
        this.properties = properties;
    }

    public DataSource create(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        if (properties.getInitialSize() > 0) {
            dataSource.setInitialSize(properties.getInitialSize());
        }
        if (properties.getMinIdle() > 0) {
            dataSource.setMinIdle(properties.getMinIdle());
        }
        if (properties.getMaxActive() > 0) {
            dataSource.setMaxActive(properties.getMaxActive());
        }
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());

        dataSource.setTestOnReturn(properties.isTestOnReturn());
        dataSource.setTestWhileIdle(properties.isTestWhileIdle());
        // The recommended configuration is true, which does not affect performance and guarantees security. Check when applying for connection,
        // If the idle time is greater than time Between Eviction Runs Millis, perform a validation query to check whether the connection is valid.
        if (properties.getValidationQuery() != null) {
            // 用来检测连接是否有效的sql，要求是一个查询语句。
            // 如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会起作用。
            dataSource.setValidationQuery(properties.getValidationQuery());
        }
        if (properties.getTimeBetweenEvictionRunsMillis() > 0) {
            // 多久检测一次空闲连接，单位是毫秒
            dataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        }
        if (properties.getMinEvictableIdleTimeMillis() > 0) {
            // 池中的连接保持空闲而不被驱逐的最小时间，单位是毫秒
            dataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        }
        dataSource.setConnectionInitSqls(properties.getConnectionInitSqls());
        try {
            dataSource.init();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }

}
