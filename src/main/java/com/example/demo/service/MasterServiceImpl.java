package com.example.demo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.demo.bindings.ActivateAccount;
import com.example.demo.bindings.Login;
import com.example.demo.bindings.User;
import com.example.demo.master.Entity;
import com.example.demo.repossitory.MasterRepository;
import com.example.demo.utilities.EmailService;

@Service
public class MasterServiceImpl implements MasterService {

	@Autowired
	MasterRepository master;

	@Autowired
	private EmailService sendEmail;

	@Override
	public boolean userRegistration(User user) {

		Entity entities = new Entity();
		BeanUtils.copyProperties(user, entities);

		entities.setPassword(randomNumber());
		entities.setActiveSwitch("In-Active");

		Entity save = master.save(entities);

		// TODO email

		String subject = "Your Registration Is Successful";
		String fileName = "EMAIL-BODY";
		String body = readEmailBody(entities.getEmailId(), entities.getPassword(), fileName);
		sendEmail.sendEmail(user.getEmailId(), subject, body);
		return save.getUserId() != null;
	}

	private String randomNumber() {

		String uppercaseLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowercaseLetter = "abcdefghijklmnopqrstuvwxyz";
		String number = "0123456789";

		String alphaNumeric = uppercaseLetter + lowercaseLetter + number;

		Random random = new Random();
		StringBuilder builder = new StringBuilder();

		int i = 10;
		for (i = 0; i < alphaNumeric.length(); i++) {
			int nextInt = random.nextInt(alphaNumeric.length());
			char charAt = alphaNumeric.charAt(nextInt);
			builder.append(charAt);
		}

		return builder.toString();
	}

	@Override
	public boolean activateAccount(ActivateAccount activateAccount) {
		Entity entities = new Entity();
		entities.setEmailId(activateAccount.getRegistrationMail());
		entities.setPassword(activateAccount.getTemporaryPassword());
		Example<Entity> of = Example.of(entities);
		List<Entity> findAll = master.findAll(of);
		if (findAll.isEmpty()) {
			return false;
		} else {
			Entity entity = findAll.get(0);
			entity.setPassword(activateAccount.getNewpassword());
			entity.setPassword(activateAccount.getConfirmPassword());
			entity.setActiveSwitch("Account Activated.");
			master.save(entity);
			return true;
		}
	}

	@Override
	public List<User> getAllUser() {

		List<Entity> all = master.findAll();

		List<User> user = new ArrayList<>();
		all.forEach(entity -> {
			User users = new User();
			BeanUtils.copyProperties(entity, users);
			user.add(users);
		});

		return user;
	}

	@Override
	public User getUserId(Integer userid) {

		Optional<Entity> findById = master.findById(userid);
		if (findById.isPresent()) {

			User user = new User();
			Entity entity = findById.get();
			BeanUtils.copyProperties(entity, user);
			return user;
		}
		return null;
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		try {
			master.deleteById(userId);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean activeAccount(Integer userId, String userName) {

		Optional<Entity> findById = master.findById(userId);
		if (findById.isPresent()) {
			Entity entity = findById.get();
			entity.setActiveSwitch(userName);
			master.save(entity);
			return true;
		}

		return false;
	}

	@Override
	public String activateLogin(Login login) {

		Entity entity = new Entity();
		entity.setEmailId(login.getEmail());
		entity.setPassword(login.getPassword());
		Example<Entity> of = Example.of(entity);

		List<Entity> findAll = master.findAll(of);
		if (findAll.isEmpty()) {
			return "Invalid Credentials";

		} else {
			Entity entity2 = findAll.get(0);
			if (entity2.getActiveSwitch().equals("Activate")) {
				return "Account Is Activated";
			} else {
				return "Account is Not Activated";
			}
		}
	}

	@Override
	public String forgetPassword(String email) {
		// User user=new User();

		Entity entity = new Entity();
		entity.getEmailId();

		// select * from Entity
		Example<Entity> of = Example.of(entity);
		List<Entity> findAll = master.findAll(of);

		// Entity entity = master.findbyEmailid(email);

		if (findAll == null) {
			return "Invalid Credentials";
		} else {

			String subject = "Forget Password";

			String file = "RECOVER-PASSWORD";

			String body = readEmailBody(entity.getFullName(), entity.getPassword(), file);

			sendEmail.sendEmail(email, subject, body);

		}

		return null;
	}

	private String readEmailBody(String fullName, String password, String fileName) {

		String string = null;
		String url = "";
		try {
			StringBuilder builder = new StringBuilder();
			FileReader reader = new FileReader(fileName);
			BufferedReader bufferReader = new BufferedReader(reader);
			String readLine = bufferReader.readLine();
			while (readLine != null) {

				readLine = bufferReader.readLine();
				builder.append(readLine);
			}

			bufferReader.close();

			string = builder.toString();
			string.replace("{FULL_NAME}", fullName);
			string.replace("{TEMP_PASSWORD}", password);
			string.replace("{URL}", url);
			string.replace("{PASSWORD}", password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return string;
	}

}
