package com.jrs.appraisal.connect.repository;

import com.jrs.appraisal.connect.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface OrderRepository extends JpaRepository<Order, String> {
}
