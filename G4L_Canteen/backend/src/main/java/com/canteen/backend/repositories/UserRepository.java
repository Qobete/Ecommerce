package com.canteen.backend.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.canteen.backend.entities.User;


public interface UserRepository extends JpaRepository<User, String> {
	
	@Query("SELECT user.email_Id from User user")
	public List<String> getEmailIdList();
	
	@Query("SELECT user.mobile_number from User user")
	public List<String> getMobileNumberList();

}
