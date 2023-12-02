package com.jrs.appraisal.connect.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="tbl_fileexception")

public class Fileexception {

    @Id
    @Column(name="FILEEXCEPTION_ID")
    private String fileexceptionId;
}
