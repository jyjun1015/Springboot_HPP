package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j // 로깅을 위한 어노테이션
public class ArticleController {

    @Autowired // 스트링 부트가 생성해놓은 객체 가져다가 자동 연결
    private ArticleRepository articleRepository;

    // 데이터 생성하는 곳
    @GetMapping("/articles/new")
    public String newArticleForm(){
        return "articles/new";
    }
    // 페이지간 연결고리 redirect 
    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form){
        // System.out.println(form.toString()); -> 로깅 기능으로 대체
        log.info(form.toString());

        // 1. Dto를 Entity로 변환
        Article article = form.toEntity();
        log.info(article.toString());

        // 2. Repository에게 entity를 db안에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "redirect:/article" + saved.getId();
    }

    // 데이터 조회 
    @GetMapping("/articles/{id}") 
    public String show(@PathVariable Long id, Model model){
        log.info("id = " + id);

        // 1: id로 데이터를 가져옴 -> repository로 가져오고, 보내고 
        Article articleEntity = articleRepository.findById(id).orElse(null);

        // 2: 가져온 데이터를 모델에 등록
        model.addAttribute("article", articleEntity);

        // 3: 보여줄 페이지를 설정
        return "articles/show";
    }

    // 모든 데이터 조회
    @GetMapping("/articles")
    public String index(Model model){
        // 1: 모든 Article을 가져온다!
        List<Article> ArticleEntityList = articleRepository.findAll();
        // 2: 가져온 Aricle 묶음을 뷰로 전달한다
        model.addAttribute("articleList", ArticleEntityList);
        // 3: 뷰 페이지 설정!
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        // 수정할 데이터를 가져오기!
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 모델에 데이터 등록!
        model.addAttribute("article", articleEntity);
        // 뷰 페이지 설정
        return "articles/edit";
    }
    
    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        // 삭제 대상 가져온다
        Article target = articleRepository.findById(id).orElse(null);
        // 대상 삭제 
        if (target != null) {
        	articleRepository.delete(target);
        	rttr.addFlashAttribute("msg", "삭제 완료");
        }
        // 결과 페이지로 리다이렉트 
        return "redirect:/articles";
    }
}
