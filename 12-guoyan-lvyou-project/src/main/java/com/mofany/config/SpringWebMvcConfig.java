package com.mofany.config;

import com.mofany.interceptors.MyInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;


/**
 * @author MoFany-J
 * @date 2023/2/1
 * @description SpringWebMvcConfig SpringMVC配置
 */
@Configuration
@ComponentScan(basePackages = {"com.mofany.controller"})
@EnableWebMvc
public class SpringWebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
    }

    /**
     * 添加跨域映射
     * */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }

    /**
     * 整合Thymeleaf：模版解析器
     * */
    @Bean(name = "templateResolver")
    @Primary
    public SpringResourceTemplateResolver setSpringResourceTemplateResolver(){
        SpringResourceTemplateResolver templateResolver=new SpringResourceTemplateResolver();
        templateResolver.setCacheable(false);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");
        return templateResolver;
    }

    /**
     * 整合Thymeleaf：模版引擎
     * */
    @Bean(name = "templateEngine")
    @Primary
    public SpringTemplateEngine setSpringTemplateEngine(@Qualifier("templateResolver")SpringResourceTemplateResolver templateResolver){
        SpringTemplateEngine templateEngine=new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        //SpringEl表达式启用
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    /**
     * 整合Thymeleaf：视图解析器
     * */
    @Bean(name = "viewResolver")
    @Primary
    public ThymeleafViewResolver setThymeleafViewResolver(@Qualifier("templateEngine")SpringTemplateEngine templateEngine){
        ThymeleafViewResolver thymeleafViewResolver=new ThymeleafViewResolver();
        thymeleafViewResolver.setTemplateEngine(templateEngine);
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        return thymeleafViewResolver;
    }

    /**
     * 添加视图控制器
     * */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    /**
     * 添加资源处理器
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**").addResourceLocations("/templates/");
    }

}
