package com.cg.onlineshopping.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name="Category")
@ApiModel(description = "All details about Category entity.")
public class Category {
	@Id
	@GeneratedValue(generator = "category_seq")
	@SequenceGenerator(name="category_seq", sequenceName = "category_seq", allocationSize = 1)
	@Column(name="category_id")
	@ApiModelProperty(notes = "The database generated category ID")
	private long categoryId;
	
	@ApiModelProperty(notes = "Name of the category")
	@Column(name="category_name")
	@NotNull
	private String categoryName;
	
	@ApiModelProperty(notes = "Description of the category")
	@Column(name="category_description")
	@NotNull
	private String description;
	
	
	@JsonIgnore
	@OneToMany(mappedBy ="category",cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
	private Set<Product>products = new HashSet<>();
	
	public Set<Product> getProducts() {
		return products;
	}



	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	



	public Category() {
		super();
	}
	
	
	
	public Category(@NotNull String categoryName, @NotNull String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}

	

	public Category(@NotNull String categoryName, @NotNull String description, Set<Product> products) {
		super();
		this.categoryName = categoryName;
		this.description = description;
		this.products = products;
	}



	public long getCategoryId() {
		return categoryId;
	}



	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}



	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
