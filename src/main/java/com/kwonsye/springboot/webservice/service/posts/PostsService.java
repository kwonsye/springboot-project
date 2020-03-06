package com.kwonsye.springboot.webservice.service.posts;

import com.kwonsye.springboot.webservice.domain.posts.Posts;
import com.kwonsye.springboot.webservice.domain.posts.PostsRepository;
import com.kwonsye.springboot.webservice.web.dto.PostsResponseDto;
import com.kwonsye.springboot.webservice.web.dto.PostsSaveRequestDto;
import com.kwonsye.springboot.webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
