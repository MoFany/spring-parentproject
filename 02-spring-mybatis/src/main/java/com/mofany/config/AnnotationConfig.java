package com.mofany.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author MoFany-J
 * @date 2023/1/2
 * @description AnnotationConfig 基于注解的Spring配置文件类（Spring+MyBatis）
 */
@Configuration
/**
 * 引用外部properties文件
 * */
@PropertySource(value = "classpath:db.properties")
/**
 * 配置组件扫描
 * */
@ComponentScan(value = "com.mofany")
/**
 * 利用注解进行mapper接口扫描
 * */
@MapperScan(basePackages = {"com.mofany.mapper"},sqlSessionTemplateRef = "sqlSessionTemplate")
/**
 * 利用注解启用声明式事务管理
 * */
@EnableTransactionManagement
public class AnnotationConfig {
    /**
     * 设置成员变量即驱动、url、用户名、密码
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
     * 1.配置数据源
     * */
    @Bean(name = "dataSource")
    @Primary
    public DataSource setDataSource(){
        //创建druid数据源实例
        DruidDataSource dataSource=new DruidDataSource();
        //指定驱动
        dataSource.setDriverClassName(driver);
        //指定url
        dataSource.setUrl(url);
        //指定用户名
        dataSource.setUsername(userName);
        //指定密码
        dataSource.setPassword(password);
        return dataSource;
    }

    /**
     * 2.方法一：配置SqlSessionFactoryBean
     * */
    @Bean(name = "sqlSessionFactoryBean")
    @Primary
    public SqlSessionFactoryBean setSqlSessionFactoryBean(@Qualifier("dataSource")DataSource dataSource) throws IOException {
        //创建SqlSessionFactoryBean实例
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        //指定数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //指定对应包的类型别名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.mofany.entity");
        //指定映射器位置
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*Mapper.xml"));

        /*创建分页插件*/
        //创建页面拦截器实例
        PageInterceptor interceptor=new PageInterceptor();
        //创建属性实例
        Properties properties=new Properties();
        //设置属性
        properties.setProperty("helperDialect","MYSQL");
        //给拦截器指定属性
        interceptor.setProperties(properties);
        //指定插件
        sqlSessionFactoryBean.setPlugins(interceptor);
        return sqlSessionFactoryBean;
    }

    /**
     * 2.方法二：配置SqlSessionFactory
     * */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory setSqlSessionFactory(@Qualifier("dataSource")DataSource dataSource) throws Exception {
        //通过MyBatis Spring模块提供的SqlSessionFactoryBean来创建MyBatis的SqlSessionFactory实例
        SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
        //指定数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //指定mapper映射器位置
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:mapper/*Mapper.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * 配置SqlSessionTemplate
     * */
    @Bean(name = "sqlSessionTemplate")
    @Primary
    public SqlSessionTemplate setSessionTemplate(@Qualifier("sqlSessionFactory")SqlSessionFactory sqlSessionFactory){
        //创建MyBatis Spring模块中的SqlSessionTemplate实例
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 3.配置声明式事务管理：给数据源添加事务管理
     * */
    @Bean(name = "dataSourceTransactionManager")
    public DataSourceTransactionManager setDataSourceTransactionManager(@Qualifier("dataSource") DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }
}
