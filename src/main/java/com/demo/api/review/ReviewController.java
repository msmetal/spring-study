package com.demo.api.review;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.domain.Sort.Direction.DESC;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/review")
public class ReviewController {

	private ReviewService reviewService;
	
	@PostMapping("/")
	public Long create(ReviewRegisterRequest request) {
		return reviewService.create(request);
	}

	@GetMapping("/")
	public Page<ReviewDetail> list(@PageableDefault(size = 20, sort = "id", direction = DESC) Pageable pageable) {
		return reviewService.list(pageable);
	}
}
