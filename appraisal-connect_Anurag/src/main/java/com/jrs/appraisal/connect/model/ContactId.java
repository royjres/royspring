package com.jrs.appraisal.connect.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class ContactId implements Serializable {

	private String cntOrdId;

	private String cntFirstName;

	private String cntLastName;
	
	private String cntType;
	
	private String cntVal;
}
