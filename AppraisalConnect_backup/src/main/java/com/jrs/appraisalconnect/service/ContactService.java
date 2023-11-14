package com.jrs.appraisalconnect.service;

import java.util.List;

import com.jrs.appraisalconnect.model.Contact;

public interface ContactService {

	Contact saveContact(Contact mycontact);
	
	List<Contact> getContactById(String myContactId);
	
	void deleteContactById(Contact mycontact);
}
