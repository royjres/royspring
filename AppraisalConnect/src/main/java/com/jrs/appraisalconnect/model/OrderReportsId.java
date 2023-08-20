package com.jrs.appraisalconnect.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderReportsId implements Serializable {
	private String rptOrdId;

	private String rptReportType;
}
