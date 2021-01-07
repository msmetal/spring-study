package com.demo.domain.review;

import com.demo.api.review.representation.ReviewCondition;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.demo.domain.review.QReview.review;

@Repository
public class ReviewRepositoryImpl extends QuerydslRepositorySupport implements ReviewRepositoryCustom {

    public ReviewRepositoryImpl() {
        super(Review.class);
    }

    @Override
    public Page<Review> searchAll(ReviewCondition condition, Pageable pageable) {
        long totalMatched = from(review)
                .where(condition.getPredicate())
                .fetchCount();
        List<Review> reviews = from(review)
                .where(condition.getPredicate())
                .orderBy(review.createdDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(reviews, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), totalMatched);
    }
}
