package com.demo.domain.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.demo.domain.review.QReview.review;
import static com.demo.domain.product.QProduct.product;

@Repository
public class ReviewRepositoryImpl extends QuerydslRepositorySupport implements ReviewRepositoryCustom {

    public ReviewRepositoryImpl() {
        super(Review.class);
    }

    @Override
    public Page<Review> searchAll(ReviewSearchCondition condition, Pageable pageable) {
        long totalMatched = from(review)
                .join(review.product, product).fetchJoin()
                .where(condition.getPredicate())
                .fetchCount();
        List<Review> reviews = from(review)
                .join(review.product, product).fetchJoin()
                .where(condition.getPredicate())
                .orderBy(review.createdDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(reviews, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), totalMatched);
    }
}
