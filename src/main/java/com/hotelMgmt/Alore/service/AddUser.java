package com.hotelMgmt.Alore.service;

import com.hotelMgmt.Alore.entity.AddUserEntity;

public interface AddUser {

	void addUser(AddUserEntity addUserEntity);

	void updateUser(AddUserEntity addUserEntity);

	void deleteUser(Long id);

}
