package com.demo.web.service;

import java.util.List;
import java.util.stream.Collectors;

import com.demo.web.domain.posts.Posts;
import com.demo.web.domain.posts.PostsRepository;
import com.demo.web.domain.posts.PostsSaveRequestDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import com.demo.web.domain.posts.PostsMainResponseDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {

	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		Posts posts = postsRepository.save(dto.toEntity());
		return posts.getId();
	}
	
	@Transactional(readOnly = true)
	public List<PostsMainResponseDto> findAllDesc() {
		return postsRepository.findAllDesc()
				.map(PostsMainResponseDto::new)
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public Page<PostsMainResponseDto> list(Pageable pageable) {
		return postsRepository.findAll(pageable).map(PostsMainResponseDto::new);
	}
}
