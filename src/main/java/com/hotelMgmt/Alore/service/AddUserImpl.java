package com.hotelMgmt.Alore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelMgmt.Alore.entity.AddUserEntity;
import com.hotelMgmt.Alore.repository.AddUserRepo;

@Service
public class AddUserImpl implements AddUser {

	@Autowired
	AddUserRepo addUserRepo;

	@Override
	public void addUser(AddUserEntity addUserEntity) {

		addUserRepo.save(addUserEntity);
	}
	
	

	@Override
	public void updateUser(AddUserEntity addUserEntity) {
		addUserRepo.save(addUserEntity);
	}

	@Override
	public void deleteUser(Long id) {
		if (id < 0) {
			throw new IllegalArgumentException();
		}
		addUserRepo.deleteById(id);
	}

}
