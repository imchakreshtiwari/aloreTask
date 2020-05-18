package com.hotelMgmt.Alore.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.hotelMgmt.Alore.entity.AddHotelEntity;
import com.hotelMgmt.Alore.repository.AddHotelRepo;

@Service
public class AddHotelImpl implements AddHotel {

	@Autowired
	AddHotelRepo addHotelRepo;

	@Override
	public void addHotel(AddHotelEntity addHotelEntity) {

		addHotelRepo.save(addHotelEntity);

	}

	@Override
	public void updateHotel(AddHotelEntity addHotelEntity) {
		addHotelRepo.save(addHotelEntity);

	}

	@Override
	public void deleteHotel(long id) {
		if (id < 0) {
			throw new IllegalArgumentException();
		}
		addHotelRepo.deleteById(id);
	}

	@Override
	public List<AddHotelEntity> getAllHotels() {
		return (List<AddHotelEntity>) addHotelRepo.findAll();
	}

	@Override
	public AddHotelEntity getHotel(Long id) {
		if (id < 0) {
			throw new IllegalArgumentException();
		}
		return addHotelRepo.findById(id).orElse(null);
	}

	// Hotel Search based On Criteria.
	public List<AddHotelEntity> hotelByCityAndDateSortByRating(String city, Date date, int noofrooms, int persons) {
		return addHotelRepo.findByCityAndDate(city, date, noofrooms, persons);
	}

	// Results Sorted By Price Asc
	public List<AddHotelEntity> hotelsByPriceAsc() {
		Iterable<AddHotelEntity> hotels = addHotelRepo.findAll(Sort.by("dailyCost").ascending());
		return (List<AddHotelEntity>) hotels;
	}

	// Results Sorted By Price Desc
	public List<AddHotelEntity> hotelsByPriceDesc() {
		Iterable<AddHotelEntity> hotels = addHotelRepo.findAll(Sort.by("dailyCost").descending());
		return (List<AddHotelEntity>) hotels;
	}

}
