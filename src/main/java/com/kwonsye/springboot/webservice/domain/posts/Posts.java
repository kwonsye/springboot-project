package com.kwonsye.springboot.webservice.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본생성자 자동추가
@Entity //JPA, DB 테이블과 매칭될 클래스=Entity class , 절대 Setter를 만들지 않는다.
public class Posts { //DB와 맞닿는 핵심클래스
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성규칙 GenerationType.IDENTITY만 auto-increment됨
    private Long id;

    @Column(length = 500, nullable = false) //칼럼, 어노테이션 안붙여도 모든 필드는 칼럼이 됨
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author; //VARCHAR 는 255가 기본값

    @Builder //빌더패턴 클래스 생성, 생성자에 포함된 필드만 빌더에 포함
    private Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
