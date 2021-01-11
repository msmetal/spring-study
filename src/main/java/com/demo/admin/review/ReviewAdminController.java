package com.demo.admin.review;

import com.demo.domain.review.ReviewSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/reviews")
public class ReviewAdminController {

    private final SearchReviewService searchReviewService;

    @GetMapping
    public ResponseEntity<Page<ReviewResponse>> search(ReviewSearchCondition condition,
                                                       @PageableDefault(sort = "createdDate", size = 20, direction = Sort.Direction.DESC) Pageable pageable) {
        return ResponseEntity.ok(searchReviewService.search(condition, pageable));
    }
}
