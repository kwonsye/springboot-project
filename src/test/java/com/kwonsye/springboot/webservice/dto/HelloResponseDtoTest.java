package com.kwonsye.springboot.webservice.dto;

import com.kwonsye.springboot.webservice.web.dto.HelloResponseDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void testLombok() {
        //given
        String name = "test";
        int amount = 1000;
        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        //then
        assertThat(dto.getName()).isEqualTo(name); //assertj 테스트 검증 라이브러리의 검증메소드
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
