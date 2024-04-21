package com.mirae.commerce.common.config;

import com.mirae.commerce.auth.interceptor.AuthenticationInterceptor;
import com.mirae.commerce.auth.jwt.LoginUsernameMethodArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {
    private final AuthenticationInterceptor authenticationInterceptor;
    private final LoginUsernameMethodArgumentResolver loginUsernameMethodArgumentResolver;
    public static final String BASE_URL = "http://localhost:8080";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/member/**")
                .excludePathPatterns("/auth/**")
                .excludePathPatterns("/member/registration")
                .excludePathPatterns("/member/email-confirm");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginUsernameMethodArgumentResolver);
    }
}
