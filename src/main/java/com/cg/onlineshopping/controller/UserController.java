package com.cg.onlineshopping.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entity.CartItem;
import com.cg.onlineshopping.entity.Orders;
import com.cg.onlineshopping.entity.Product;
import com.cg.onlineshopping.entity.ShoppingCart;
import com.cg.onlineshopping.entity.User;
import com.cg.onlineshopping.exception.ResourceNotFoundException;
import com.cg.onlineshopping.exception.UserNotFoundException;
import com.cg.onlineshopping.exception.WrongEmailException;
import com.cg.onlineshopping.exception.WrongPasswordException;
import com.cg.onlineshopping.service.IOrdersService;
import com.cg.onlineshopping.service.IProductService;
import com.cg.onlineshopping.service.IShoppingCartService;
import com.cg.onlineshopping.service.IUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@RestController
@RequestMapping("/user")
@Api(value = "Online Shopping",
description = "Operations pertaining to the User entity")
public class UserController {

	@Autowired
	private IUserService usrService ;
	
	@Autowired
	private IProductService prodService ;
	
	@Autowired
	private IShoppingCartService cartService ;
	
	@Autowired IOrdersService orderService ;
	
	
	@ApiOperation(value = "Register as a new user",response = User.class)
	@PostMapping("/register")
	public User register(@ApiParam(value="Registers the user passed as parameter",required = true)@RequestBody User usr) throws WrongPasswordException, WrongEmailException {
		return usrService.register(usr);
	}
	
	@ApiOperation(value = "View all the available products",response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved list"),
        @ApiResponse(code = 401, message = "You are not authorized to view the product list"),
        @ApiResponse(code = 403, message = "Accessing the list you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The list you were trying to reach is not found")
    })
	
	
	
	@GetMapping("/getallproduct")
	public List<Product> getAllProduct(){
		return prodService.getAllProduct();
	}
	
	@ApiOperation(value = "Add products to cart",response = ShoppingCart.class)
	@PostMapping("/addtocart/{custId}/{prodId}")
	public ShoppingCart addToCart(@ApiParam(value="ID of the customer",required = true)@PathVariable Long custId,@ApiParam(value = "ID of the product to be added", required = true)@PathVariable Long prodId) throws ResourceNotFoundException{
		return cartService.addToCart(custId, prodId);
	}
	
	@ApiOperation(value = "View cart using cart ID",response = Set.class)
	@GetMapping("/viewcart/{custId}")
	public ResponseEntity<ShoppingCart> viewCart(@PathVariable("custId") Long custId) throws UserNotFoundException{
		return cartService.viewCart(custId) ;
	}
	
	@ApiOperation(value = "Place order using customer ID",response = Orders.class)
	@PostMapping("/placeorder/{custId}")
	public ResponseEntity<User> placeOrder(@ApiParam(value = "ID of the customer for placing order", required = true)@PathVariable("custId") Long custId) throws UserNotFoundException{
		return orderService.placeOrder(custId);
	}
	
	@ApiOperation(value = "View all orders placed by user",response = Set.class)
	@GetMapping("/viewallorder/{custId}")
	public Set<Orders> getAllOrders(@PathVariable("custId") Long custId) throws UserNotFoundException{
		return orderService.getAllOrders(custId);
	}
	
}
