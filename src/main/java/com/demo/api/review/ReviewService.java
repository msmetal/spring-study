package com.demo.api.review;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class ReviewService {

	private ReviewRepository reviewRepository;
	
	@Transactional
	public Long create(ReviewRegisterRequest request) {
		ReviewRegister register = ReviewRegister.of(request);
		return reviewRepository.save(Review.of(register)).getId();
	}

	@Transactional(readOnly = true)
	public Page<ReviewDetail> list(Pageable pageable) {
		return reviewRepository.findAll(pageable).map(ReviewDetail::new);
	}
}
