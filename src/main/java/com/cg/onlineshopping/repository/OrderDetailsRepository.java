package com.cg.onlineshopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineshopping.entity.OrderDetail;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Long>{

}
