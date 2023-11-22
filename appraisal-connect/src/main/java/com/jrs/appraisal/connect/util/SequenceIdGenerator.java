package com.jrs.appraisal.connect.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Instant;

public class SequenceIdGenerator implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        //return "ORDER-"+ new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
        Instant instant = Instant.now();
        String mystr = instant.toString().replace("-","");
        mystr = mystr.replace("T","");
        mystr = mystr.replace(":","");
        mystr = mystr.replace(".","");
        mystr = mystr.replace("Z","");
        mystr = mystr.substring(0,mystr.length()-2);
        StringBuilder mystr_rev = new StringBuilder(mystr);
        mystr = mystr_rev.reverse().toString();
        return mystr;
        //return new SimpleDateFormat("yyyyMMddHHmmssSSSSSS").format(new java.util.Date());
    }
}