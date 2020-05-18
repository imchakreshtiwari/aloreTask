package com.hotelMgmt.Alore.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotelMgmt.Alore.entity.AddHotelEntity;
import com.hotelMgmt.Alore.service.AddHotelImpl;

@RestController
public class AddHotelController {
	@Autowired
	AddHotelImpl addHotelImpl;

	@PostMapping(value = "/addhotel")
	public ResponseEntity<?> addHotel(@RequestBody AddHotelEntity addHotelEntity) {
		addHotelImpl.addHotel(addHotelEntity);
		return new ResponseEntity<>("Created", HttpStatus.OK);

	}

	@PutMapping(value = "/updatehotel")
	public ResponseEntity<?> updateHotel(@RequestBody AddHotelEntity addHotelEntity) {
		addHotelImpl.updateHotel(addHotelEntity);
		return new ResponseEntity<>("Updated", HttpStatus.OK);

	}

	@GetMapping(value = "/allHotel")
	public ResponseEntity<?> getAllHotel() {
		List<AddHotelEntity> hotels = addHotelImpl.getAllHotels();
		return new ResponseEntity<>(hotels, HttpStatus.OK);

	}

	@GetMapping(value = "/hotel")
	public ResponseEntity<?> getHotelById(@PathVariable("id") Long id) {
		AddHotelEntity hotel = addHotelImpl.getHotel(id);
		return new ResponseEntity<>(hotel, HttpStatus.OK);

	}

	@DeleteMapping(value = "/deletehotel/{id}")
	public ResponseEntity<?> deleteHotel(@PathVariable("id") Long id) {
		addHotelImpl.deleteHotel(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

	@GetMapping(value = "/allHotelBySearchByRating/{city}/{noofrooms}/{persons}")
	public ResponseEntity<?> getAllHotel(@PathVariable("city") String city, @RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") Date date,
			@PathVariable("noofrooms") int noofrooms, @PathVariable("persons") int persons) {
		List<AddHotelEntity> hotels = addHotelImpl.hotelByCityAndDateSortByRating(city, date, noofrooms, persons);
		return new ResponseEntity<>(hotels, HttpStatus.OK);

	}
	
	@GetMapping(value = "/hotelByPriceAsc")
	public ResponseEntity<?> getHotelByPriceAsc() {
		List<AddHotelEntity> hotel = addHotelImpl.hotelsByPriceAsc();
		return new ResponseEntity<>(hotel, HttpStatus.OK);

	}
	
	@GetMapping(value = "/hotelByPriceDesc")
	public ResponseEntity<?> getHotelByPriceDesc() {
		List<AddHotelEntity> hotel = addHotelImpl.hotelsByPriceDesc();
		return new ResponseEntity<>(hotel, HttpStatus.OK);

	}
	

}
