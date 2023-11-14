package com.jrs.appraisalconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrs.appraisalconnect.model.Borrower;
import com.jrs.appraisalconnect.repository.BorrowerRepository;

@Service
public class BorrowerServiceImpl implements BorrowerService {

	@Autowired
	private BorrowerRepository borrowerRepository;
	
	@Override
	public Borrower saveBorrower(Borrower myborrower) {
		
		return borrowerRepository.save(myborrower);
	}

	@Override
	public List<Borrower> getBorrowerById(String myBorrowerId) {
		
		return borrowerRepository.findByBrwOrdId(myBorrowerId);
	}

	@Override
	public void deleteBorrowerById(Borrower myborrower) {
		
		borrowerRepository.delete(myborrower);
		
	}

}
