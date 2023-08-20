package com.jrs.appraisalconnect.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity

@Table(name="tbl_orders")
public class Order {

	  @Id
	  @Column(name="ORD_ID")
	  private String ordId;
	  
	  @Column(name="ORD_NUM")
	  private String ordNum;

	  @Column(name="ORD_USR_ID")
	  private String ordUsrId;
	  
		@Column(name="ORD_HOUSE_NUM")
		private String ordHouseNum;

		@Column(name="ORD_STREET1")
		private String ordStreet1;

		@Column(name="ORD_STREET2")
		private String ordStreet2;

		@Column(name="ORD_CITY")
		private String ordCity;

		@Column(name="ORD_PROV")
		private String ordProv;

		@Column(name="ORD_POSTAL")
		private String ordPostal;

	  @Column(name="ORD_CLIENTREF")
	  private String ordClientref;

	  @Column(name="ORD_LOANTYPE")
	  private Long ordLoantype;

	  @Column(name="ORD_PROPVALUE")
	  private String ordPropvalue;
	  
	  @Column(name="ORD_RPTRQST_DT")
	  private String ordRptrqstDt;

	  @Column(name="ORD_ANTCLOS_DT")
	  private String ordAntclosDt;

	  @Column(name="ORD_APPOINTMENT_DTTIME")
	  private String ordApptDtTime;

	  @Column(name="ORD_STATUS")
	  private Long ordStatus;
	
}
