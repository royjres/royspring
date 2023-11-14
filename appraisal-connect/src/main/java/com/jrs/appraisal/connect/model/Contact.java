package com.jrs.appraisal.connect.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;


@Setter
@Getter
@Entity
@Table(name="tbl_orders_contacts")
//@IdClass(ContactId.class)
public class Contact {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(
			name = "UUID",
			strategy = "org.hibernate.id.UUIDGenerator"
	)
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
	@JoinColumn(name="order_id", nullable=false)
	@JsonBackReference(value = "order")
	private Order order;

	
}
