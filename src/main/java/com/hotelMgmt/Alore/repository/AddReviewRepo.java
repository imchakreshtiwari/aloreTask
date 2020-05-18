package com.hotelMgmt.Alore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelMgmt.Alore.entity.AddReviewEntity;

@Repository
public interface AddReviewRepo extends JpaRepository<AddReviewEntity, Long> {

}
