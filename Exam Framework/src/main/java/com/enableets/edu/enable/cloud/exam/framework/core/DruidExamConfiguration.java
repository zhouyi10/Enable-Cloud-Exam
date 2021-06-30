package com.enableets.edu.enable.cloud.exam.framework.core;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * Multi-data source configuration -- pricure-microservice configuration
 */

@Configuration
@ConditionalOnClass(DruidDataSource.class)
@AutoConfigureBefore(DataSourceAutoConfiguration.class)
@ConditionalOnProperty(prefix = "druid.exam",name="url")
@MapperScan(basePackages = {"com.enableets.edu.enable.cloud.exam.framework.dao"}, sqlSessionTemplateRef  = "examSqlSessionTemplate")
public class DruidExamConfiguration {

    /**account microService dataSourse druidPictureProperties*/
    @Autowired
    private DruidExamProperties druidExamProperties;


    @Bean(name= "examDataSource")
    @Primary
    public DataSource accountDataSource(){
        return new DataSourceCreator(druidExamProperties).create();
    }

    @Bean(name = "examSqlSessionFactory")
    @Primary
    public SqlSessionFactory examSqlSessionFactory(@Qualifier("examDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(druidExamProperties.getMapperLocations()));
        return bean.getObject();
    }

    @Bean(name = "examTransactionManager")
    @Primary
    public DataSourceTransactionManager examTransactionManager(@Qualifier("examDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "examSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate examSqlSessionTemplate(@Qualifier("examSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
