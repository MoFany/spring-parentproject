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
 * @date 2023/2/1
 * @description SpringBeansConfig Spring配置
 */
@Configuration
@ComponentScan(
        basePackages = {"com.mofany"},
        useDefaultFilters = true,
        excludeFilters = {@ComponentScan.Filter(value = Controller.class)}
)
@PropertySource(value = "classpath:db.properties")
@MapperScan(basePackages = {"com.mofany.mapper"})
@EnableTransactionManagement
public class SpringBeansConfig {

    /**
     * 配置用户数据源属性
     */
    @Value("${jdbc.Driver}")
    private String driver;
    @Value("${jdbc.Url}")
    private String url;
    @Value("${jdbc.UserName}")
    private String userName;
    @Value("${jdbc.Password}")
    private String password;

    /**
     * 配置数据源方法
     */
    @Bean(name = "dataSource")
    @Primary
    public DataSource setDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);
        return druidDataSource;
    }

    /**
     * SqlSessionFactoryBean Sql会话工程实例
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactoryBean setSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.mofany.entity");
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath*:mapper/*Mapper.xml"));
        //配置分页插件：pagehelper
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "MYSQL");
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(pageInterceptor);
        return sqlSessionFactoryBean;
    }


    /**
     * 声明式事务
     */
    @Bean(name = "transactionManager")
    @Primary
    public DataSourceTransactionManager setDataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
