package com.kwonsye.springboot.webservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing //@WebMvcTest 의 에러를 해결하기 위해 @SpringBootApplication과 분리
public class JpaConfig {
}
