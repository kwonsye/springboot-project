package com.kwonsye.springboot.webservice.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //JPA Entity 클래스들이 이 클래스를 상속할 경우 필드들을 칼럼에 추가함, 장고의 abstract = True 랑 비슷
@EntityListeners(AuditingEntityListener.class) //Auditing 기능 포함
public class BaseTimeEntity {

    @CreatedDate //entity가 생성되어 저장될 때 시간이 자동저장되는 필드
    private LocalDateTime createdDate;

    @LastModifiedDate // entity 값이 변경될 때 시간이 자동 저장되는 필드
    private LocalDateTime modifiedDate;
}
