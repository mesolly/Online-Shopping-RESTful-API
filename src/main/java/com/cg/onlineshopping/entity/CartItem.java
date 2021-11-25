package com.cg.onlineshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="CartItem")
@ApiModel(value = "Cart items",description = "All details about the items in cart.")
public class CartItem {
	@Id
	@GeneratedValue(generator="item_seq")
	@SequenceGenerator(name="item_seq",sequenceName="item_seq",allocationSize=1)
	@Column(name="cartItem_id")
	@ApiModelProperty(notes = "The database generated cartItem ID")
	long cartItemId;
	
	
	@ApiModelProperty(notes = "Product in cart")
	@ManyToOne
	@JoinColumn(name="product_id",referencedColumnName="product_id")
	private Product product ;
	
	
	@ApiModelProperty(notes = "Quantity of the product")
	@Column(name="quantity")
	private long quantity ;
	
	public CartItem() {
		super();
	}

	public long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	
	
}
