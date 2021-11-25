package com.cg.onlineshopping.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="shipping_info")
@ApiModel(value = "Shipping Information",description = "Information about the shipping details")
public class ShippingInfo {
	@Id
	@GeneratedValue(generator = "shipping_id_seq")
	@SequenceGenerator(name="shipping_id_seq",sequenceName = "shipping_id_seq",allocationSize = 1)
	@Column(name="shipping_id")
	@ApiModelProperty(notes = "The database generated shipping ID")
	private long shippingId;
	
	@Column(name="shipping_type")
	@ApiModelProperty(notes = "Type of shipping")
	private String shippingType;
	
	@Column(name="shipping_cost")
	@NotNull
	@ApiModelProperty(notes = "Total shipping cost")
	private long shippingCost;
	
	@Column(name="shipping_region_id")
	@NotNull
	@ApiModelProperty(notes = "ID of the shipping region")
	private long shippingRegionId;

	public ShippingInfo() {
		super();
	}
	
	
}
