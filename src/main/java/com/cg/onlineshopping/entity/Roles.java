package com.cg.onlineshopping.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="Roles")
@ApiModel(description = "Role of the user.")
public class Roles {
	
	@Id
	@Column(name="role_id")
	@ApiModelProperty(notes = "Role ID")
	private long id ;
	
	@Column(name="role_name")
	@NotNull
	@ApiModelProperty(notes = "Role name")
	private String name ;

	public Roles() {
		
	}
	
}
