package com.demo.domain.review;

import com.demo.api.review.representation.ReviewRegisterRequest;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ReviewRegister {

    private Long productId;
    private Integer score;
    private String content;

    public static ReviewRegister of(ReviewRegisterRequest request) {
        return ReviewRegister.builder()
                .productId(request.getProductId())
                .score(request.getScore())
                .content(request.getContent())
                .build();
    }
}
