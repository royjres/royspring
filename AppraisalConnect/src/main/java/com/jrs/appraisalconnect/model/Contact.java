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
@Table(name="tbl_ordercontact")
@IdClass(ContactId.class)
public class Contact {

	@Id
	@Column(name="CNT_ORD_ID")
	private String cntOrdId;

	@Id
	@Column(name="CNT_FIRST_NAME")	
	private String cntFirstName;

	@Id
	@Column(name="CNT_LAST_NAME")		
	private String cntLastName;
	
	@Id
	@Column(name="CNT_TYPE")		
	private String cntType;
	
	@Id
	@Column(name="CNT_VAL")		
	private String cntVal;

	
}
