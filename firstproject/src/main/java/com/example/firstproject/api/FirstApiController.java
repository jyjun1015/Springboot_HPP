package com.example.firstproject.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
// @RestController => JOSN 반환
// @Controller => VIEW TEMPLATE 페이지 반환 
public class FirstApiController {
	
	@GetMapping("/api/hello")
	public String hello() {
		return "hello world";

	}
}