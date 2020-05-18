package com.hotelMgmt.Alore.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
public class AddHotelEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String city;

	private int dailyCost;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Timestamp availbilityStartDate;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Timestamp availbilityEndDate;

	private int noOfRooms;
	private int capacity;

	private int overallRating;

	private Boolean iswifi;
	private Boolean isParking;
	private Boolean isFood;

	@JsonManagedReference
	@OneToMany(mappedBy = "addHotelEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AddReviewEntity> addReview;

}
