package com.demo.domain.review;

import com.demo.api.review.representation.ReviewCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public Page<Review> getList(long productId, Pageable pageable) {
        return reviewRepository.findAllByProductId(productId, pageable);
    }

    @Transactional(readOnly = true)
    public Page<Review> search(ReviewCondition condition, Pageable pageable) {
        return reviewRepository.searchAll(condition, pageable);
    }
}
