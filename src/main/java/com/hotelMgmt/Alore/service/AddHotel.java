package com.hotelMgmt.Alore.service;

import java.util.List;

import com.hotelMgmt.Alore.entity.AddHotelEntity;

public interface AddHotel {

	public void addHotel(AddHotelEntity addHotelEntity);

	public void updateHotel(AddHotelEntity addHotelEntity);

	public void deleteHotel(long id);

	public List<AddHotelEntity> getAllHotels();

	public AddHotelEntity getHotel(Long id);

}
