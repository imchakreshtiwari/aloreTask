package com.hotelMgmt.Alore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelMgmt.Alore.entity.AddUserEntity;

@Repository
public interface AddUserRepo extends JpaRepository<AddUserEntity, Long> {

}
