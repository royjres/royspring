package com.jrs.appraisalconnect.utils;

import java.sql.Timestamp;

import org.springframework.stereotype.Service;

@Service
public class Utils {

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
	
	public String get_next_vlogId(String currentVlogId) {
		
		  String value1, value2 = "";
		  int value = 0;

		  value2 = currentVlogId.substring(18, 20);
		  value1 = currentVlogId.substring(0, 18);
		  value = Integer.parseInt(value2);
		  value = value + 1;
		  if (value < 10) {
			  value2 = "0" + value;
		  } else {
			  value2 = "" + value;
		  }
		  return (value1+value2);

	}
	
	
	public String get_Loan_Description(Long loanTypeId) {
		String loanDescription = "";
		
		switch(""+loanTypeId) {
			case "0":
				loanDescription = "Purchase/Mortgage";
				break;
			case "1":
				loanDescription = "Re-finance/Mortgage";				
				break;
			case "2":
				loanDescription = "Transfer";				
				break;
			case "3":
				loanDescription = "SLOC";				
				break;											
		}
		return loanDescription;
	}

}
