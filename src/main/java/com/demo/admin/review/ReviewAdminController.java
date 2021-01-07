package com.demo.admin.review;

import com.demo.api.review.representation.ReviewCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/reviews")
public class ReviewAdminController {

    private final SearchReviewService searchReviewService;

    @PostMapping("/search")
    public Page<ReviewResponse> search(@PageableDefault(sort = "createdDate", size = 20,
            direction = Sort.Direction.DESC) Pageable pageable,
                                       @RequestBody ReviewCondition condition) {
        return searchReviewService.search(condition, pageable);
    }

}
