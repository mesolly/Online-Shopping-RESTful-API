package com.cg.onlineshopping.service;

import java.util.List;

import com.cg.onlineshopping.entity.Product;
import com.cg.onlineshopping.entity.User;
import com.cg.onlineshopping.exception.WrongEmailException;
import com.cg.onlineshopping.exception.WrongPasswordException;

public interface IUserService {
	public User register(User user) throws WrongPasswordException, WrongEmailException ;
}
