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
        // ✅ 퀴즈 관련은 로그인 보호
        registry.addInterceptor(loginRequiredInterceptor)
                .addPathPatterns("/quiz/**") // 하위 전부 보호
                .excludePathPatterns(
                        "/quiz",        // 목록/홈
                        "/quiz/play",   // 게임 플레이는 공개
                        "/quiz/check",  // 정답 체크는 공개(원하면 여기도 보호 가능)
                        "/user/**",     // 로그인/회원가입 등은 제외
                        "/css/**", "/js/**", "/images/**" // 정적 리소스 제외
                );
    }
}
