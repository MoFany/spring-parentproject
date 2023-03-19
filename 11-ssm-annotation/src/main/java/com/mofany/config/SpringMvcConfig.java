package com.mofany.config;

import com.mofany.interceptors.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * @author MoFany-J
 * @date 2023/1/23
 * @description SpringMvcConfig 自定义SpringMVC配置类
 */
@Configuration
@ComponentScan(basePackages = {"com.mofany.controller"})
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    private MyInterceptor myInterceptor;

    /**
     * 构造器注入
     * */
    @Autowired
    public SpringMvcConfig(MyInterceptor myInterceptor){
        this.myInterceptor=myInterceptor;
    }

    /**
     * 添加拦截器（进行请求的拦截）
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * 对所有除了文件上传的请求进行拦截
         * */
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/fileUpload/**");
    }

    /**
     * 添加资源处理器（静态资源放行）
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static");
    }

    /**
     * 配置全局跨源访问（支持注解标识）
     * */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*") // 支持所有域名进行跨域访问
                .allowedHeaders("*")    // 支持所有请求头进行跨域访问
                .allowedMethods("*");   // 支持所有方法进行跨域访问
    }

    /**
     * 配置视图解析器方式1：（进行有业务逻辑的视图跳转）
     * */
    @Bean(name = "viewResolver")
    @Primary
    public InternalResourceViewResolver setViewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
        //指定资源路径前缀
        viewResolver.setPrefix("static/view/");
        //指定资源路径后缀
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * 配置视图解析器方式2：（进行有业务逻辑的视图跳转）
     * */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("static/view/",".jsp");
    }

    /**
     * 添加视图控制器（进行无业务逻辑的视图跳转）
     * 视图解析器与视图控制器并存时:
     *  视图解析器的前缀与后缀会作为视图控制器中指定视图的拼接前缀与后缀
     * */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       /**
        * 处理跳转至错误页请求
        * */
        registry.addViewController("/error")
                .setViewName("error");
        /**
         * 处理跳转至文件上传页的请求
         * */
        registry.addViewController("/fileUpload")
                .setViewName("file/fileupload");
    }

    /**
     * 配置文件上传MultipartResolve
     * */
    @Bean("multipartResolver")
    @Primary
    public CommonsMultipartResolver setMultipartResolver(){
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
        //设置默认编码
        multipartResolver.setDefaultEncoding("utf-8");
        //设置资源懒加载
        multipartResolver.setResolveLazily(true);
        //设置Servlet上下文
//        multipartResolver.setServletContext();
        //设置支持的请求方式
        multipartResolver.setSupportedMethods("POST","PUT");
        //设置最大内存大小
        multipartResolver.setMaxInMemorySize(40960);
        //设置最大上传大小
        multipartResolver.setMaxUploadSize(10485760);
        //设置单个文件的最大上传大小
        multipartResolver.setMaxUploadSizePerFile(102400);
        //设置保留原文件名
        multipartResolver.setPreserveFilename(true);
        //设置上传的临时目录
//        multipartResolver.setUploadTempDir(new ClassPathResource("temp"));
        return multipartResolver;
    }
}
