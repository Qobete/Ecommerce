package com.canteen.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table
public class Address {

	@Id
	@Column(name="ADDRESSID")
	private int addressId;
	
	
	@Length(max=25)
	@Column(name="NAME")
	private String name;
	
	@NotEmpty(message="Address should not be empty")
	@Length(max=30)
	@Column(name="LINE1")
	private String line1;
	
	@Length(max=30)
	@Column(name="LINE2")
	private String line2;
	
	@NotEmpty(message="City should not be empty")
	@Length(max=20)
	@Column(name="CITY")
	private String city;
	
	
	@Length(max=30)
	@Column(name="LANDMARK")
	private String landmark;
	
	@NotEmpty(message="Mobile Number should not be empty")
	@Length(max=10)
	@Column(name="MOBILENUMBER")
	private String mobileNumber;
	
	
	

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}