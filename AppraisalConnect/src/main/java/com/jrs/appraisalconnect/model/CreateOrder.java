package com.jrs.appraisalconnect.model;

import java.util.List;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CreateOrder {

	private Order order;
	private String[] reports;
	private Borrower[] borrowers;
	private Contact[] contacts;
}
