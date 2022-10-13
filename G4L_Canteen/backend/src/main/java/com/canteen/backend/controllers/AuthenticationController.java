package com.canteen.backend.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.canteen.backend.entities.User;
import com.canteen.backend.services.AuthenticationService;

@RestController
//@CrossOrigin
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	Logger logger = LoggerFactory.getLogger(AuthenticationController.class);
	
	@PostMapping("/api/signup")
	public String userSignUp(@RequestBody User user){
		logger.trace("Sign Up method accessed at controller");
			return authenticationService.userSignUp(user);
	}

}

//class SignUp{
//	public User user;
//}
