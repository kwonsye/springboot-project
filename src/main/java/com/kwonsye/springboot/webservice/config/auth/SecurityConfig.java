package com.kwonsye.springboot.webservice.config.auth;

import com.kwonsye.springboot.webservice.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정 활성화시킴
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console 화면을 사용하기 위해 해당 옵션 disable
                .and()
                    .authorizeRequests()//URL별 권한 관리를 설정하는 옵션의 시작점
                    .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll() //전체 열람권한
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //USER 권한있는 사람만 접근가능
                    .anyRequest().authenticated() //설정값 이외 나머지 URL 도 인증된 사용자에게만 접근 허용
                .and()
                    .logout() //스프링 시큐리티 로그아웃 url /logout 기본제공
                        .logoutSuccessUrl("/") //로그아웃 성공시 rediret url
                .and()
                    .oauth2Login() //oauth2 로그인 기능에 대한 진입점
                        .userInfoEndpoint() //oauth2 로그인 이후 사용자 정보를 가져올때의 설정
                            .userService(customOAuth2UserService); //로그인 성공시 리소스 서버에서 user 정보가져와서 추가로 진행하고자하는 기능
    }
}
