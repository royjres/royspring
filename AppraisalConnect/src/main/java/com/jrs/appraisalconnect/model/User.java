package com.jrs.appraisalconnect.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity

@Table(name="tbl_users")
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="USR_ID")
	private Long usrId;
	
	@Column(name="USR_EMAIL")
	private String usrEmail;

	@Column(name="USR_FIRST_NAME")
	private String usrFirstName;

	@Column(name="USR_MIDDLE_NAME")	
	private String usrMiddleName;

	@Column(name="USR_LAST_NAME")	
	private String usrLastName;

	@Column(name="USR_ORG_ID")	
	private String usrOrgId;

	@Column(name="USR_ORG_ROLE")		
	private String usrOrgRole;

	
}
