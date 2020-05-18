package com.hotelMgmt.Alore.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hotelMgmt.Alore.entity.AddHotelEntity;

@Repository
public interface AddHotelRepo extends PagingAndSortingRepository<AddHotelEntity, Long> {
	@Query(value = "select * from add_hotel_entity where city=:city AND availbility_end_date>=:availbility_end_date AND no_of_rooms>:no_of_rooms AND capacity>:capacity order By overall_rating desc", nativeQuery = true)
	public List<AddHotelEntity> findByCityAndDate(@Param("city") String city, @Param("availbility_end_date") Date date,
			@Param("no_of_rooms") int no_of_rooms, @Param("capacity") int capacity);

}
