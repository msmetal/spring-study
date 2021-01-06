package com.demo.api.review;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class ReviewDetail {

	private Long reviewId;
	private int purchaseCount;
	private int score;
	private LocalDateTime createdDate;
	private String content;
	private int likeCount;
	private boolean liked;

	public ReviewDetail(Review review) {
		reviewId = review.getId();
		purchaseCount = review.getPurchaseCount();
		score = review.getScore();
		createdDate = review.getCreatedDate();
		content = review.getContent();
	}

	public String getCreatedDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return Optional.ofNullable(createdDate)
				.map(formatter::format)
				.orElse("");
	}
}
