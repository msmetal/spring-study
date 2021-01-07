package com.demo.api.review;

import com.demo.api.review.representation.ReviewDetailResponse;
import com.demo.api.review.representation.ReviewPageRequest;
import com.demo.domain.review.ReviewQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindReviewService {

    private final ReviewQueryService reviewQueryService;

    public Page<ReviewDetailResponse> getDetailList(long productId, ReviewPageRequest reviewPageRequest) {
        return reviewQueryService.getList(productId, reviewPageRequest.of()).map(ReviewDetailResponse::new);
    }

}
