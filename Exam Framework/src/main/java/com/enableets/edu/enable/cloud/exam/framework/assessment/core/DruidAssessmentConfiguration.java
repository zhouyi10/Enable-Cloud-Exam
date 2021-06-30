package com.enableets.edu.enable.cloud.exam.framework.assessment.core;

import com.alibaba.druid.pool.DruidDataSource;
import com.enableets.edu.enable.cloud.exam.framework.core.DataSourceCreator;
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
@ConditionalOnProperty(prefix = "druid.assessment",name="url")
@MapperScan(basePackages = {"com.enableets.edu.cloud.exam.framework.assessment.dao", "com.enableets.edu.cloud.exam.framework.assessment.v20.dao", "com.enableets.edu.cloud.exam.framework.assessment.business.dao"}, sqlSessionTemplateRef  = "assessmentSqlSessionTemplate")
public class DruidAssessmentConfiguration {

    /**account microService dataSourse druidPictureProperties*/
    @Autowired
    private DruidAssessmentProperties druidAssessmentProperties;


    @Bean(name="assessmentDataSource")
    public DataSource accountDataSource(){
        return new DataSourceCreator(druidAssessmentProperties).create();
    }

    @Bean(name = "assessmentSqlSessionFactory")
    public SqlSessionFactory assessmentSqlSessionFactory(@Qualifier("assessmentDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(druidAssessmentProperties.getMapperLocations()));
        return bean.getObject();
    }

    @Bean(name = "assessmentTransactionManager")
    public DataSourceTransactionManager assessmentTransactionManager(@Qualifier("assessmentDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "assessmentSqlSessionTemplate")
    public SqlSessionTemplate assessmentSqlSessionTemplate(@Qualifier("assessmentSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
