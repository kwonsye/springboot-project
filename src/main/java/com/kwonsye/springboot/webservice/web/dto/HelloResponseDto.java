package com.kwonsye.springboot.webservice.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //getter 추가
@RequiredArgsConstructor //final 붙은 필드를 포함한 생성자 생성
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
