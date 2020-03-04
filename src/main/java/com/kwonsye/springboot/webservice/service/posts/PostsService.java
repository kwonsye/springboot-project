package com.kwonsye.springboot.webservice.service.posts;

import com.kwonsye.springboot.webservice.domain.posts.PostsRepository;
import com.kwonsye.springboot.webservice.web.dto.PostsSaveRequestDto;
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
}
