package com.cg.onlineshopping.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Orders")
@ApiModel(description = "Orders Entity.")
public class Orders {
	
	@Id
	@GeneratedValue(generator="order_seq")
	@SequenceGenerator(name="order_seq", sequenceName = "order_seq", allocationSize = 1)
	@Column(name="order_id")
	@ApiModelProperty(notes = "The database generated Order ID")
	long orderId ;
	
	@ApiModelProperty(notes = "Created Date")
	@Column(name="date_created")
	String dateCreated ;
	
	@ApiModelProperty(notes = "Shipping Date")
	@Column(name="date_shipped")
	String dateShipped ;
	
	@ApiModelProperty(notes = "Customer Name")
	@Column(name="cust_name")
	String customerName ;
	
	@ApiModelProperty(notes = "Order Status")
	@Column(name="status")
	@NotNull
	String status;
	
	@ApiModelProperty(notes = "Order Linked to User Id")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ApiModelProperty(notes = "Cart Created for User")
	@OneToOne(fetch=FetchType.EAGER,cascade =CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private ShoppingCart userCart ;
	
	@ApiModelProperty(notes = "Display Order Details")
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<OrderDetail>orderDetail= new HashSet<OrderDetail>();
	
	public Orders() {
		super();
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateShipped() {
		return dateShipped;
	}

	public void setDateShipped(String dateShipped) {
		this.dateShipped = dateShipped;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ShoppingCart getUserCart() {
		return userCart;
	}

	public void setUserCart(ShoppingCart userCart) {
		this.userCart = userCart;
	}

	public Set<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(Set<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	} 
	
	
	
}
