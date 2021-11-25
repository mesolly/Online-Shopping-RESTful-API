package com.cg.onlineshopping.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.cg.onlineshopping.entity.Orders;
import com.cg.onlineshopping.entity.User;
import com.cg.onlineshopping.exception.OrderNotFoundException;
import com.cg.onlineshopping.exception.UserNotFoundException;

public interface IOrdersService {
	public ResponseEntity<User> placeOrder(long custId)throws UserNotFoundException;
	public Set<Orders>getAllOrders(Long custId) ;
	public List<Orders>getAllOrders() throws UserNotFoundException;
	public Orders getOrder(Long orderId) throws OrderNotFoundException;
}
