package com.gsitm.demo.web.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.gsitm.demo.web.domain.posts.PostsRepository;
import com.gsitm.demo.web.domain.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {

	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		
		return postsRepository.save(dto.toEntity()).getId();
	}
}
