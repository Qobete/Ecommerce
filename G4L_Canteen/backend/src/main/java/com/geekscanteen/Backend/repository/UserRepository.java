package com.geekscanteen.Backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.geekscanteen.Backend.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	@Query("SELECT user.emailId from User user")
	public List<String> getEmailIdList();
	
	@Query("SELECT user.mobileNumber from User user")
	public List<String> getMobileNumberList();
}
