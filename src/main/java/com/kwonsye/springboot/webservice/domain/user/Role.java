package com.kwonsye.springboot.webservice.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    GUEST("ROLE_GUEST", "손님"), //사용자 권한 코드에 항상 ROLE_이 앞에 붙어야함
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
