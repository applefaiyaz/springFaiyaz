package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bindings.ActivateAccount;
import com.example.demo.bindings.Login;
import com.example.demo.bindings.User;
import com.example.demo.service.MasterService;

@RestController
public class Rest {

	@Autowired
	MasterService service;

	@PostMapping("/user")
	public ResponseEntity<String> getUSer(@RequestBody User user) {
		boolean userRegistration = service.userRegistration(user);
		if (userRegistration) {
			return new ResponseEntity<>("Registration Success", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Registration Failed", HttpStatus.REQUEST_TIMEOUT);
		}
	}

	@PostMapping("/activateaccount")
	public ResponseEntity<String> activateUserAccount(@RequestBody ActivateAccount activateAccount) {

		boolean account = service.activateAccount(activateAccount);

		if (account) {
			return new ResponseEntity<>("Account Activated", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Account Can't Create", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers() {
		List<User> allUser = service.getAllUser();
		return new ResponseEntity<>(allUser, HttpStatus.OK);

	}

	@GetMapping("/user/{Id}")
	public ResponseEntity<User> getByUserId(@PathVariable Integer Id) {
		User userId = service.getUserId(Id);

		return new ResponseEntity<>(userId, HttpStatus.OK);

	}

	@DeleteMapping("/id/{userId}")
	public ResponseEntity<String> deleteByUserId(@PathVariable Integer userId) {
		boolean deleteUserById = service.deleteUserById(userId);
		if (deleteUserById) {
			return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Failed To Delete User", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/users/{usersId}/{userName}")
	public ResponseEntity<String> changeStatus(@PathVariable Integer usersId, @PathVariable String userName) {
		boolean activeAccount = service.activeAccount(usersId, userName);

		if (activeAccount) {
			return new ResponseEntity<>("Successfully Updated", HttpStatus.OK);
		} else {

			return new ResponseEntity<>("Can't Update", HttpStatus.REQUEST_TIMEOUT);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<String> activateLogin(@RequestBody Login login) {
		String activateLogin = service.activateLogin(login);

		return new ResponseEntity<>(activateLogin, HttpStatus.CREATED);

	}

	@GetMapping("/user/{emailId}")
	public ResponseEntity<String> activateLogin(@PathVariable String emailId) {
		String forgetPassword = service.forgetPassword(emailId);

		return new ResponseEntity<>(forgetPassword, HttpStatus.OK);

	}

}