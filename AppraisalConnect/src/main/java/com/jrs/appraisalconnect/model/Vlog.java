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
@Table(name="tbl_vlog")
public class Vlog {
	
	@Id
	@Column(name="VLG_ID")	
	private String vlogId;
	
	@Column(name="VLG_ORD_ID")	
	private String vlogOrdId;
	
	@Column(name="VLG_USR_ID")	
	private String vlogUsrId;
	
	
	@Column(name="VLG_DESC")	
	private String vlogDesc;
	
	@Column(name="VLG_DATE")	
	private String vlogDate;
	
	@Column(name="VLG_TIME")	
	private String vlogTime;
	
}
