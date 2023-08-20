package com.jrs.appraisalconnect.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_appointments")
public class Appointment {

	  @Id
	  @Column(name="APPT_ID")
	  private String apptId;
	  
	  @Column(name="APPT_ORD_ID")
	  private String apptOrdId;

	  @Column(name="APPT_CANDIDATE_NAME")
	  private String apptCandidateName;

	  @Column(name="APPT_DTTIME")
	  private String apptDttime;
	  
	  @Column(name="APPT_DURATION")
	  private String apptDuration;
	  
}
