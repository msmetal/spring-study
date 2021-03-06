package com.demo.api.review.representation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewRegisterRequest {
    private Long productId;
    private Integer score;
    private String content;
}