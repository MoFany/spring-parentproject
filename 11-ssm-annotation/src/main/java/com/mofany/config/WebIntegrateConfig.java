package com.mofany.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author MoFany-J
 * @date 2023/1/23
 * @description WebIntegrateConfig 自定义web整合类
 */
public class WebIntegrateConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 整合配置Spring
     * */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringBeansConfig.class};
    }

    /**
     * 整合配置SpringMVC
     * */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /**
     * Servlet映射路径
     * */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
