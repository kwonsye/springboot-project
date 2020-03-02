package com.kwonsye.springboot.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//DB Layer 접근자
//JpaRepository<Entitiy 클래스, PK타입> 상속->CRUD 자동생성
//Entity 클래스와 Entity Repository는 함께 위치해야함
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
