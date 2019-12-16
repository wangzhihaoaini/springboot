package com.xuewuzhijing.springboot.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyWebMvcConfigure
 * @Description TODO
 * @Author xuewuzhijing
 * @Date 19/10/19 20:38
 * @Version 1.0
 **/
@Configuration
//@EnableWebMvc   可以完全接管spring boot的mvc，默认配置将不起作用
public class WebMvcConfig implements WebMvcConfigurer {
    //这个方法可以设置多个映射,切记不可忘记@Bean注解
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/student").setViewName("student/student");
            }

            //注册自定义拦截器 addPathPatterns 拦截的请求  excludePathPatterns放行的请求
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("index.html","/login","/user/login","/user/register",
//                                "/css/**","/fonts/**","/img/**","/js/**");
//            }
        };
        return webMvcConfigurer;
    }

    //添加自定义国际化解析器组件
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
