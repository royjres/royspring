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
@Table(name="tbl_orderborrower")
@IdClass(BorrowerId.class)
public class Borrower {

	@Id
	@Column(name="BRW_ORD_ID")
	private String brwOrdId;

	@Id
	@Column(name="BRW_FIRST_NAME")	
	private String brwFirstName;

	@Id
	@Column(name="BRW_LAST_NAME")		
	private String brwLastName;

}
