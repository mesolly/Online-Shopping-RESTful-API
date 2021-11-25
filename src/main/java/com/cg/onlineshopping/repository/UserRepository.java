package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{

}
