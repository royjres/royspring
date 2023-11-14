package com.jrs.appraisal.connect.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;


@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_orderfiles")
public class OrderFiles {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="FIL_ID")
    private String filId;

    @Column(name="FIL_ORD_ID")
    private String filOrdId;

    @Column(name="FIL_FILE_NAME")
    private String filFileName;

    @Column(name="FILE_UPLOAD_TIME")
    private String uploadtime;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    @JsonBackReference(value = "order")
    private Order order;
}
