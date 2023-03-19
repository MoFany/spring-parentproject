package com.mofany.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description WebIntegrateConfig Web.xml整合
 */
public class WebIntegrateConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 获取Spring配置类
     * */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringBeansConfig.class};
    }

    /**
     * 获取SpringMVC配置类
     * */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /**
     * 获取DispatcherServlet的映射
     * */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
