package com.demo.domain.review;

import com.demo.api.review.representation.ReviewCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewRepositoryCustom {

    Page<Review> searchAll(ReviewCondition condition, Pageable pageable);

}
