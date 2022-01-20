package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

// Page and Sorting 기반 처리 
public interface CommentRepository extends JpaRepository<Comment,Long> {
    
	// 특정 게시글의 모든 댓글 조회
	@Query(value = 
			"SELECT * "
			+ "FROM comment "
			+ "WHERE article_id = :articleId",
			nativeQuery=true)
	
	List<Comment> findByArticleId(Long articleID);
	
	// 특정 닉네임의 모든 댓글 조회 
	List<Comment>findByNickname(String nuckname);
}
