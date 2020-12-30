package com.gsitm.demo.web.domain;

import com.gsitm.demo.web.domain.posts.Posts;
import com.gsitm.demo.web.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;

	@Before
	public void setUp() {
		postsRepository.save(Posts.builder()
				.title("테스트 게시글")
				.content("테스트 본문")
				.author("yjjeon@gsitm.com")
				.build());
	}
	
	@After
	public void cleanUp() {
		/**
		 * 이후 테스트 코드에 영향을 끼치지 않기 위해 테스트 메소드가 끝날때마다 
		 * respository 전체를 비우는 코드
		 */
		postsRepository.deleteAll();
	}
	
	@Test
	public void 게시글저장_불러오기() {
		//when
		List<Posts> postList = postsRepository.findAll();
		Optional<Posts> find = postList.stream().filter(p -> "테스트 게시글".equals(p.getTitle())).findFirst();

		//then
		assertThat(find.isPresent()).isTrue();
		assertThat(find.get().getContent()).isEqualTo("테스트 본문");
	}
	
	@Test
	public void BaseTimeEntity_등록() {
		//given
		LocalDateTime now = LocalDateTime.now();

		//when
		List<Posts> postList = postsRepository.findAll();
		Optional<Posts> find = postList.stream().filter(p -> "테스트 게시글".equals(p.getTitle())).findFirst();

		//then
		assertThat(find.isPresent()).isTrue();
		assertThat(find.get().getCreatedDate()).isLessThan(now);
		assertThat(find.get().getModifiedDate()).isLessThan(now);
	}
}
