package com.jrs.appraisal.connect.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;

public class SequenceIdGenerator implements IdentifierGenerator {

    @Autowired
    myutils _utils;

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        //return "ORDER-"+ new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        return _utils.get_reverse_timestamp();
        //return new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(new java.util.Date());
    }
}