package com.demo.domain.review;

import com.querydsl.core.BooleanBuilder;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

import static com.demo.domain.product.QProduct.product;
import static com.demo.domain.review.QReview.review;

@Setter
public class ReviewSearchCondition {

    private Long reviewId;
    private Long orderId;
    private Long productId;
    private String productName;
    private Integer score;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;

    public BooleanBuilder getPredicate() {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        reviewIdEqual(booleanBuilder);
        orderIdEqual(booleanBuilder);
        productIdEqual(booleanBuilder);
        productNameLike(booleanBuilder);
        betweenFromTo(booleanBuilder);
        return booleanBuilder;
    }

    private void reviewIdEqual(BooleanBuilder booleanBuilder) {
        if (Objects.nonNull(reviewId)) {
            booleanBuilder.and(review.id.eq(reviewId));
        }
    }

    private void orderIdEqual(BooleanBuilder booleanBuilder) {
        //todo yjjeon
//        if (Objects.nonNull(orderId)) {
//            booleanBuilder.and(.eq(orderId));
//        }
    }

    private void productIdEqual(BooleanBuilder booleanBuilder) {
        if (Objects.nonNull(productId)) {
            booleanBuilder.and(review.productId.eq(productId));
        }
    }

    private void productNameLike(BooleanBuilder booleanBuilder) {
        if (Objects.nonNull(productName)) {
            booleanBuilder.and(product.name.contains(productName));
        }
    }

    private void betweenFromTo(BooleanBuilder booleanBuilder) {
        if (Objects.nonNull(fromDate) && Objects.nonNull(toDate)) {
            LocalDateTime fromCalendar = LocalDateTime.of(fromDate, LocalTime.MIN);
            LocalDateTime toCalendar = LocalDateTime.of(fromDate, LocalTime.MAX);
            booleanBuilder.and(review.createdDate.between(fromCalendar, toCalendar));
        }
    }


}
