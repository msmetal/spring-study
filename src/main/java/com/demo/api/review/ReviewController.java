package com.demo.api.review;

import com.demo.api.review.representation.ReviewDetailResponse;
import com.demo.api.review.representation.ReviewPageRequest;
import com.demo.api.review.representation.ReviewRegisterRequest;
import com.demo.domain.review.ReviewSortType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class ReviewController {

	private final ReviewRegisterService reviewRegisterService;
	private final FindReviewService findReviewService;

	@PostMapping("/review")
	public Long create(ReviewRegisterRequest request) {
		return reviewRegisterService.create(request);
	}

	@GetMapping("/{productId}/reviews")
	public Page<ReviewDetailResponse> list(@PathVariable("productId") Long productId,
										   @RequestParam(defaultValue = "0") int page,
										   @RequestParam(defaultValue = "20") int size,
										   @RequestParam(defaultValue = "CREATE") ReviewSortType sortType) {
		return findReviewService.getDetailList(productId, new ReviewPageRequest(page, size, sortType.getProperty(), sortType.getDirection()));
	}
}
