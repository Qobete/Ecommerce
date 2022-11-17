package com.geekscanteen.Backend.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.geekscanteen.Backend.entities.Branch;
import com.geekscanteen.Backend.entities.Category;
import com.geekscanteen.Backend.entities.Item;
import com.geekscanteen.Backend.entities.Order;
import com.geekscanteen.Backend.entities.SubCategory;
import com.geekscanteen.Backend.entities.User;
import com.geekscanteen.Backend.exceptions.ChildRecordsFoundException;
import com.geekscanteen.Backend.repository.BranchRepository;
import com.geekscanteen.Backend.repository.CategoryRepository;
import com.geekscanteen.Backend.repository.ItemRepository;
import com.geekscanteen.Backend.repository.OrderRepository;
import com.geekscanteen.Backend.repository.SubCategoryRepository;
import com.geekscanteen.Backend.repository.UserRepository;

@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {

	@Autowired
	private BranchRepository branchRepository;
	

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired 
	private CategoryRepository categoryRepository;
	
	@Autowired 
	private SubCategoryRepository subCategoryRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	@Override
	public int generateItemId() {
		int tempId = 1000;
		long count = itemRepository.getCountOfItem();
		if (count > 0) {
			int temp = itemRepository.getMaxOfItemId();
			tempId = temp+1;
		}
		return tempId;
	}

	@Override
	public int generateCategoryId() {
		int tempId = 1000;
		long count = categoryRepository.getCountOfCategory();
		if (count > 0) {
			int temp = categoryRepository.getMaxOfCategoryId();
			tempId = temp + 1;
		}
		return tempId;
	}

	@Override
	public int generateSubCategoryId() {
		int tempId = 1000;
		long count = subCategoryRepository.countOfSubCategory();
		if (count > 0) {
			int temp = subCategoryRepository.getMaxOfSubCategoryId();
			tempId = temp + 1;
		}
		return tempId;
	}
	

	@Override
	public void updateOrderStatus(Order order) 
	{
		orderRepository.save(order);
	}
	
	@Override
	public User getUserDetails(String userName) {
		return userRepository.getReferenceById(userName);
	
	}
	@Override
	public SubCategory getSubCategory(int subCategory) {
		return subCategoryRepository.getReferenceById(subCategory);
	
	}
	@Override
	public Category getCategory(int category) {
		return categoryRepository.getReferenceById(category);
	}
	@Override
	public Item getItem(int itemId) {
		return itemRepository.getReferenceById(itemId);
	}
	@Override
	public Branch getBranch(int branchId) {
		return branchRepository.getReferenceById(branchId);
	}
	@Override
	public void addItem(String user_name, Item item) {
		itemRepository.save(item);
}
		
	@Override
	public List<Order> getOrders(int orderId)
	{
		List<Order> orders = orderRepository.getOrders(orderId);
		return orders;
	}

	@Override
	public void addCategory(Category category) {
		categoryRepository.save(category);
		
	}

	@Override
	public void addSubCategory(SubCategory subCategory) {
		subCategoryRepository.save(subCategory);
		
	}

	@Override
	public void editCategory(String adminId, Category category) {
		User user = userRepository.getReferenceById(adminId) ;
		category.setBranch(user.getBranch());
		categoryRepository.save(category);
		
	}

	@Override
	public void editSubCategory( SubCategory subCategory) {
		subCategoryRepository.save(subCategory);
		
	}

	@Override
	public void editItem(Item item) {
		 itemRepository.save(item);
	}
	
	@Override
	public void deleteCategory(int categoryId) {
		System.err.println("dao");
		Category category = categoryRepository.getReferenceById(categoryId);
		if(category.getSubCategories().size()==0) {
		    categoryRepository.delete(category);
			
		}
		else {
			throw new ChildRecordsFoundException("child records found");
		}
	}

	@Override
	public void deleteSubCategory(int subCategoryId ) {
		SubCategory subCategory = subCategoryRepository.getReferenceById(subCategoryId);
		if( subCategory.getItems().size()==0) {
			subCategoryRepository.delete(subCategory);
		}
		else {
			 throw new ChildRecordsFoundException("child records found");
		}
						
	}
	
	@Override
	public void deleteItem(int itemId ) {
		Item item = itemRepository.getReferenceById(itemId);

		itemRepository.delete(item);
	
	}

	@Override
	public List<SubCategory> getSubCategories() {
	
		List<SubCategory> sub_categories = subCategoryRepository.findAll();
		
		return sub_categories;
	
	}
  
	@Override
	public List<Category> getCategories(String username) {
		
		List<Category> categories = categoryRepository.findAll();
		
		return categories;
	}

	@Override
	public List<Item> getItems(String adminId) {
	    List<Item> items = itemRepository.findAll();
		return items;
	}

	@Override
	public void updateActiveStatus(Item item) {
		itemRepository.save(item);
		System.err.println(item.isActive());
	
	}
}
