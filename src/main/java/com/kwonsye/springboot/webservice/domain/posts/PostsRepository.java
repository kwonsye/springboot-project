package com.kwonsye.springboot.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//DB Layer 접근자
//JpaRepository<Entitiy 클래스, PK타입> 상속->CRUD 자동생성
//Entity 클래스와 Entity Repository는 함께 위치해야함
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc(); //JPA 에서 제공하지 않는 메소드는 쿼리로 작성가능
}
