package com.cg.onlineshopping.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="Product")
@ApiModel(description = "Product details")
public class Product {
	@Id
	@GeneratedValue(generator = "product_seq")
	@SequenceGenerator(name="product_seq", sequenceName = "product_seq", allocationSize = 1)
	@Column(name="product_id")
	@ApiModelProperty(notes = "The database generated product ID")
	private long productId;
	
	@Column(name="product_name")
	@NotNull
	@ApiModelProperty(notes = "Name of the product")
	private String name;
	
	@Column(name="product_description")
	@NotNull
	@ApiModelProperty(notes = "The description of the product")
	private String description;
	
	@Column(name="product_price")
	@NotNull
	@ApiModelProperty(notes = "The price of the product")
	private long price;
	
	@Column(name="product_image_file_name")
	@NotNull
	@ApiModelProperty(notes = "File name of the Image")
	private String imageFileName;
	
	
	@ApiModelProperty(notes = "Product in Category")
	//@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private Category category;
	
	/*
	 * @ManyToMany(mappedBy="prodCart") List<ShoppingCart>shopCart = new
	 * ArrayList<>();
	 */

	public Product() {
		super();
	}
	
	public void assginCategort(Category category) {
		this.category = category ;
	}
	
	
	public Product(@NotNull String name, @NotNull String description, @NotNull long price,
			@NotNull String imageFileName) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageFileName = imageFileName;
	}
	
	
	

	public Product(@NotNull String name, @NotNull String description, @NotNull long price,
			@NotNull String imageFileName, Category category) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageFileName = imageFileName;
		this.category = category;
	}



	public long getProductId() {
		return productId;
	}



	public void setProductId(long productId) {
		this.productId = productId;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", description=" + description + ", price="
				+ price + ", imageFileName=" + imageFileName + ", category=" + category + "]";
	}
	
	
}
