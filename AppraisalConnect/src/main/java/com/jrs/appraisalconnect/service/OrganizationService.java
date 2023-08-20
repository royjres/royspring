package com.jrs.appraisalconnect.service;

import java.util.List;

import com.jrs.appraisalconnect.model.Organization;

public interface OrganizationService {

	List<Organization> getOrganizations();
	
	Organization saveOrganization(Organization organization);
	
	
}
