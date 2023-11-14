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

@Table(name="tbl_org")
public class Organization {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="ORG_ID")
	private Long orgId;
	
	@Column(name="ORG_ALIAS_PREFIX")
	private String orgAliasPrefix;

	@Column(name="ORG_NAME")
	private String orgName;

	@Column(name="ORG_ADDRESS")		
	private String orgAddress;

}
