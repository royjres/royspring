package com.jrs.appraisalconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrs.appraisalconnect.model.OrderFiles;


@Repository
public interface OrderFilesRepository extends JpaRepository<OrderFiles, String> {
	List<OrderFiles> findByFilOrdId(String filOrdId);
	
	OrderFiles findByFilId(String filFilId);
}
