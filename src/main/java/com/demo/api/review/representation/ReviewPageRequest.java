package com.demo.api.review.representation;

import lombok.Getter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Getter
public class ReviewPageRequest {

    private final int MAX_SIZE = 100;

    private int page;
    private int size;
    private String sort;
    private Sort.Direction direction;

    public ReviewPageRequest(int page, int size, String sort, Sort.Direction direction) {
        this.page = page;
        this.size = size > MAX_SIZE ? MAX_SIZE : size;
        this.direction = direction;
        this.sort = sort;
    }

    public PageRequest of() {
        return PageRequest.of(page, size, direction, sort);
    }
}
