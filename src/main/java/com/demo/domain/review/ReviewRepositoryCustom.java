package com.demo.domain.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReviewRepositoryCustom {

    Page<Review> searchAll(ReviewSearchCondition condition, Pageable pageable);

}
