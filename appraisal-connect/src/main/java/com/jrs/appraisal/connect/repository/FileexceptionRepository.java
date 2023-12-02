package com.jrs.appraisal.connect.repository;

import com.jrs.appraisal.connect.model.Fileexception;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileexceptionRepository extends JpaRepository<Fileexception, String> {

}
