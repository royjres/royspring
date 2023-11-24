package com.jrs.appraisal.connect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Setter
@Getter
@Entity
@Table(name="tbl_message")
public class Message {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )

    @Column(name="MSG_ID")
    private String msgId;

    @Column(name="MSG_FILE_ID")
    private String msgFileId;

    @Column(name="MSG_TEXT")
    private String msgText;

    @Column(name="MSG_ROLE")
    private String msgRole;

    @Column(name="MSG_DATETIME")
    private String msgDateTime;

    @Column(name="MSG_USER")
    private String msgUaer;


}
