package com.jrs.appraisalconnect.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ContactId    implements Serializable {

	private String cntOrdId;

	private String cntFirstName;

	private String cntLastName;
	
	private String cntType;
	
	private String cntVal;
}
