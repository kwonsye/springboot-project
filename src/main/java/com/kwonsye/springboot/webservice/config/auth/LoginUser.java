package com.kwonsye.springboot.webservice.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //annotation 이 적용될 위치, PARAMETER : 메소드의 파라미터로 선언된 객체 앞에만 붙일 수 있음
@Retention(RetentionPolicy.RUNTIME) //자바 컴파일러가 어노테이션을 다루는 방법: 특정 시점까지 영향을 미치는지를 결정, RetentionPolicy.RUNTIME의 경우 컴파일 이후에도 JVM에 의해 계속 참조가 가능
public @interface LoginUser {
    //@LoginUser 를 붙이면 세션에서 user정보를 주입할 것임
}
