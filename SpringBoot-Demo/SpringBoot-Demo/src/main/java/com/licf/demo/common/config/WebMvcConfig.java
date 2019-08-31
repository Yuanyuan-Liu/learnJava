package com.licf.demo.common.config;

import com.licf.demo.common.interceptor.ViewInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 类描述: 配置自定义拦截器  消息转换器 跨域支持
 * @link https://yq.aliyun.com/articles/617307
 * @author licanfeng
 * @date 2019/4/3 14:42
 * @version 1.0
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加ViewInterceptor拦截器
        //可添加多个
        registry.addInterceptor(new ViewInterceptor()).addPathPatterns("/**");
    }

}


