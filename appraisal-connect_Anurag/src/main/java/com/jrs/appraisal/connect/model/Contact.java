package com.jrs.appraisal.connect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_orders_contacts")
//@IdClass(ContactId.class)
public class Contact {

	@Id
	@Column(name="CNT_ORD_ID")
	private String cntOrdId;

	@Column(name="CNT_FIRST_NAME")	
	private String cntFirstName;

	@Column(name="CNT_LAST_NAME")		
	private String cntLastName;

	@Column(name="CNT_TYPE")		
	private String cntType;

	@Column(name="CNT_VAL")		
	private String cntVal;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	
}
