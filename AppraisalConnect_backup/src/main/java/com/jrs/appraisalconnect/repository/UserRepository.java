package com.jrs.appraisalconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrs.appraisalconnect.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
