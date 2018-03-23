package com.gsitm.demo.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView savePosts(@RequestBody PostsSaveRequestDto dto) {
		
		ModelAndView mv = new ModelAndView("jsonView");
		
		long cnt = postsService.save(dto);
		if (cnt > 0) {
			mv.addObject("result", "success");
		} else {
			mv.addObject("result", "fail");
		}
		
		return mv;
	}
}
