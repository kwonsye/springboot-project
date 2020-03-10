package com.kwonsye.springboot.webservice.service.posts;

import com.kwonsye.springboot.webservice.domain.posts.Posts;
import com.kwonsye.springboot.webservice.domain.posts.PostsRepository;
import com.kwonsye.springboot.webservice.web.dto.PostsListResponseDto;
import com.kwonsye.springboot.webservice.web.dto.PostsResponseDto;
import com.kwonsye.springboot.webservice.web.dto.PostsSaveRequestDto;
import com.kwonsye.springboot.webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //Autowired가 없어도 주입되는 이유
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts post = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        //update 쿼리를 날리는 부분이 없음, JPA의 영속성 컨텍스트(엔티티를 영구 저장하는 환경) 때문임
        post.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    //readOnly=true : 트랜잭션 범위는 유지 + 조회기능만 남겨두어 조회속도 개선됨
    // -> 등록,수정,삭제 기능이 없는 서비스 메소드에서 사용하는 것을 추천
    @Transactional(readOnly=true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts post = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        postsRepository.delete(post);
    }
}
