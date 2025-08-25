package com.my.quiz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final LoginRequiredInterceptor loginRequiredInterceptor;

    public WebMvcConfig(LoginRequiredInterceptor loginRequiredInterceptor) {
        this.loginRequiredInterceptor = loginRequiredInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginRequiredInterceptor)
                .addPathPatterns("/quiz/**", "/member/**", "/admin/**", "/user/my**")
                .excludePathPatterns(
                        "/", "/user/login", "/user/signup",
                        "/quiz/play", "/quiz/check",
                        "/css/**", "/js/**", "/image/**", "/images/**"
                );
    }
}
