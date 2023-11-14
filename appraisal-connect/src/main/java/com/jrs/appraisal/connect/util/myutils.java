package com.jrs.appraisal.connect.util;

import org.springframework.stereotype.Service;
import java.sql.Timestamp;

@Service
public class myutils {

    public String get_FileNum(String myorganization) {
        String myFileNum = "";
        String myFileCode = "";
        String myTimestamp = this.get_reverse_timestamp();
        myTimestamp = myTimestamp.substring(0,5);

        switch(myorganization) {
            case "Fidelity National Financial":
                myFileCode = "FNF";
                break;
            case "Solidifi":
                myFileCode = "SDF";
                break;
            case "Brookfield RPS":
                myFileCode = "BKF";
                break;
            case "Non-AMC Lawyers":
                myFileCode = "NAL";
                break;
            case "Private Residential":
                myFileCode = "PRS";
                break;
            case "ATC":
                myFileCode = "ATC";
                break;
        }

        myFileNum = myFileCode + "-01-" + myTimestamp;
        return myFileNum;
    }


    public String get_reverse_timestamp() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String mytimestamp = timestamp.toString();
        String myrandom_str = "";
        mytimestamp = mytimestamp.replace(":","");
        mytimestamp = mytimestamp.replace(" ","");
        mytimestamp = mytimestamp.replace(".","");
        mytimestamp = mytimestamp.replace("-","").trim();

        if ( mytimestamp.length() == 16) {
            mytimestamp = mytimestamp + "0";
        }  else {
            if ( mytimestamp.length() == 15 ) {
                mytimestamp = mytimestamp + "00";
            } else {
                if ( mytimestamp.length() == 14 ) {
                    mytimestamp = mytimestamp + "000";
                }
            }
        }

        int rand = (int) (Math.random() * 999);
        if (rand == 0) {
            myrandom_str = "000";
        } else {
            if ( rand < 10 ) {
                myrandom_str = "00" + rand;
            } else {
                if ( rand < 100 ) {
                    myrandom_str = "0" + rand;
                } else {
                    myrandom_str = ""+rand;
                }
            }
        }

        mytimestamp = mytimestamp + myrandom_str;

        StringBuilder sb=new StringBuilder(mytimestamp);
        String reverse_timestamp = sb.reverse().toString();
        return reverse_timestamp;
    }
}
