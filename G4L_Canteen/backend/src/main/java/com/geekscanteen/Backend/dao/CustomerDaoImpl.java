package com.geekscanteen.Backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.geekscanteen.Backend.entities.Address;
import com.geekscanteen.Backend.entities.Branch;
import com.geekscanteen.Backend.entities.CarryBox;
import com.geekscanteen.Backend.entities.Category;
import com.geekscanteen.Backend.entities.Item;
import com.geekscanteen.Backend.entities.Order;
import com.geekscanteen.Backend.entities.User;

import com.geekscanteen.Backend.repository.AddressRepository;
import com.geekscanteen.Backend.repository.BranchRepository;
import com.geekscanteen.Backend.repository.CarryBoxRepository;
import com.geekscanteen.Backend.repository.CategoryRepository;
import com.geekscanteen.Backend.repository.ItemRepository;
import com.geekscanteen.Backend.repository.OrderRepository;
import com.geekscanteen.Backend.repository.UserRepository;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private BranchRepository branchRepository;

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CarryBoxRepository carryBoxRepository;
	
	
	@Override
	public int generateAddressId() {
		int tempId = 1000;
		long count = addressRepository.getCountOfAddress();
		if (count > 0) {
			int temp = addressRepository.getMaxOfAddressId();
			tempId = temp+1;
		}
		return tempId;
	}

	@Override
	public int generatePrimaryIdForOrder() {
		int tempId = 100;
		long count = orderRepository.getCountOfOrder();
		if (count > 0) {
			int temp = orderRepository.getMaxOfPrimaryOrderId();
			tempId = temp+1;
		}
		return tempId;
	}
	
	@Override
	public int generateOrderId() {
		int tempId = 8000;
		long count = orderRepository.getCountOfOrder();
		if (count > 0) {
			int temp = orderRepository.getMaxOfOrderId();
			tempId = temp+1;
		}
		return tempId;
	}		
	
	@Override
    public Branch getABranchDetails(int branchId){
		return branchRepository.getReferenceById(branchId);
	}

	@Override
	public Category getACategoryDetails(int categoryId) {
		return categoryRepository.getReferenceById(categoryId);
	}
	
	@Override
	public CarryBox getACarryBoxDetails(int carryBoxId) {
		return carryBoxRepository.getReferenceById(carryBoxId);
	}

	@Override
	public User getAnUserDetails(String emailId) {
		return userRepository.getReferenceById(emailId);
	}

	@Override
	public Address getAnAddressDetails(int addressId) {
		return addressRepository.getReferenceById(addressId);
	}
	
	@Override
	public boolean addANewAddress(Address address) {
		try {
		     addressRepository.save(address);
		     return true;
		}
		catch(Exception ex) {
			return false;
		}
	}

	@Override
	public boolean deleteAnAddress(int addressId) {
		try {
		addressRepository.deleteById(addressId);
		return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	@Override
	public void placeAnOrder(Order order) {
		orderRepository.save(order);
	}
	
	@Override
	public List<Order> getAnOrderDetails(int orderId) {
		return orderRepository.getOrders(orderId);
	}
	
	@Override
	public Item getAnItemDetails(int itemId) {
		return itemRepository.getReferenceById(itemId);
	}
	
	@Override
	public void updateCarryBox(CarryBox carryBox) {
		carryBoxRepository.save(carryBox);
	}

	@Override
	public boolean updateAnAddress(Address address) {
		addressRepository.save(address);
		return false;
	}

	@Override
	public List<Branch> getAllBranches() {
		return branchRepository.findAll();
	}
}