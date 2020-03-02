package com.kwonsye.springboot.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링부트의 자동 설정, 이 위치부터 설정을 읽어감-> 프로젝트의 최상단에 위치해야함
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); //내장 WAS 실행됨
    }
}
