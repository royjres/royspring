package com.jrs.appraisalconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrs.appraisalconnect.model.Vlog;

@Repository
public interface VlogRepository extends JpaRepository<Vlog, String> {

}
