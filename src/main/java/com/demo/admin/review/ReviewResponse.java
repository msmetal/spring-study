package com.demo.admin.review;

import com.demo.domain.review.Review;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class ReviewResponse {

    private Long reviewId;
    private int score;
    private String productName;
    private LocalDateTime createdDate;
    private String content;

    public ReviewResponse(Review review) {
        reviewId = review.getId();
        score = review.getScore();
        productName = review.getProduct().getName();
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
