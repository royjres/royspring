package com.jrs.appraisal.connect.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class BorrowerId implements Serializable {

	private String brwOrdId;

	private String brwFirstName;

	private String brwLastName;
}
