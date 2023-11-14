package com.jrs.appraisalconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrs.appraisalconnect.model.Contact;
import com.jrs.appraisalconnect.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact saveContact(Contact mycontact) {
		// TODO Auto-generated method stub
		return contactRepository.save(mycontact);
	}

	@Override
	public List<Contact> getContactById(String myContactId) {
		// 
		return contactRepository.findByCntOrdId(myContactId);
	}

	@Override
	public void deleteContactById(Contact mycontact) {
		contactRepository.delete(mycontact);
		
	}

}
