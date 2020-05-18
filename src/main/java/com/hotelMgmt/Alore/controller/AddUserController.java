package com.hotelMgmt.Alore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotelMgmt.Alore.entity.AddUserEntity;
import com.hotelMgmt.Alore.service.AddUserImpl;

@RestController
public class AddUserController {

	@Autowired
	AddUserImpl addUserImpl;

	@PostMapping(value = "/addUser")
	public ResponseEntity<?> addUser(@RequestBody AddUserEntity addUserEntity) {
		addUserImpl.addUser(addUserEntity);
		return new ResponseEntity<>("Created", HttpStatus.OK);

	}

	@PutMapping(value = "/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody AddUserEntity addUserEntity) {
		addUserImpl.updateUser(addUserEntity);
		return new ResponseEntity<>("Updated", HttpStatus.OK);

	}

	@DeleteMapping(value = "/deleteUser/{id}")
	public ResponseEntity<?> deleteHotel(@PathVariable("id") Long id) {
		addUserImpl.deleteUser(id);
		return new ResponseEntity<>("Deleted", HttpStatus.OK);

	}

}
