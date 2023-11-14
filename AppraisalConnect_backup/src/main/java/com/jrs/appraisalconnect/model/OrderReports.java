package com.jrs.appraisalconnect.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_orderreports")
@IdClass(OrderReportsId.class)
public class OrderReports {
	
	@Id
	@Column(name="RPT_ORD_ID")
	private String rptOrdId;

	@Id
	@Column(name="RPT_REPORT_TYPE")
	private String rptReportType;


}
