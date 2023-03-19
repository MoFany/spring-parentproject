package com.mofany.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author MoFany-J
 * @date 2023/1/5
 * @description CharacterEncodingFilterUtf8 自定义编码过滤器
 */
@WebFilter("/*")
public class CharacterEncodingFilterUtf8 implements Filter{
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest) request;
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;
        httpServletRequest.setCharacterEncoding("UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        chain.doFilter(httpServletRequest,httpServletResponse);
    }
}
