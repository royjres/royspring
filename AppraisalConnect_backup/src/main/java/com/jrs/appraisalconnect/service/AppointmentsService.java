package com.jrs.appraisalconnect.service;

import java.util.List;

import com.jrs.appraisalconnect.model.Appointment;
import com.jrs.appraisalconnect.model.Order;


public interface AppointmentsService {
	List<Appointment> getAppointments();
	
	Appointment saveAppointment(Appointment myappointment);
	
	List<Appointment> getAppointmentsbyCandidateName(String myCandidate);
	
}
