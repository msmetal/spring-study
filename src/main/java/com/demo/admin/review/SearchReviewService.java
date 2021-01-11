package com.demo.admin.review;

import com.demo.domain.review.ReviewSearchCondition;
import com.demo.domain.review.ReviewQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchReviewService {

    private final ReviewQueryService reviewQueryService;

    public Page<ReviewResponse> search(ReviewSearchCondition condition, Pageable pageable) {
        return reviewQueryService.search(condition, pageable).map(ReviewResponse::new);
    }

}
