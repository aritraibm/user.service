package com.pru.test.user.service.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pru.test.user.service.VO.ResponseTemplateNamedNativeVO;
import com.pru.test.user.service.VO.ResponseTemplateVO;
import com.pru.test.user.service.entity.User;
import com.pru.test.user.service.repo.UserRepo;
import com.pru.test.user.service.service.UserService;

@RestController
@RequestMapping(value = "/pru-user")
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserService userService;
	
	final Logger logger= LoggerFactory.getLogger(UserController.class);
	
	@PostMapping(value = "/save-user")
	public User saveUser(@RequestBody User formData) {
		
		return userRepo.save(formData);
	}

	@GetMapping(value = "/get-user/{userId}")
	public ResponseTemplateVO getUserDetails(@PathVariable Long userId) {
		logger.info("this is user controller, "+userId);
		return userService.getUserWithDepartment(userId);
	}
	
	@GetMapping(value = "/get-user-by-named-native/{userId}")
	public User getUserDetailsByNamedNative(@PathVariable Long userId) {
		return userService.getUserByNamedNative(userId);
	}
	
	@GetMapping(value = "/get-user-by-named/{userId}")
	public User getUserDetailsByNamed(@PathVariable Long userId) {
		return userService.getUserByNamed(userId);
	}
}
