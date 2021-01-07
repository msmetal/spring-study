package com.demo.domain.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
	
	Page<Review> findAll(Pageable pageable);
	Page<Review> findAllByProductId(Long productId, Pageable pageable);
}
