package com.mofany.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description SpringBeansConfig SpringBeans.xml核心配置文件
 */
@Configuration
@ComponentScan(
        basePackages = {"com.mofany"},
        useDefaultFilters = true,
        excludeFilters = {@ComponentScan.Filter(value = {Controller.class})})
@PropertySource(value = {"classpath:db.properties"})
@MapperScan(basePackages = {"com.mofany.mapper"})
@EnableTransactionManagement
public class SpringBeansConfig {

    @Value("${jdbc.Driver}")
    private String driver;
    @Value("${jdbc.Url}")
    private String url;
    @Value("${jdbc.UserName}")
    private String userName;
    @Value("${jdbc.Password}")
    private String password;

    /**
     * 配置数据源
     * */
    @Bean(name = "dataSource")
    @Primary
    public DataSource setDataSource(){
        DruidDataSource druidDataSource=new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    /**
     * 配置SqlSessionFactory
     * */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean=new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setTypeAliasesPackage("com.mofany.entity");
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().
                getResources("classpath*:mapper/*Mapper.xml"));
        //创建分页插件实例
        PageInterceptor pageInterceptor=new PageInterceptor();
        Properties properties=new Properties();
        pageInterceptor.setProperties(properties);
        sessionFactoryBean.setPlugins(pageInterceptor);
        return sessionFactoryBean.getObject();
    }

    /**
     * 配置声明式事务管理器
     * */
    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager setTransactionManager(@Qualifier("dataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

}
