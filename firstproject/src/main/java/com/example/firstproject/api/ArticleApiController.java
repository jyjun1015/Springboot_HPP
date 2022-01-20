package com.example.firstproject.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.ArticleService;
import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;


import java.util.List;
@RestController // RestAPI 용 컨트롤러, 데이터 JSON 반환
public class ArticleApiController {
	
	@Autowired
//	private ArticleRepository articleRepository;
	private ArticleService articleService;
	
	// GET
	@GetMapping("/api/articles")
	public List<Article> index(){
		return articleService.index();
	}
	
//	@GetMapping("/api/articles/{id}")
//	public Article show(Long id){
//		return articleRepository.findById(id).orElse(null);
//	}
	
	@GetMapping("/api/articles/{id}")
	public Article show(@PathVariable Long id){
		return articleService.show(id);
	
	// POST
	@PostMapping("api/articles")
	public ResponseEntity<Article> create(@RequestBody ArticleForm dto){
		Article created = articleService.created(dto);
		return (created != null) ? 
				ResponseEntity.status(HttpStatus.OK).body(created) :
				ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//		return ResponseEntity.status(HttpStatus.CREATED).body(created);
		
	}
	
	// FATCH
	
	// DELETE

}
