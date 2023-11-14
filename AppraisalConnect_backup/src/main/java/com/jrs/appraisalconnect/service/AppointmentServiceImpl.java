package com.jrs.appraisalconnect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrs.appraisalconnect.model.Appointment;
import com.jrs.appraisalconnect.repository.AppointmentsRepository;

@Service
public class AppointmentServiceImpl implements AppointmentsService {

	@Autowired
	AppointmentsRepository appointmentRepository;
	
	@Override
	public List<Appointment> getAppointments() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}

	@Override
	public Appointment saveAppointment(Appointment myappointment) {
		// TODO Auto-generated method stub
		return appointmentRepository.save(myappointment);
	}

	@Override
	public List<Appointment> getAppointmentsbyCandidateName(String myCandidate) {
		// TODO Auto-generated method stub
		return appointmentRepository.findByApptCandidateName(myCandidate);
	}

}
