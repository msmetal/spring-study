package com.demo.web.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.web.domain.posts.Posts;
import com.demo.web.domain.posts.PostsRepository;
import com.demo.web.domain.posts.PostsSaveRequestDto;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {

	@Autowired
	private PostsService postsService;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}

	@Transactional
	@Test
	public void Dto데이터가_posts테이블에_저장() {
		//give
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.title("제목")
				.content("테스트 본문")
				.author("홍길동")
				.build();
		
		//when
		long id = postsService.save(dto);
		
		//then
		Posts posts = postsRepository.getOne(id);
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
		assertThat(posts.getContent()).isEqualTo(dto.getContent());
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
	}
}
