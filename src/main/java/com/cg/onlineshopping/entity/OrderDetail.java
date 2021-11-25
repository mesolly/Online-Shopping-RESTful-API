package com.cg.onlineshopping.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="order_detail")
@ApiModel(description = "Order Details entity.")
public class OrderDetail {
	@Id
   	@GeneratedValue(generator = "order_id_seq")
	@SequenceGenerator(name="order_id_seq",sequenceName = "order_id_seq",allocationSize = 1)
	@Column(name="orderdetail_id")
	@ApiModelProperty(notes = "The database generated orderDetail ID")
	private long orderDetailId;
	
	@ApiModelProperty(notes = "Product Id")
	@Column(name="product_id")
	@NotNull
	private long productId;
	
	@ApiModelProperty(notes = "Name of Product")
	@Column(name="product_name")
	@NotNull
	private String productName;

	
	@ApiModelProperty(notes = "Quantity of Product")
	@Column(name="quantity")
	@NotNull
	private long quantity;
	
	@ApiModelProperty(notes = "unit cost of Product")
	@Column(name="unit_cost")
	@NotNull
	private float unitCost;
	
	@ApiModelProperty(notes = "Subtotal of Product")
	@Column(name="subtotal")
	private float subTotal;
	
	public OrderDetail() {
		super();
	}

	public long getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(long orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(float unitCost) {
		this.unitCost = unitCost;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	
}
