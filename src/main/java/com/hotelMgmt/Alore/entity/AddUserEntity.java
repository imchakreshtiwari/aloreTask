package com.hotelMgmt.Alore.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class AddUserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String userName;
	private String mobileNo;

	private String gender;
	private String city;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<AddReviewEntity> addReview;

}
