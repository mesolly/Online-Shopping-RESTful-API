package com.cg.onlineshopping.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity																			//Class is an entity and mapped to database
@Table(name="ShoppingCart")														//Table name in databse
@ApiModel(value = "Shopping Cart",description = "Shopping cart of the user.")
public class ShoppingCart {
	
	@Id
	@GeneratedValue(generator="cart_seq")
	@SequenceGenerator(name="cart_seq",sequenceName="cart_seq",allocationSize=1)
	@Column(name="cart_id")
	@ApiModelProperty(notes = "The database generated cart ID")
	long cartId;
	
	@Column(name="date_added")
	@ApiModelProperty(notes = "Date of order")
	String dateAdded ;
	
	
	@JsonIgnore
	@OneToOne(mappedBy="Cart")
	@ApiModelProperty(notes = "Cart for User")
	private User user ;
	
	@ApiModelProperty(notes = "Items in Cart")
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<CartItem>cartItem = new HashSet<CartItem>();
	/*
	 * @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER) private
	 * List<Product>prodCart = new ArrayList<>();
	 */
	
	
	
	public ShoppingCart() {
		super();
	}
	
	

	public long getCartId() {
		return cartId;
	}



	public void setCartId(long cartId) {
		this.cartId = cartId;
	}



	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CartItem> getCartItem() {
		return cartItem;
	}



	public void setCartItem(Set<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
	
}
