package com.kwonsye.springboot.webservice.config.auth.dto;

import com.kwonsye.springboot.webservice.domain.user.Role;
import com.kwonsye.springboot.webservice.domain.user.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String,Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes(Map<String,Object> attributes, String nameAttributeKey, String name, String email
    , String picture){
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    //map에 담긴 attributes를 뽑아내어 OAuthAttributes 객체에 담음
    public static OAuthAttributes of(String registrationId, String userNameAttributeName, Map<String,Object> attributes){
        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String)attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    //해당 attributes 를 가진 User 반환
    public User toEntity(){
        return User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST) //로그인한 사용자의 권한은 GUEST
                .build();
    }
}
