package com.xuewuzhijing.springboot.system.config;

import com.xuewuzhijing.springboot.system.filter.MyFilter;
import com.xuewuzhijing.springboot.system.listener.Mylistener;
import com.xuewuzhijing.springboot.system.servlet.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @ClassName MyServerConfigure
 * @Description TODO
 * @Author xuewuzhijing
 * @Date 19/11/4 22:17
 * @Version 1.0
 **/
@Configuration
public class MyServerConfig {
//    @Bean
//    public WebServerFactoryCustomizer webServerFactoryCustomizer(){
//        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
//            //定制嵌入式servlet容器的规则
//            @Override
//            public void customize(ConfigurableServletWebServerFactory factory) {
//                factory.setPort(80);
//            }
//        };
//    }

    //注册三大组件
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        //@see ServletRegistrationBean有参构造,访问的路径
        return new ServletRegistrationBean<MyServlet>(new MyServlet(),"/myServlet");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<MyFilter> filterRegistrationBean=new FilterRegistrationBean<MyFilter>();
        filterRegistrationBean.setFilter(new MyFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/myfilter","/aaa"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        return new ServletListenerRegistrationBean<Mylistener>(new Mylistener());
    }
}
