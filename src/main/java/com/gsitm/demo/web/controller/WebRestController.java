package com.gsitm.demo.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gsitm.demo.web.domain.posts.PostsSaveRequestDto;
import com.gsitm.demo.web.service.PostsService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostsService postsService;
	
	@GetMapping("/hello")
	public String hello() {
		
		return "HelloWorld";
	}
	
	@PostMapping("/posts")
	@ResponseBody
	public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
		
		return postsService.save(dto);
	}
}
