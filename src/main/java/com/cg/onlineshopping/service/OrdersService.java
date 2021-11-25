package com.cg.onlineshopping.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineshopping.entity.CartItem;
import com.cg.onlineshopping.entity.Category;
import com.cg.onlineshopping.entity.OrderDetail;
import com.cg.onlineshopping.entity.Orders;
import com.cg.onlineshopping.entity.ShoppingCart;
import com.cg.onlineshopping.entity.User;
import com.cg.onlineshopping.exception.CategoryNotFoundException;
import com.cg.onlineshopping.exception.OrderNotFoundException;
import com.cg.onlineshopping.exception.UserNotFoundException;
import com.cg.onlineshopping.repository.OrderDetailsRepository;
import com.cg.onlineshopping.repository.OrdersRepository;
import com.cg.onlineshopping.repository.ShoppingCartRepository;
import com.cg.onlineshopping.repository.UserRepository;

@Service
public class OrdersService implements IOrdersService{

	@Autowired
	private OrdersRepository orderRepo ;
	
	@Autowired
	private OrderDetailsRepository orderDetailRepo ;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired 
	private ShoppingCartRepository cartRepo ;
	
	@Override
	public ResponseEntity<User> placeOrder(long custId) throws UserNotFoundException{
		// TODO Auto-generated method stub
		
		User user = userRepo.findById(custId)
				.orElseThrow(() -> new UserNotFoundException("User not found::" + custId));
		long cartId = userRepo.findById(custId).get().getCart().getCartId();
		Orders order = new Orders() ;
		order.setCustomerName(userRepo.findById(custId).get().getName());
		order.setUser(userRepo.findById(custId).get());
		ShoppingCart shoppingCart = cartRepo.findById(cartId).orElse(null) ;
		order.setStatus("Booked");
		for(CartItem item : shoppingCart.getCartItem()) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setProductName(item.getProduct().getName());
			orderDetail.setQuantity(item.getQuantity());
			orderDetail.setUnitCost(item.getProduct().getPrice());
			order.getOrderDetail().add(orderDetail);
			
		}
		 orderRepo.save(order) ;
		 
		 return ResponseEntity.ok().body(user);
	}

	@Override
	public Set<Orders> getAllOrders(Long custId) throws UserNotFoundException{
		
		
		User user = userRepo.findById(custId).orElseThrow(() -> new UserNotFoundException("User not found::" + custId));
		return user.getOrders();
		
	}

	@Override
	public List<Orders> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Orders getOrder(Long orderId) throws OrderNotFoundException{
		return orderRepo.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order not found::" + orderId));
	}

}
