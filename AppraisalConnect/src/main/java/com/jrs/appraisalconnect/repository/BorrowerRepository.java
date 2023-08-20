package com.jrs.appraisalconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrs.appraisalconnect.model.Borrower;
import com.jrs.appraisalconnect.model.BorrowerId;

@Repository
public interface BorrowerRepository extends JpaRepository<Borrower, BorrowerId> {
	List<Borrower> findByBrwOrdId(String brwOrdId);
}
