package com.jrs.appraisal.connect.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Userlogged {

    private String userId;

    private String userFirstName;

    private String userLastName;

    private String userName;

    private String userOrganization;

    private String userRole;

    private String userCategory;

}
