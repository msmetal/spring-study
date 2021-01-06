package com.demo.web.controller;

import com.demo.web.domain.posts.PostsMainResponseDto;
import com.demo.web.domain.posts.PostsSaveRequestDto;
import com.demo.web.service.PostsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import static org.springframework.data.domain.Sort.Direction.DESC;

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

	@GetMapping("/list")
	public Page<PostsMainResponseDto> list(@PageableDefault(size = 20, sort = "id", direction = DESC) Pageable pageable) {
		return postsService.list(pageable);
	}
}
