package com.kwonsye.springboot.webservice.config;

import com.kwonsye.springboot.webservice.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {//HandlerMethodArgumentResolver를 스프링에서 인식시키기 위해 등록

    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override //default 메소드이므로 원할때만 오버라이드
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginUserArgumentResolver);
    }
}
