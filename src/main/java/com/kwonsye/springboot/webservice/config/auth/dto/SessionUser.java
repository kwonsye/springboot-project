package com.kwonsye.springboot.webservice.config.auth.dto;

import com.kwonsye.springboot.webservice.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable { //인증된 사용자 정보 직렬화
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name=user.getName();
        this.email=user.getEmail();
        this.picture=user.getPicture();
    }
}
