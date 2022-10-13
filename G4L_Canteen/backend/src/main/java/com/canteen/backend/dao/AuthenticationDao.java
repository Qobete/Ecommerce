package com.canteen.backend.dao;

import com.canteen.backend.entities.User;
import com.canteen.backend.exceptions.UserExistsException;

public interface AuthenticationDao {
	
	public String userSignUp(User user) throws UserExistsException;
	
	public void checkDatabaseBeforeSignUp(User user) throws UserExistsException;
	

}
