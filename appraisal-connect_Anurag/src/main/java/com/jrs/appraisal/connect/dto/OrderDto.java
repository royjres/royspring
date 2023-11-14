package com.jrs.appraisal.connect.dto;

import com.jrs.appraisal.connect.model.Borrower;
import com.jrs.appraisal.connect.model.Contact;
import com.jrs.appraisal.connect.model.Order;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class OrderDto {

    private Order order;
    private String[] reports;
    private Borrower[] borrowers;
    private Contact[] contacts;
}
