package com.jrs.appraisal.connect.repository;

import com.jrs.appraisal.connect.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
