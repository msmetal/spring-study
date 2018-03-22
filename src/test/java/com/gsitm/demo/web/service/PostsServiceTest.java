package com.gsitm.demo.web.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gsitm.demo.web.domain.posts.Posts;
import com.gsitm.demo.web.domain.posts.PostsRepository;
import com.gsitm.demo.web.domain.posts.PostsSaveRequestDto;

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
	
	@Test
	public void Dto데이터가_posts테이블에_저장() {
		//give
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.title("제목")
				.content("테스트 본문")
				.author("홍길동")
				.build();
		
		//when
		postsService.save(dto);
		
		//then
		Posts posts = postsRepository.findAll().get(0);
		assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
		assertThat(posts.getContent()).isEqualTo(dto.getContent());
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
	}
}
