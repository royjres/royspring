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
@Table(name="tbl_orders_borrowers")
//@IdClass(BorrowerId.class)
public class Borrower {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="BRW_ORD_ID")
    private String brwOrdId;

    @Column(name="BRW_FIRST_NAME")
    private String brwFirstName;

    @Column(name="BRW_LAST_NAME")
    private String brwLastName;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    @JsonBackReference(value = "order")
    Order order;

}

