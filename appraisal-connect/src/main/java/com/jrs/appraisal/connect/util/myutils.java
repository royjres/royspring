package com.jrs.appraisal.connect.util;

import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.Instant;

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


    public String get_old_reverse_timestamp() {

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



    public String get_reverse_timestamp() {

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
    }


    public String get_timestamp() {

        Instant instant = Instant.now();
        String mystr = instant.toString().replace("-","");
        mystr = mystr.replace("T","");
        mystr = mystr.replace(":","");
        mystr = mystr.replace(".","");
        mystr = mystr.replace("Z","");
        mystr = mystr.substring(0,mystr.length()-2);

        return mystr;
    }



    public String get_FileStatus(String myStatus) {

        String returnStatus = "";

        switch(myStatus) {
            case "File Open":
                returnStatus = "0";
                break;
            case "Appraiser Assigned":
                returnStatus = "1";
                break;
            case "Insp. Date Confirmed":
                returnStatus = "2";
                break;
            case "Insp. Completed":
                returnStatus = "3";
                break;
            case "Pending Review":
                returnStatus = "4";
                break;
            case "Report Rejected":
                returnStatus = "5";
                break;
            case "File Closed":
                returnStatus = "10";
                break;
        }


        return returnStatus;
    }

}
