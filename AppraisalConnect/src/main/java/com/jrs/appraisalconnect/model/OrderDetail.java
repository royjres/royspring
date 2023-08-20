package com.jrs.appraisalconnect.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderDetail {
	private Order order;
	private List<OrderReports> reports;
	private List<Borrower> borrowers;
	private List<Contact> contacts;
}
