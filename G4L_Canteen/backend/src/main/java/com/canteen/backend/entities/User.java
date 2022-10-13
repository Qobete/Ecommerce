package com.canteen.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "CANTEEN_USER")
public class User {
	
	@Id
	@Length(max = 30)
	@Column(name = "EMAILId")
	private String email_Id;
	
	@NotEmpty(message = "Customer name should not be empty")
	@Length(max = 30)
	@Column(name = "CUSTOMERNAME")
	private String customer_name;
	
	@NotEmpty(message ="Password cannot be empty")
	@Length(min = 8)
	@Column(name = "PASSWORD")
	private String password;
	
	@NotEmpty(message = "security question cannot be empty")
	@Length(max = 80)
	@Column(name = "SECURITYQUESTION")
	private String security_question;
	
	@NotEmpty(message="security question cannot be empty")
	@Length(max = 30)
	@Column(name = "SECURITYANSWER")
	private String security_answer;
	
	@NotEmpty(message="mobile number should not be empty")
	@Length(max = 10, min = 10)
	@Column(name = "MOBILENUMBER")
	private String mobile_number;
	
	//@NotEmpty(message="role should not be empty")
    @Pattern(regexp = "Admin|Customer", message="role should not be empty")
	private String role;
    
    public User() {
    	
    }
	
	public User(String email_Id,
			@NotEmpty(message = "Customer name should not be empty") @Length(max = 30) String customer_name,
			@NotEmpty(message ="Password cannot be empty") @Length(min = 8) String password, 
			@NotEmpty(message = "security question cannot be empty") @Length(max = 80) String security_question,
			@NotEmpty(message="security question cannot be empty") @Length(max = 30) String security_answer,
			@NotEmpty(message="mobile number should not be empty") @Length(max = 10, min = 10) String mobile_number,
		    @Pattern(regexp = "Admin|Customer", message="role should not be empty") String role)
	{
		super();
		this.email_Id = email_Id;
		this.customer_name = customer_name;
		this.password = password;
		this.security_question = security_question;
		this.security_answer = security_answer;
		this.mobile_number = mobile_number;
		this.role = role;
	}
	
	public String getEmail_Id() {
		return email_Id;
	}
	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}
	
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSecurity_question() {
		return security_question;
	}
	public void setSecurity_question(String security_question) {
		this.security_question = security_question;
	}
	
	public String getSecurity_answer() {
		return security_answer;
	}
	public void setSecurity_answer(String security_answer) {
		this.security_answer = security_answer;
	}
	
	public String getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	public String getRole() {
		return role;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
}
