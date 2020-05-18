package com.hotelMgmt.Alore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelMgmt.Alore.entity.AddReviewEntity;
import com.hotelMgmt.Alore.service.AddreviewImpl;

@RestController
public class AddReviewController {

	@Autowired
	AddreviewImpl addreviewImpl;

	@PostMapping(value = "/addReview")
	public ResponseEntity<?> addReview(@RequestBody AddReviewEntity addReviewEntity) {
		addreviewImpl.addReview(addReviewEntity);
		return new ResponseEntity<>("Created", HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteReview/{id}")
	public ResponseEntity<?> deleteReview(@PathVariable("id") Long id) {
		addreviewImpl.deleteReview(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}
	
	@GetMapping(value = "/review/{id}")
	public ResponseEntity<?> getReview(@PathVariable("id") Long id) {
		AddReviewEntity obj=addreviewImpl.ratingOfHotel(id);
		//AddHotelEntity hotelObj=obj.getAddHotelEntity();
		return new ResponseEntity<>(obj, HttpStatus.OK);

	}
	

}
