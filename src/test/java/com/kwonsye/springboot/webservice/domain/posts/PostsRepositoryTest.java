package com.kwonsye.springboot.webservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest //h2 db 자동으로 실행해줌
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // 단위 테스트가 끝나고 수행됨, 테스트간 데이터 침범을 막기위해
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void loadPosts() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        //post 테이블에 insert,update 쿼리 실행
        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("kwonsye@naver.com")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll(); //모든 데이터 조회
        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void addBaseTimeEntity() {
        LocalDateTime now = LocalDateTime.of(2020,4,24,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        List<Posts> postsList = postsRepository.findAll();
        Posts post = postsList.get(0);

        System.out.println(">>>>>>>>> create Date=" + post.getCreatedDate() +
                ", modified Date=" + post.getModifiedDate()); //BaseTimeEtitiy의 필드들이 자동으로 추가됨

        assertThat(post.getModifiedDate()).isAfter(now);
        assertThat(post.getModifiedDate()).isAfter(now);
    }

}