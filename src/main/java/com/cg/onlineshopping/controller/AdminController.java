package com.cg.onlineshopping.controller;
  
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineshopping.entity.Category;
import com.cg.onlineshopping.entity.Orders;
import com.cg.onlineshopping.entity.Product;
import com.cg.onlineshopping.entity.User;
import com.cg.onlineshopping.exception.CategoryNotFoundException;
import com.cg.onlineshopping.exception.OrderNotFoundException;
import com.cg.onlineshopping.exception.ProductNotFoundException;
import com.cg.onlineshopping.exception.UserNotFoundException;
import com.cg.onlineshopping.service.IAdminService;
import com.cg.onlineshopping.service.ICategoryService;
import com.cg.onlineshopping.service.IOrdersService;
import com.cg.onlineshopping.service.IProductService;
  
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


  @RestController
  @RequestMapping("/admin") 
  @Api(value = "Online Shopping",
  description = "Operations pertaining to the Admin entity")
  public class AdminController {
  
	  @Autowired
	  private IAdminService adminService ;
	  
	  @Autowired
	  private ICategoryService catService ;
	  
	  @Autowired
	  private IProductService prodService ;
	  
	  @Autowired
	  private IOrdersService ordersService ;
	  
	  
	  @ApiOperation(value = "Get all the categories for products",response = List.class)
	  @GetMapping("/categories") 
	  public List<Category> getAllCategory(){
		  return catService.getAllCategory();
	  }
	  
	  
	  @ApiOperation(value = "Add a new category for products",response = Category.class)
	  @PostMapping("/addCategory")
	  public Category addCategory(@ApiParam(value = "Category object to be added", required = true)@RequestBody Category category) {
		  return catService.addCategory(category);
	  }
	  
	  
	  //Exception Done
	  @ApiOperation(value = "Get the product category by passing ID",response = Category.class)
	  @GetMapping("/getCategory/{catid}")
	  public ResponseEntity<Category> getCategory(@ApiParam(value = "ID of the category to be retrieved", required = true)@PathVariable("catid") Long catId) throws CategoryNotFoundException {
		  return catService.getCategory(catId);
	  }
	  
	  
	  @ApiOperation(value = "Update a category",response = String.class)
	  @PutMapping("/updateCategory/{catid}")
	  public ResponseEntity<Category> updateCategory(@ApiParam(value = "New category object", required = true)@RequestBody Category category,@ApiParam(value = "ID of the category to be updated", required = true)@PathVariable("catid") Long catId)throws CategoryNotFoundException {
		  return catService.updateCategory(category, catId) ;
	  }
	  
	  @ApiOperation(value = "Get all the products",response = List.class)
	  @GetMapping("/products")
	  public List<Product>getAllProduct(){
		  return prodService.getAllProduct();
	  }
	  
	  @ApiOperation(value = "Add a new product using product ID",response = Product.class)
	  @PostMapping("/addproduct/{catid}")
	  public ResponseEntity<Product> addProduct(@ApiParam(value = "New product object", required = true)@RequestBody Product product,@ApiParam(value = "ID of the category to add the product in.", required = true)@PathVariable("catid") Long catId) throws CategoryNotFoundException{
		  return prodService.addProduct(product,catId) ;
	  }
	  
	  @ApiOperation(value = "Retrieve product by passing ID",response = Product.class)
	  @GetMapping("/getproduct/{prodid}")
	  public ResponseEntity<Product> getProductById(@ApiParam(value = "ID of the product to be retrieved", required = true)@PathVariable("prodid") Long prodId) throws  ProductNotFoundException{
		  return prodService.getProductById(prodId) ;
	  }
	  
	  @ApiOperation(value = "Update the product using product ID",response = String.class)
	  @PutMapping("/updateproduct/{prodid}")
	  public ResponseEntity<Product> updateProduct(@RequestBody Product product,@ApiParam(value = "ID of the product to be updated", required = true)@PathVariable("prodid") Long prodId) throws ProductNotFoundException{
		  return prodService.updateProduct(product, prodId) ;
	  }
	  
	  @ApiOperation(value = "View all users",response = List.class)
	  @GetMapping("/users")
	  public List<User> viewAllUsers(){
		return adminService.viewAllUsers(); 
	  }
	  
	  @ApiOperation(value = "View a user by user ID",response = User.class)
	  @GetMapping("/user/{userid}")
	  public ResponseEntity<User> getUserById(@PathVariable("userid") Long userId) throws UserNotFoundException{
		  return adminService.getUserById(userId);
	  }
	  
	  @ApiOperation(value = "View all the orders placed",response = List.class)
	  @GetMapping("/viewAllOrders")
	  public List<Orders> getAllOrders() {
		  return ordersService.getAllOrders();
	  }
	  
	  @ApiOperation(value = "View an order by order ID",response = Orders.class)
	  @GetMapping("/viewOrder/{orderId}")
	  public Orders getOrder(@PathVariable("orderId") Long orderId) throws OrderNotFoundException{
		  return ordersService.getOrder(orderId);
	  }
	  
  }
 