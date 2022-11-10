package com.geekscanteen.Backend.dao;

import java.util.List;

import com.geekscanteen.Backend.entities.Address;
import com.geekscanteen.Backend.entities.Branch;
import com.geekscanteen.Backend.entities.CarryBox;
import com.geekscanteen.Backend.entities.Category;
import com.geekscanteen.Backend.entities.Item;
import com.geekscanteen.Backend.entities.Order;
import com.geekscanteen.Backend.entities.User;

public interface CustomerDao {

	public int generateAddressId();
	public int generateOrderId();
	public int generatePrimaryIdForOrder();
	public Branch getABranchDetails(int branchId);
	public Category getACategoryDetails(int categoryId);
	public CarryBox getACarryBoxDetails(int carryBoxId);
	public User getAnUserDetails(String emailId);
	public Address getAnAddressDetails(int addressId);
	public boolean addANewAddress(Address address);
	public boolean updateAnAddress(Address address);
	public boolean deleteAnAddress(int addressId);
	public void placeAnOrder(Order order);
	public List<Order> getAnOrderDetails(int orderId);
	public Item getAnItemDetails(int itemId);
	public void updateCarryBox(CarryBox carryBox);
	public List<Branch> getAllBranches();
	
}
