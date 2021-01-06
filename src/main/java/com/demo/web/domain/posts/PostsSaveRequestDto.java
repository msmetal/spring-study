package com.demo.web.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostsSaveRequestDto {

	private String title;
	private String content;
	private String author;

	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}
}
