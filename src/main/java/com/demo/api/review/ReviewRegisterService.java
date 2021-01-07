package com.demo.api.review;

import com.demo.api.review.representation.ReviewRegisterRequest;
import com.demo.domain.review.Review;
import com.demo.domain.review.ReviewRegister;
import com.demo.domain.review.ReviewRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewRegisterService {

	private final ReviewRepository reviewRepository;
	
	@Transactional
	public Long create(ReviewRegisterRequest request) {
		ReviewRegister register = ReviewRegister.of(request);
		return reviewRepository.save(Review.of(register)).getId();
	}
}
