package com.jrs.appraisalconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrs.appraisalconnect.model.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

}
