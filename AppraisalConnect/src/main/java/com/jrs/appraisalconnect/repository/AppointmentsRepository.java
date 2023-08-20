package com.jrs.appraisalconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jrs.appraisalconnect.model.Appointment;

@Repository
public interface AppointmentsRepository extends JpaRepository<Appointment, String> {

	List<Appointment> findByApptCandidateName(String apptCandidateName);
}
