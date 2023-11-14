package com.jrs.appraisal.connect.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_orders_borrowers")
@IdClass(BorrowerId.class)
public class Borrower {

    @Id
    @Column(name="BRW_ORD_ID")
    private String brwOrdId;

    @Column(name="BRW_FIRST_NAME")
    private String brwFirstName;

    @Column(name="BRW_LAST_NAME")
    private String brwLastName;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

}

