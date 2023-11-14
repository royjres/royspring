package com.jrs.appraisalconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrs.appraisalconnect.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

	List<Order> findByOrdUsrId(String ordUsrId);
	
	Order findByOrdId(String ordId);
}
