package com.canteen.backend.services;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canteen.backend.dao.AuthenticationDao;
import com.canteen.backend.entities.User;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private AuthenticationDao dao;
	
	Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
	
	@Override
	public String userSignUp(User user) {
		
		logger.trace("Sign Up method accessed at service layer");
		return dao.userSignUp(user);
	}

}
