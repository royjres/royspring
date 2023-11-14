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
@Table(name="tbl_orderfiles")
public class OrderFiles {

	@Id
	@Column(name="FIL_ID")
	private String filId;
	
	@Column(name="FIL_ORD_ID")
	private String filOrdId;

	@Column(name="FIL_FILE_NAME")	
	private String filFileName;
}
