package com.jrs.appraisal.connect.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Setter
@Getter
@Entity
@Table(name="tbl_vlog")
public class Vlog {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    @Column(name="VLOG_ORD_ID")
    private String vlogOrdId;

    @Column(name="VLOG_FILE_ID")
    private String vlogFileId;

    @Column(name="VLOG_DATE")
    private String vlogDate;

    @Column(name="VLOG_TIME")
    private String vlogTime;

    @Column(name="VLOG_USER")
    private String vlogUser;

    @Column(name="VLOG_USER_LEVEL")
    private String vlogUserLevel;

    @Column(name="VLOG_DESCRIPTION")
    private String vlogDescription;

}
