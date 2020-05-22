package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//前端客户端的网页请求起作用
@Configuration
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/UpTopic").setViewName("UpTopic");
        registry.addViewController("/userChangePwd").setViewName("userChangePwd");
        registry.addViewController("/teacherindex").setViewName("TeacherIndex");
        registry.addViewController("/teaLogin").setViewName("teaLogin");
        registry.addViewController("/TeaTimer").setViewName("TeaTimer");

    }

    //静态资源访问
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
    //客户端请求允许
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns("/index.html","/user/login","/","/user/login01","/a");
//    }
}
