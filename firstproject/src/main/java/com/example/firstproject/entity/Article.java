package com.example.firstproject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // DB가 해당 객체를 인식 가능!
@AllArgsConstructor
@NoArgsConstructor // 디폴트 생성자 생성
@ToString
@Getter
public class Article {

    @Id // 댜표값, like a 주민번호
    @GeneratedValue // 1, 2, 3 ... 자동 생성
    private Long id;

    @Column
    private String title;
    
    @Column
    private String content;



}
