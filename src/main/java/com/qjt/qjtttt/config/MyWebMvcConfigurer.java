package com.qjt.qjtttt.config;

import com.qjt.qjtttt.intercepter.MyInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    private Logger logger=LoggerFactory.getLogger(MyWebMvcConfigurer.class);

    @Bean
    public HandlerInterceptor getMyInterceptor(){
        return new MyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        logger.info("addInterceptors");
        registry.addInterceptor(getMyInterceptor()).addPathPatterns("/**");
    }

}
