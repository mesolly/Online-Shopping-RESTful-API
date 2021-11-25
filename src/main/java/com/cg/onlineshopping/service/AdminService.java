package com.cg.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entity.Category;
import com.cg.onlineshopping.entity.Product;
import com.cg.onlineshopping.entity.User;
import com.cg.onlineshopping.exception.UserNotFoundException;
import com.cg.onlineshopping.repository.CategoryRepository;
import com.cg.onlineshopping.repository.ProductRepository;
import com.cg.onlineshopping.repository.UserRepository;

@Service
public class AdminService implements IAdminService {
	
	@Autowired
	private CategoryRepository catRepo ;

	@Autowired
	private ProductRepository prodRepo ;
	
	@Autowired
	private UserRepository userRepo ;

	@Override
	public List<User> viewAllUsers() {
		return userRepo.findAll();
	}

	@Override
	public ResponseEntity<User> getUserById(Long userId) throws UserNotFoundException{ //This method will throw exception
		User user =  userRepo.findById(userId ).orElseThrow(() -> new UserNotFoundException("User not found::" + userId));
		return ResponseEntity.ok().body(user);
	}

}
