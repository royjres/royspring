package com.jrs.appraisal.connect.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name="tbl_users")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name="USER_ID")
    private String userId;

    @Column(name="USER_FIRST_NAME")
    private String userFirstName;

    @Column(name="USER_LAST_NAME")
    private String userLastName;

    @Column(name="USERNAME")
    private String userName;

    @Column(name="EMAILID")
    private String userEmailId;

    @Column(name="USER_ORGANIZATION")
    private String userOrganization;

    @Column(name="USER_ROLE")
    private String userRole;

    @Column(name="USER_CATEGORY")
    private String userCategory;

    @Column(name="USER_TIMEZONE")
    private String userTimezone;

    //@OneToMany(cascade = CascadeType.PERSIST, mappedBy="user")
   // @JsonManagedReference(value = "user")
   // private List<Vlog> vlogs;

}
