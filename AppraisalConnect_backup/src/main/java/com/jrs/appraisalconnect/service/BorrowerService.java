package com.jrs.appraisalconnect.service;

import java.util.List;

import com.jrs.appraisalconnect.model.Borrower;

public interface BorrowerService {

	Borrower saveBorrower(Borrower myborrower);
	
	List<Borrower>getBorrowerById(String myBorrowerId);
	
	void deleteBorrowerById(Borrower myborrower);
}
