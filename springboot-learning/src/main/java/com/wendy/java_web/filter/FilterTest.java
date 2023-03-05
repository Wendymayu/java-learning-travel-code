package com.wendy.java_web.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/10/30 22:49
 * @Version 1.0
 */
//@WebFilter(urlPatterns = "/*",filterName = "filter1")
public class FilterTest implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("所有请求我都拦");

        // 业务逻辑
        if(servletRequest.getAttribute("name")==null){
            //servletRequest.getRequestDispatcher("404.html")
            HttpServletRequest request = (HttpServletRequest)servletRequest;
            HttpServletResponse response = (HttpServletResponse)servletResponse;
            request.getRequestDispatcher("index.html").forward(request,response);
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("过滤器生命结束");
    }
}
