package com.cg.onlineshopping.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Users")
@ApiModel(description = "All details about the User.")
public class User {
	@Id
	@GeneratedValue(generator="usr_seq")
	@SequenceGenerator(name="usr_seq",sequenceName = "usr_seq",allocationSize = 1)
	@Column(name="user_id")
	@ApiModelProperty(notes = "The database generated User ID")
	private long userId;
	
	@Column(name ="user_name")
	@ApiModelProperty(notes = "User's full name")
	private String name ;
	
	@Column(name="user_email")
	@NotNull
	@ApiModelProperty(notes = "User's email ID")
	private String email ;
	
	@Column(name="user_password")
	@NotNull
	@ApiModelProperty(notes = "User's password")
	private String password ;
	
	@Column(name="user_address") 
	@NotNull
	@ApiModelProperty(notes = "User's home address")
	private String address ;
	
	
	@Column(name="user_phoneno")
	@NotNull
	@ApiModelProperty(notes = "User's phone number")
	private long phoneno;
	
	@Column(name="user_cardinfo")
	@ApiModelProperty(notes = "User's card information for transactions")
	private String cardinfo ;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="users_roles",joinColumns = @JoinColumn(name ="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	@ApiModelProperty(notes = "User's role in the application (ie. Admin or Customer)")
	private Set<Roles> roles = new HashSet<>();
	
	@JsonIgnore
	 @OneToMany(fetch = FetchType.EAGER, mappedBy = "user",cascade =CascadeType.ALL) 
	@ApiModelProperty(notes = "List of orders placed by user")
	 private Set<Orders> orders = new HashSet<Orders>();
	 
	
	@JsonIgnore
	@OneToOne(fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="cart_id")
	@ApiModelProperty(notes = "Details of user's shopping cart")
	private ShoppingCart Cart ;
	
	public User() {
		super();
	}
	
	
	
	public Set<Roles> getRoles() {
		return roles;
	}



	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}



	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public String getCardinfo() {
		return cardinfo;
	}

	public void setCardinfo(String cardinfo) {
		this.cardinfo = cardinfo;
	}


	public ShoppingCart getCart() {
		return Cart;
	}


	public void setCart(ShoppingCart cart) {
		Cart = cart;
	}


	public Set<Orders> getOrders() {
		return orders;
	}


	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
	
	
}
