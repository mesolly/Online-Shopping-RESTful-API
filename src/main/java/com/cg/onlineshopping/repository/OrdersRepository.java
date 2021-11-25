package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

}
