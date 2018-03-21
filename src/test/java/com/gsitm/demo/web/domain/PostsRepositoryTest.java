package com.gsitm.demo.web.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gsitm.demo.web.domain.posts.Posts;
import com.gsitm.demo.web.domain.posts.PostsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		/**
		 * ���� �׽�Ʈ �ڵ忡 ������ ��ġ�� �ʱ� ���� �׽�Ʈ �޼ҵ尡 ���������� 
		 * respository ��ü�� ���� �ڵ�
		 */
		postsRepository.deleteAll();
	}
	
	@Test
	public void �Խñ�����_�ҷ�����() {
		//given
		postsRepository.save(Posts.builder()
				.title("�׽�Ʈ �Խñ�")
				.content("�׽�Ʈ ����")
				.author("yjjeon@gsitm.com")
				.build());
		
		//when
		List<Posts> postList = postsRepository.findAll();
		
		//then
		Posts posts = postList.get(0);
		assertThat(posts.getTitle(), is("�׽�Ʈ �Խñ�"));
		assertThat(posts.getContent(), is("�׽�Ʈ ����"));
		
	}
}
