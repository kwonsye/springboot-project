package com.kwonsye.springboot.webservice.web;

import com.kwonsye.springboot.webservice.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is; // 자동완성으로 못찾아서 직접 import 해줬음
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //SpringRunner 라는 스프링 실행자 사용해서 테스트 진행
@WebMvcTest(controllers = HelloController.class) //Web(Spring MVC)에 집중할 수 있는 어노테이션
public class HelloControllerTest {
    @Autowired//빈 주입
    private MockMvc mvc; //웹 API를 테스트할때 사용, 스프링 mvc 테스트의 시작점

    @Test
    public void returnHello() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) //get 요청
                .andExpect(status().isOk()) //status 검증
                .andExpect(content().string(hello)); //response content 검증
    }

    @Test
    public void returnHelloDto() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount))) //값은 String만 허용됨
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name))) //JSON 응답값을 $ 기준으로 필드별로 검증
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}