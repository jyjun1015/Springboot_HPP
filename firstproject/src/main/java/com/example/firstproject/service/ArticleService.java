package com.example.firstproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;

@Service // 서비스 선언 -> 서비스 객체를 스프링부트에 생성
public class ArticleService {
	private ArticleRepository articleRepository;
	
	public List<Article> index(){
		return articleRepository.findAll();
	}
	
	public Article show(Long id){
		return articleRepository.findById(id).orElse(null);
	}
	
	public Article created(ArticleForm dto){
		Article article = dto.toEntity();
		return articleRepository.save(article);
	}

}
