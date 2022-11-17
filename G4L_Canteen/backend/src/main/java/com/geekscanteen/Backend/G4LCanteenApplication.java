package com.geekscanteen.Backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;

import com.geekscanteen.Backend.entities.User;
import com.geekscanteen.Backend.entities.Branch;
import com.geekscanteen.Backend.repository.UserRepository;
import com.geekscanteen.Backend.repository.BranchRepository;

@SpringBootApplication
public class G4LCanteenApplication implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	BranchRepository branchRepository;

	public static void main(String[] args) {
		SpringApplication.run(G4LCanteenApplication.class, args);
		System.out.println("Gooooooooooooooood");
	}
	
	 @Override
	    public void run(String... args) throws Exception
	    {
	        // Inserting admin data in the mysql table.
		 	User account=new User();
			account.setEmailId("thabiso@gmail.com");
			account.setPassword("Thabiso12@");
			account.setMobileNumber("0785619239");
			account.setSecurity_question("What is your hobby?");
			account.setRole("Admin");
			account.setSecurity_answer("Programming");
			account.setCustomerName("Thabiso Qobete");
			userRepository.save(account);
			
			// Inserting the branch data in the mysql table.
			Branch branch=new Branch();
			branch.setBranchId(1);
			branch.setBranchCity("Sandton City");
			branch.setBranchRegion("Johannesburg");
			branch.setContactNumber("0785619239");
			branch.setAdmin(account);
			branchRepository.save(branch);
			
			// Inserting admin data in the mysql table.
			account.setEmailId("moses@gmail.com");
			account.setPassword("Moses12@");
			account.setMobileNumber("0785619234");
			account.setSecurity_question("What is your hobby?");
			account.setRole("Admin");
			account.setSecurity_answer("Coding");
			account.setCustomerName("Moses Shilenge");
			userRepository.save(account);
			
			// Inserting the branch data in the mysql table.
			branch.setBranchId(2);
			branch.setBranchCity("Century City");
			branch.setBranchRegion("Cape Town");
			branch.setContactNumber("0785619234");
			branch.setAdmin(account);
			branchRepository.save(branch);
	    }
	
}
