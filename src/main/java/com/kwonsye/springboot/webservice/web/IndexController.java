package com.kwonsye.springboot.webservice.web;

import com.kwonsye.springboot.webservice.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController { //mustache url 매핑

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc()); //데이터를 posts로 index.mustache에 전달
        return "index"; //index.mustache 페이지 매핑
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save"; //posts-save.mustache 페이지 매핑
    }
}
