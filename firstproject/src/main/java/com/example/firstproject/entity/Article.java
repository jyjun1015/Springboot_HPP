package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // DB가 해당 객체를 인식 가능!
@AllArgsConstructor
@NoArgsConstructor // 디폴트 생성자 생성
@ToString
@Getter // redirect에서 가져올 때 사용
public class Article {
	
	// 생성자 
	

	// DB에서 이해할 수 있도록 
    @Id // 대표값
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1, 2, 3 ... 자동 생성
    private Long id;

    @Column
    private String title;
    
    @Column
    private String content;

}
