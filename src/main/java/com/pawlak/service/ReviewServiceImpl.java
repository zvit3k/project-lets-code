package com.pawlak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pawlak.classes.Review;
import com.pawlak.repositories.ReviewRepository;
@Service
public class ReviewServiceImpl implements ReviewService{
	
	private ReviewRepository reviewRepository;
	
	@Autowired
	public ReviewServiceImpl(ReviewRepository reviewRepository){
		this.reviewRepository=reviewRepository;
	}
	
	
	@Override
	public void addReview(Review r) {
		reviewRepository.save(r);
		
	}

	@Override
	public void deleteReview(Review r) {
		// TODO Auto-generated method stub
		
	}

}
