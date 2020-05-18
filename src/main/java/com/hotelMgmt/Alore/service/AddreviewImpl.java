package com.hotelMgmt.Alore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelMgmt.Alore.entity.AddReviewEntity;
import com.hotelMgmt.Alore.repository.AddReviewRepo;

@Service
public class AddreviewImpl implements Addreview {

	@Autowired
	AddReviewRepo addReviewRepo;

	@Override
	public void addReview(AddReviewEntity addReviewEntity) {

		addReviewRepo.save(addReviewEntity);
	}

	@Override
	public void deleteReview(long id) {
		if (id < 0) {
			throw new IllegalArgumentException();
		}
		addReviewRepo.deleteById(id);

	}

	public AddReviewEntity ratingOfHotel(long id) {
		if (id < 0) {
			throw new IllegalArgumentException();
		}
		return addReviewRepo.findById(id).orElse(null);

	}
}
