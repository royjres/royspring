package com.jrs.appraisal.connect.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Setter
@Getter
@Entity
@Table(name="tbl_reports")
public class Reports {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;
    private String reporttype;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    @JsonBackReference(value = "order")
    Order order;
}
