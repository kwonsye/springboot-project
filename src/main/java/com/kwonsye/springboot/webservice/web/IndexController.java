package com.kwonsye.springboot.webservice.web;

import com.kwonsye.springboot.webservice.config.auth.dto.SessionUser;
import com.kwonsye.springboot.webservice.service.posts.PostsService;
import com.kwonsye.springboot.webservice.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController { //mustache url 매핑

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc()); //데이터를 posts로 index.mustache에 전달
        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //이미 로그인해서 세션에 존재하는 user가져옴

        if(user!=null){
            model.addAttribute("userName",user.getName()); //로그인했다면 userName 넘김
        }

        return "index"; //index.mustache 페이지 매핑
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save"; //posts-save.mustache 페이지 매핑
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update"; //posts-update.mustache 페이지 매핑
    }
}
