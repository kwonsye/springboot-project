package com.kwonsye.springboot.webservice.config.auth;

import com.kwonsye.springboot.webservice.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component //component 스캔으로 bean으로 만들기
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {//조건에 맞는 메소드가 있다면 지정한 값으로 메소드의 파라미터로 넘길 수 있다.

    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //컨트롤러 메소드의 어떤 파라미터를 지원하는지 판단

        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null; // 파라미터에 @LoginUser가 붙어있는지
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType()); // 파라미터 클래스 타입이 SessionUser 인지

        return isLoginUserAnnotation && isUserClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //supportsParameter()==true 일 경우 파라미터에 전달할 객체

        return httpSession.getAttribute("user");
    }
}
