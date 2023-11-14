package com.jrs.appraisal.connect.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.util.List;


@Builder
@Setter
@Getter
@Entity
@Table(name="tbl_orders")
public class Order {
    @Id
    @GenericGenerator(
            name = "string_custom_sequence",
            strategy = "com.jrs.appraisal.connect.util.SequenceIdGenerator"
    )
    @GeneratedValue(generator = "string_custom_sequence")
    @Column(name="ORD_ID")
    private String ordId;
    private String newfile_filenum;
    private String newfile_username;
    private String newfile_organization;
    private String newfile_report_type;
    private String newfile_client_loan_ref;
    private String newfile_loan_type;
    private String newfile_postalcode;
    private String newfile_city;
    private String newfile_streetno;
    private String newfile_streetname;
    private String newfile_suiteapt;
    private String newfile_prov;
    private String newfile_address;
    private String newfile_estimated_prop_value;
    private String newfile_report_request_date;
    private String newfile_anticipated_closing_date;
    private String newfile_special_instructions;
    private String newfile_status;
    private String newfile_appointment_datetime;
    private String newfile_appraiser;
    private String newfile_reviewer;
    private String newfile_inspection_complete;
    private String newfile_report_submitted;
    private String newfile_fileclosed;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="order")
    @JsonManagedReference(value = "order")
    private List<Borrower> newfile_borrower;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="order")
    @JsonManagedReference(value = "order")
    private List<Contact> newfile_contact;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="order")
    @JsonManagedReference(value = "order")
    private List<OrderFiles> newfile_fileupload;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy="order")
    @JsonManagedReference(value = "order")
    private List<Reports> newfile_reports;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy="order")
    @JsonManagedReference(value = "order")
    private Vlog newfile_vlog = new Vlog();


    public Order() {
    }

    public Order(String ordId, String newfile_filenum, String newfile_username, String newfile_organization, String newfile_report_type, String newfile_client_loan_ref, String newfile_loan_type, String newfile_postalcode, String newfile_city, String newfile_streetno, String newfile_streetname, String newfile_suiteapt, String newfile_prov, String newfile_address, String newfile_estimated_prop_value, String newfile_report_request_date, String newfile_anticipated_closing_date, String newfile_special_instructions, String newfile_status, String newfile_appointment_datetime, String newfile_appraiser, String newfile_reviewer, String newfile_inspection_complete, String newfile_report_submitted, String newfile_fileclosed, List<Borrower> newfile_borrower, List<Contact> newfile_contact, List<OrderFiles> newfile_fileupload, List<Reports> newfile_reports, Vlog newfile_vlog) {
        this.ordId = ordId;
        this.newfile_filenum = newfile_filenum;
        this.newfile_username = newfile_username;
        this.newfile_organization = newfile_organization;
        this.newfile_report_type = newfile_report_type;
        this.newfile_client_loan_ref = newfile_client_loan_ref;
        this.newfile_loan_type = newfile_loan_type;
        this.newfile_postalcode = newfile_postalcode;
        this.newfile_city = newfile_city;
        this.newfile_streetno = newfile_streetno;
        this.newfile_streetname = newfile_streetname;
        this.newfile_suiteapt = newfile_suiteapt;
        this.newfile_prov = newfile_prov;
        this.newfile_address = newfile_address;
        this.newfile_estimated_prop_value = newfile_estimated_prop_value;
        this.newfile_report_request_date = newfile_report_request_date;
        this.newfile_anticipated_closing_date = newfile_anticipated_closing_date;
        this.newfile_special_instructions = newfile_special_instructions;
        this.newfile_status = newfile_status;
        this.newfile_appointment_datetime = newfile_appointment_datetime;
        this.newfile_appraiser = newfile_appraiser;
        this.newfile_reviewer = newfile_reviewer;
        this.newfile_inspection_complete = newfile_inspection_complete;
        this.newfile_report_submitted = newfile_report_submitted;
        this.newfile_fileclosed = newfile_fileclosed;
        this.newfile_borrower = newfile_borrower;
        this.newfile_contact = newfile_contact;
        this.newfile_fileupload = newfile_fileupload;
        this.newfile_reports = newfile_reports;
        this.newfile_vlog = newfile_vlog;
    }
}
