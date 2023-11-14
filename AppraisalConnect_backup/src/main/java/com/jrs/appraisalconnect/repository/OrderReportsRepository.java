package com.jrs.appraisalconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrs.appraisalconnect.model.OrderReports;
import com.jrs.appraisalconnect.model.OrderReportsId;

@Repository
public interface OrderReportsRepository extends JpaRepository<OrderReports, OrderReportsId> {
	List<OrderReports> findByRptOrdId(String rptOrdId);
}
