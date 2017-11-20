package com.rainier.gc.system.gc.controllers;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rainier.gc.system.gc.dto.LoginRequest;
import com.rainier.gc.system.gc.dto.LoginResponse;
import com.rainier.gc.system.gc.dto.UserRequest;
import com.rainier.gc.system.gc.dto.UserResponse;
import com.rainier.gc.system.gc.exception.ServiceException;
import com.rainier.gc.system.gc.model.User;
import com.rainier.gc.system.gc.services.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	//@Autowired
	//@Qualifier("passwordEncoder")
	//private PasswordEncoder passwordEncoder;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@PostMapping(value="user")
	public UserResponse registerUser(@RequestBody UserRequest userRequest) throws ServiceException{
		User user = new User();
		user.setDateOfBirth(userRequest.getDateOfBirth());
		user.setFirstName(userRequest.getFirstName());
		user.setLastName(userRequest.getLastName());
		user.setMobileNumber(userRequest.getMobileNumber());
		//user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
		user.setPassword(userRequest.getPassword());
		user.setEmailAddress(userRequest.getEmailAddress());
		user.setLoginTime(new Date());
		user.setLastAccess(new Date());
		user.setStatus(userRequest.getStatus());
		userService.saveOrUpdate(user);
		UserResponse userResponse = new UserResponse(user.getId(), user.getFirstName(), user.getLastName(),
				user.getDateOfBirth(), user.getMobileNumber(), user.getStatus(), user.getEmailAddress(), "");
		return userResponse;
	}
	
	@RequestMapping(value="/admin/login", method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody LoginResponse basicLogon(@RequestBody LoginRequest adminLoginRequest) throws Exception {
		LOGGER.debug("Entered Login");
		LOGGER.debug("username"+adminLoginRequest.getEmailAddress()+" password "+adminLoginRequest.getPassword());
		String email = adminLoginRequest.getEmailAddress();
		String password = adminLoginRequest.getPassword();
		
		LoginResponse adminLoginResponse = this.logon(email, password);
		LOGGER.debug("Ended Login");
		return adminLoginResponse;
	}

	private LoginResponse logon(String email, String password) throws Exception {
	       
		LoginResponse adminLoginResponse = new LoginResponse();
		
		//User dbUser= userService.getByUserName(userName);
		User dbUser= userService.getByEmail(email);
		if(dbUser==null) {
			LOGGER.debug("Admin not exist for this email "+email);
			adminLoginResponse.setErrorMessage("Admin not exist for this email "+email);
			return adminLoginResponse;
		}
	
		//if (!passwordEncoder.matches(password, dbUser.getPassword())){
		if(password.equals(dbUser.getPassword())) {
			LOGGER.debug("Failed to Login, Invalid credentials");
			adminLoginResponse.setErrorMessage("Failed to Login, Invalid credentials");
			adminLoginResponse.setStatus("false");
			return adminLoginResponse;
		}
		LOGGER.debug("Login successful");
		adminLoginResponse.setSuccessMessage("You are Successfully logged in as "+dbUser.getFirstName());
		adminLoginResponse.setStatus("true");
		adminLoginResponse.setId(dbUser.getId());
		adminLoginResponse.setAdminName(dbUser.getFirstName());
		
		dbUser.setLastAccess(dbUser.getLoginTime());
		dbUser.setLoginTime(new Date());
		LOGGER.debug("Last access :"+dbUser.getLastAccess());
		userService.saveOrUpdate(dbUser);
		return adminLoginResponse;
	}

	
}
