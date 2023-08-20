package com.jrs.appraisalconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrs.appraisalconnect.model.Organization;
import com.jrs.appraisalconnect.repository.OrganizationRepository;


@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Override
	public List<Organization> getOrganizations() {
		// TODO Auto-generated method stub
		return organizationRepository.findAll();
	}

	@Override
	public Organization saveOrganization(Organization organization) {
		// TODO Auto-generated method stub
		return organizationRepository.save(organization);
	}

}
