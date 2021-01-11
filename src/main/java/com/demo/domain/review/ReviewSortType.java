package com.demo.domain.review;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
@Getter
public enum ReviewSortType {
    CREATE("createdDate", Sort.Direction.DESC),
    PURCHASE("purchaseCount", Sort.Direction.DESC),
//    LIKE(""),
    HIGH_SCORE("score", Sort.Direction.DESC),
    LOW_SCORE("score", Sort.Direction.ASC);

    private String property;
    private Sort.Direction direction;
}
