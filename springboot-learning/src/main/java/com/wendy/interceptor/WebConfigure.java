package com.wendy.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 马文迪
 * @Date: 2021/02/01/10:43
 * @Description:
 * @Version:
 */
//继承WebMvcConfigurer之后可以配置MVC的一些特性，比如可以自定义拦截器
@Configuration
public class WebConfigure implements WebMvcConfigurer {


    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/student/**").addPathPatterns("/teacher/**")
                .excludePathPatterns("/login", "/index.html");
    }
    // 设置跨域访问
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "TRACE")
                .allowCredentials(true)
                .allowedHeaders("*")
                .maxAge(3600);
    }

}
