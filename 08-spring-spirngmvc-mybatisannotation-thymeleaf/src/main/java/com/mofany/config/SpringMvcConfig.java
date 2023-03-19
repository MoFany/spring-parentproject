package com.mofany.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description SpringMvcConfig SpringMVC.xml核心配置
 */
@Configuration
@ComponentScan(basePackages = {"com.mofany.controller"})
@EnableWebMvc
public class SpringMvcConfig implements WebMvcConfigurer {

    /**
     * Thymeleaf资源模版解析器
     * */
    @Bean(name = "templateResolver")
    @Primary
    public SpringResourceTemplateResolver setTemplateResolver(){
        SpringResourceTemplateResolver templateResolver=new SpringResourceTemplateResolver();
        templateResolver.setCharacterEncoding("UTF8");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/static/view/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    /**
     * Thymeleaf模版引擎
     * */
    @Bean(name = "templateEngine")
    @Primary
    public SpringTemplateEngine setTemplateEngine(@Qualifier("templateResolver") SpringResourceTemplateResolver templateResolver){
        SpringTemplateEngine templateEngine=new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        templateEngine.setEnableSpringELCompiler(true);
        return templateEngine;
    }

    /**
     * Thymeleaf视图解析器
     * */
    @Bean(name = "viewResolver")
    @Primary
    public ThymeleafViewResolver setViewResolver(@Qualifier("templateEngine") SpringTemplateEngine templateEngine){
        ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
        viewResolver.setCharacterEncoding("UTF8");
        viewResolver.setTemplateEngine(templateEngine);
        return viewResolver;
    }

    /**
     * 静态资源放行
     * */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    /**
     * 视图控制器，视图转发（无业务逻辑跳转）
     * */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //添加视图控制器并指定视图名
        registry.addViewController("view/boot").setViewName("boot");
    }

    /**
     * 跨域放行注解 @CrossOrigin
     * */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                //允许跨域的源
                .allowedOrigins("*")
                //允许跨域的方法
                .allowedMethods("*")
                //允许跨域的请求头
                .allowedHeaders("*");
    }
}
