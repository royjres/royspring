package com.jrs.appraisalconnect.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BorrowerId   implements Serializable {

	private String brwOrdId;

	private String brwFirstName;

	private String brwLastName;
}
