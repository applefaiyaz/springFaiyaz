package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.bindings.ActivateAccount;
import com.example.demo.bindings.Login;
import com.example.demo.bindings.User;



@Service
public interface MasterService {

	public boolean userRegistration(User user);

	public boolean activateAccount(ActivateAccount activateAccount);

	public List<User> getAllUser();

	public User getUserId(Integer userid);

	public boolean deleteUserById(Integer userId);

	public boolean activeAccount(Integer userId, String userName);

	public String activateLogin(Login login);

	public String forgetPassword(String email);

}
