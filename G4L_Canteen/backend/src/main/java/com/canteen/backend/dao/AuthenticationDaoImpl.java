package com.canteen.backend.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.canteen.backend.entities.User;
import com.canteen.backend.repositories.UserRepository;
import com.canteen.backend.exceptions.UserExistsException;


@Repository
public class AuthenticationDaoImpl implements AuthenticationDao {
	
	@Autowired
	private UserRepository userRepository;
	
	Logger logger = LoggerFactory.getLogger(AuthenticationDaoImpl.class);
	
	@Override
	public String userSignUp(User user)throws UserExistsException {
		logger.trace("Sign Up method accessed");
		checkDatabaseBeforeSignUp(user);
	
		user.setRole("Customer");
	
		userRepository.save(user);
		return "SignUp Successful";

	}

	@Override
	public void checkDatabaseBeforeSignUp(User user) throws UserExistsException {
		
		logger.trace("Database Check before Sign Up accessed");
		
		List<String> emails = new ArrayList<>();
		List<String> phone_numbers = new ArrayList<>();
		
		emails = userRepository.getEmailIdList();
		phone_numbers = userRepository.getMobileNumberList();
		
		if(phone_numbers.contains(user.getMobile_number())||emails.contains(user.getEmail_Id())) {
			logger.error("UserExistsException thrown by the method");
			throw new UserExistsException( "You already have an account!Please kindly login!!");
		}
	}

}
