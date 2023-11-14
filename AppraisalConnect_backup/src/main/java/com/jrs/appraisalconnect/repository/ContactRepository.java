package com.jrs.appraisalconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrs.appraisalconnect.model.Contact;
import com.jrs.appraisalconnect.model.ContactId;

@Repository
public interface ContactRepository extends JpaRepository<Contact, ContactId> {
	List<Contact> findByCntOrdId(String cntOrdId);
}
