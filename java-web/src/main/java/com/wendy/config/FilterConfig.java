
package com.wendy.config;

import com.wendy.filter.FilterTest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;


/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/10/30 23:17
 * @Version 1.0
 */

//@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new FilterTest());
        registration.addUrlPatterns("/*");
        registration.setName("filter2");
        registration.setOrder(2);
        return registration;
    }
}
