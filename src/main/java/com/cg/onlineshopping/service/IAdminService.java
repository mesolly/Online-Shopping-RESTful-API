package com.cg.onlineshopping.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlineshopping.entity.Category;
import com.cg.onlineshopping.entity.Product;
import com.cg.onlineshopping.entity.User;
import com.cg.onlineshopping.exception.UserNotFoundException;

public interface IAdminService {
	public List<User> viewAllUsers();
	public ResponseEntity<User> getUserById(Long userId) throws UserNotFoundException;
}
