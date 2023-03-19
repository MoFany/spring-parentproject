package com.mofany.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @author MoFany-J
 * @date 2023/2/1
 * @description WebIntegrateConfig web整合类
 */
public class WebIntegrateConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    /**
     * Spring配置
     * */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringBeansConfig.class};
    }

    /**
     * SpringMvc配置
     * */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringWebMvcConfig.class};
    }

    /**
     * 获取DispatcherServlet的映射,
     * 会将一个或多个路径映射到DispatcherServlet
     * */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
