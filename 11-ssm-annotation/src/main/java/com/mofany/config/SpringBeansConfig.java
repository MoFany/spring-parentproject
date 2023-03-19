package com.mofany.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
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
import java.io.IOException;
import java.util.Properties;

/**
 * @author MoFany-J
 * @date 2023/1/23
 * @description SpringBeansConfig 自定义Spring配置类
 */
@Configuration
@ComponentScan(
        basePackages = {"com.mofany"},
        useDefaultFilters = true,
        excludeFilters = {@ComponentScan.Filter(value = Controller.class)}
) // 组件扫描

@MapperScan(basePackages = {"com.mofany.mapper"}) //映射器扫描
@PropertySource(value = {"classpath:db.properties"}) // 属性源，即数据源
@EnableTransactionManagement // 开启声明式事务
public class SpringBeansConfig {

    /**
     * 数据源属性成员变量
     * */
    @Value("${jdbc.Driver}")
    private String driver;
    @Value("${jdbc.Url}")
    private String url;
    @Value("${jdbc.UserName}")
    private String userName;
    @Value("${jdbc.Password}")
    private String password;

    /**
     * 数据源
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
    @Primary
    public SqlSessionFactoryBean setSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.mofany.entity");
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper.xml"));
        //设置插件
        PageInterceptor pageInterceptor=new PageInterceptor();
        Properties properties=new Properties();
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(pageInterceptor);
        return sqlSessionFactoryBean;
    }

    /**
     * 配置事务管理器
     * */
    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager setDataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
