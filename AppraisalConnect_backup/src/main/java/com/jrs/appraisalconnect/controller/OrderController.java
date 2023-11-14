package com.jrs.appraisalconnect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jrs.appraisalconnect.model.Appointment;
import com.jrs.appraisalconnect.model.Borrower;
import com.jrs.appraisalconnect.model.Contact;
import com.jrs.appraisalconnect.model.CreateOrder;
import com.jrs.appraisalconnect.model.Order;
import com.jrs.appraisalconnect.model.OrderDetail;
import com.jrs.appraisalconnect.model.OrderFiles;
import com.jrs.appraisalconnect.model.OrderReports;
import com.jrs.appraisalconnect.model.User;
import com.jrs.appraisalconnect.model.Vlog;
import com.jrs.appraisalconnect.service.AppointmentsService;
import com.jrs.appraisalconnect.service.BorrowerService;
import com.jrs.appraisalconnect.service.ContactService;
import com.jrs.appraisalconnect.service.GeneralService;
import com.jrs.appraisalconnect.service.OrderFilesService;
import com.jrs.appraisalconnect.service.OrderReportsService;
import com.jrs.appraisalconnect.service.OrderService;
import com.jrs.appraisalconnect.service.VlogService;
import com.jrs.appraisalconnect.utils.Utils;


@CrossOrigin("*")
//@CrossOrigin
@RestController
public class OrderController {
	
	@Autowired
	private OrderService myorderService;

	@Autowired
	private OrderReportsService myOrderReportsService;

	@Autowired
	private BorrowerService myBorrowerService;

	@Autowired
	private ContactService myContactService;

	@Autowired
	private VlogService myVlogService;
	
	@Autowired
	private Utils myutils;
	
	@Autowired
	private GeneralService generalService;
	
	@Autowired
	private OrderFilesService orderFilesService;

	@Autowired
	private AppointmentsService appointmentService;
	
	
	@GetMapping("/orders")
	public List<Order> getOrders() {
		return myorderService.getOrders();
	}
	

	
	@GetMapping("/userorders")
	public List<Order> getUserOrders(@RequestParam("searchvalue") String searchUserId) {
		return myorderService.getUserOrders(searchUserId);
		
	}
	
	
	/**
	 * @param mycreateorder
	 * @return
	 */
	@PostMapping("/createorder")
	public Order saveOrder(@RequestBody CreateOrder mycreateorder) {	
	
		  String[] myreports = mycreateorder.getReports();
		  Order myorder = mycreateorder.getOrder(); 
		  myorder = myorderService.saveOrder(myorder);

		  OrderReports myOrderReports = new OrderReports();

		  for ( int i = 0; i < myreports.length; i++) {
			  myOrderReports.setRptOrdId(myorder.getOrdId());
			  myOrderReports.setRptReportType(myreports[i]);
			  myOrderReportsService.saveOrderReports(myOrderReports);
		  }

		  Borrower myBorrower = new Borrower();
		  Borrower[] myBorrowers = mycreateorder.getBorrowers();
		  
		  for ( int i = 0; i < myBorrowers.length; i++) {
			  myBorrower.setBrwOrdId(myorder.getOrdId());
			  myBorrower.setBrwFirstName(myBorrowers[i].getBrwFirstName());
			  myBorrower.setBrwLastName(myBorrowers[i].getBrwLastName());
			  myBorrowerService.saveBorrower(myBorrower);
		  }


		  Contact myContact = new Contact();
		  Contact[] myContacts = mycreateorder.getContacts();

		  for ( int i = 0; i < myContacts.length; i++) {
			  myContact.setCntOrdId(myorder.getOrdId());
			  myContact.setCntFirstName(myContacts[i].getCntFirstName());
			  myContact.setCntLastName(myContacts[i].getCntLastName());
			  myContact.setCntType(myContacts[i].getCntType());
			  myContact.setCntVal(myContacts[i].getCntVal());
			  myContactService.saveContact(myContact);
		  }


		  Vlog myVlog = new Vlog();
		  String myId = myorder.getOrdId();
		  String myTime = myId.substring(6, 12);
		  StringBuilder sb=new StringBuilder(myTime);
		  myTime = sb.reverse().toString();

		  System.out.println(myId);
		  
		  String myDate = myId.substring(12, 20);
		  StringBuilder sb2=new StringBuilder(myDate);
		  myDate = sb2.reverse().toString();		 
		  String myUsrId = myorder.getOrdUsrId();
		  
		  myVlog.setVlogId(myId);
		  myVlog.setVlogOrdId(myId);
		  myVlog.setVlogUsrId(myUsrId);
		  myVlog.setVlogDate(myDate);
		  myVlog.setVlogTime(myTime);
		  myVlog.setVlogDesc("ORDER CREATED");
		  myVlogService.saveVlog(myVlog);

		  
		  return myorder;
		 	
	}

	
	
	@PostMapping("/updateorder")
	public Order updateOrder(@RequestBody Order myOrderDetail) {	
	
	
		  Order myOldOrder = myorderService.getOrderDetail(myOrderDetail.getOrdId());
		  String oldClientRefNum = myOldOrder.getOrdClientref();
		  Long oldLoanType = myOldOrder.getOrdLoantype();
		  String oldPropValue = myOldOrder.getOrdPropvalue();
		  String oldRptRqstDt = myOldOrder.getOrdRptrqstDt();
		  String oldAntClosDt = myOldOrder.getOrdAntclosDt();
		  String oldPropHouseNum = myOldOrder.getOrdHouseNum();
		  String oldPropStreet1 = myOldOrder.getOrdStreet1();
		  String oldPropStreet2 = myOldOrder.getOrdStreet2();
		  String oldPropCity = myOldOrder.getOrdCity();
		  String oldPropProv = myOldOrder.getOrdProv();
		  String oldPropPostal = myOldOrder.getOrdPostal();
		  		  		  		 
		  myorderService.updateOrder(myOrderDetail);

		  Vlog myVlog = new Vlog();
		  String myId = myutils.get_reverse_timestamp();
		  String myOrderId = myOrderDetail.getOrdId();
		  String myTime = myId.substring(6, 12);
		  StringBuilder sb=new StringBuilder(myTime);
		  myTime = sb.reverse().toString();
		  
		  String myDate = myId.substring(12, 20);
		  StringBuilder sb2=new StringBuilder(myDate);
		  myDate = sb2.reverse().toString();		 
		  
		  String myUsrId = myOrderDetail.getOrdUsrId();
		  
		  myVlog.setVlogOrdId(myOrderId);
		  myVlog.setVlogUsrId(myUsrId);
		  myVlog.setVlogDate(myDate);
		  myVlog.setVlogTime(myTime);
		  		  
		  if ( !oldClientRefNum.equalsIgnoreCase(myOrderDetail.getOrdClientref()) ) {
			  
			  myId = myutils.get_next_vlogId(myId);
			  myVlog.setVlogId(myId);
			  myVlog.setVlogDesc("CLIENT REF NUM UPDATED FROM: " + oldClientRefNum );
			  myVlogService.saveVlog(myVlog);			  
		  }
		
		  if ( oldLoanType != myOrderDetail.getOrdLoantype() ) {
			  myId = myutils.get_next_vlogId(myId);
			  myVlog.setVlogId(myId);
			  myVlog.setVlogDesc("LOAN TYPE CHANGED FROM: " + myutils.get_Loan_Description(oldLoanType) );
			  myVlogService.saveVlog(myVlog);			  
		  }

	  
		  if ( !oldPropValue.equalsIgnoreCase(myOrderDetail.getOrdPropvalue()) ) {			
			  myId = myutils.get_next_vlogId(myId);
			  myVlog.setVlogId(myId);
			  myVlog.setVlogDesc("PROPERTY VALUE CHANGED FROM: " + oldPropValue );
			  myVlogService.saveVlog(myVlog);			  
		  }


		  if ( !oldRptRqstDt.equalsIgnoreCase(myOrderDetail.getOrdRptrqstDt()) ) {			  
			  myId = myutils.get_next_vlogId(myId);
			  myVlog.setVlogId(myId);
			  myVlog.setVlogDesc("REPORT RQST BY DATE CHANGED FROM: " + oldRptRqstDt );
			  myVlogService.saveVlog(myVlog);			  
		  }
		  
		  if ( !oldAntClosDt.equalsIgnoreCase(myOrderDetail.getOrdAntclosDt())  ) {			  
			  myId = myutils.get_next_vlogId(myId);
			  myVlog.setVlogId(myId);
			  myVlog.setVlogDesc("ANTICIPATED CLOSING DATE CHANGED FROM: " + oldAntClosDt );
			  myVlogService.saveVlog(myVlog);			  
		  }


		  if ( !oldPropHouseNum.equalsIgnoreCase(myOrderDetail.getOrdHouseNum())  ) {			  
			  myId = myutils.get_next_vlogId(myId);
			  myVlog.setVlogId(myId);
			  myVlog.setVlogDesc("PROPERTY HOUSE NUMBER CHANGED FROM: " + oldPropHouseNum );
			  myVlogService.saveVlog(myVlog);			  
		  }
		  
		  if ( !oldPropStreet1.equalsIgnoreCase(myOrderDetail.getOrdStreet1())  ) {			  
			  myId = myutils.get_next_vlogId(myId);
			  myVlog.setVlogId(myId);
			  myVlog.setVlogDesc("PROPERTY STREET NAME CHANGED FROM: " + oldPropStreet1 );
			  myVlogService.saveVlog(myVlog);			  
		  }

		  if ( !oldPropStreet2.equalsIgnoreCase(myOrderDetail.getOrdStreet2())  ) {			  
			  myId = myutils.get_next_vlogId(myId);
			  myVlog.setVlogId(myId);
			  myVlog.setVlogDesc("PROPERTY SUITE CHANGED FROM: " + oldPropStreet2 );
			  myVlogService.saveVlog(myVlog);			  
		  }
		  
		  if ( !oldPropCity.equalsIgnoreCase(myOrderDetail.getOrdCity())  ) {			  
			  myId = myutils.get_next_vlogId(myId);
			  myVlog.setVlogId(myId);
			  myVlog.setVlogDesc("PROPERTY CITY CHANGED FROM: " + oldPropCity );
			  myVlogService.saveVlog(myVlog);			  
		  }

		  if ( !oldPropProv.equalsIgnoreCase(myOrderDetail.getOrdProv())  ) {			  
			  myId = myutils.get_next_vlogId(myId);
			  myVlog.setVlogId(myId);
			  myVlog.setVlogDesc("PROPERTY PROVINCE CHANGED FROM: " + oldPropProv );
			  myVlogService.saveVlog(myVlog);			  
		  }

		  if ( !oldPropPostal.equalsIgnoreCase(myOrderDetail.getOrdPostal())  ) {			  
			  myId = myutils.get_next_vlogId(myId);
			  myVlog.setVlogId(myId);
			  myVlog.setVlogDesc("PROPERTY POSTAL CODE CHANGED FROM: " + oldPropPostal );
			  myVlogService.saveVlog(myVlog);			  
		  }		  		  
		  
		  return null;
	}
	

	@PostMapping("/updatereports")
	public void updateReports(@RequestBody OrderDetail myOrderDetail) {	
		Order myOrder = myOrderDetail.getOrder();
		String myOrderId = myOrder.getOrdId();
		OrderReports tempReport;
		boolean report_found = false;
		String vLogText = "";

		
		List<OrderReports> myOldOrderReports = myOrderReportsService.getReportsById(myOrderId);
		List<OrderReports> myNewOrderReports = myOrderDetail.getReports();

		Vlog myVlog = new Vlog();
		String myId = myutils.get_reverse_timestamp();
		String myTime = myId.substring(6, 12);
		StringBuilder sb=new StringBuilder(myTime);
		myTime = sb.reverse().toString();
		  
		String myDate = myId.substring(12, 20);
		StringBuilder sb2=new StringBuilder(myDate);
		myDate = sb2.reverse().toString();		 
		  
		String myUsrId = myOrder.getOrdUsrId();
		  
		myVlog.setVlogOrdId(myOrderId);
		myVlog.setVlogUsrId(myUsrId);
		myVlog.setVlogDate(myDate);
		myVlog.setVlogTime(myTime);

		for ( int i = 0; i < myNewOrderReports.size(); i++) {
			tempReport = myNewOrderReports.get(i);
						
			report_found = false;
			for ( int j = 0; j < myOldOrderReports.size(); j++ ) {
				if ( myOldOrderReports.get(j).getRptReportType().trim().equals(tempReport.getRptReportType().trim())  ) {
					report_found = true;	
					break;
				}
			}
			
			if (!report_found) {
				myOrderReportsService.saveOrderReports(tempReport);
				
				vLogText = "ADDED REPORT: " + tempReport.getRptReportType();
				myId = myutils.get_next_vlogId(myId);
				myVlog.setVlogId(myId);
				myVlog.setVlogDesc(vLogText );
				myVlogService.saveVlog(myVlog);			  

				report_found = false;
			}
					
		}
		
		
		for ( int i = 0; i < myOldOrderReports.size(); i++) {
			tempReport = myOldOrderReports.get(i);
			
			report_found = false;
			for ( int j=0; j < myNewOrderReports.size(); j++) {
				if ( myNewOrderReports.get(j).getRptReportType().trim().equals(tempReport.getRptReportType().trim())  ) {
					report_found = true;	
					break;
				}				
			}

			if (!report_found) {
				myOrderReportsService.deleteReportsById(tempReport);
				
				vLogText = "DELETED REPORT: " + tempReport.getRptReportType();
				myId = myutils.get_next_vlogId(myId);
				myVlog.setVlogId(myId);
				myVlog.setVlogDesc(vLogText );
				myVlogService.saveVlog(myVlog);			  
				
				report_found = false;
			}

		}
		
		
		
	}
	
	
	@PostMapping("/updateborrowercontact")
	public void updateBorrowerContact(@RequestBody OrderDetail myOrderDetail) {	

		Order myOrder = myOrderDetail.getOrder();
		String myOrderId = myOrder.getOrdId();
		Borrower tempBorrower;
		Contact tempContact;
		String vLogText = "";
		
		boolean borrower_found = false;
		boolean contact_found = false;

		List<Borrower> myOldBorrowers = myBorrowerService.getBorrowerById(myOrderId); 
		List<Borrower> myNewBorrowers = myOrderDetail.getBorrowers();
		
		List<Contact> myOldContacts = myContactService.getContactById(myOrderId);
		List<Contact> myNewContacts = myOrderDetail.getContacts();
		
		Vlog myVlog = new Vlog();
		String myId = myutils.get_reverse_timestamp();
		String myTime = myId.substring(6, 12);
		StringBuilder sb=new StringBuilder(myTime);
		myTime = sb.reverse().toString();
		  
		String myDate = myId.substring(12, 20);
		StringBuilder sb2=new StringBuilder(myDate);
		myDate = sb2.reverse().toString();		 
		  
		String myUsrId = myOrder.getOrdUsrId();
		  
		myVlog.setVlogOrdId(myOrderId);
		myVlog.setVlogUsrId(myUsrId);
		myVlog.setVlogDate(myDate);
		myVlog.setVlogTime(myTime);


		
		//  BORROWERS
		
		
		for ( int i = 0; i < myNewBorrowers.size(); i++) {
			tempBorrower = myNewBorrowers.get(i);
			
			borrower_found = false;
			for ( int j = 0; j < myOldBorrowers.size(); j++) {
				if ( myOldBorrowers.get(j).getBrwFirstName().equals(tempBorrower.getBrwFirstName()) &&
						myOldBorrowers.get(j).getBrwLastName().equals(tempBorrower.getBrwLastName())	
					) 
				{
					borrower_found = true;
					break;
				}
			}			
			
			if (!borrower_found) {
				myBorrowerService.saveBorrower(tempBorrower);
				vLogText = "ADDED BORROWER: " + tempBorrower.getBrwFirstName() + " " + tempBorrower.getBrwLastName();
				myId = myutils.get_next_vlogId(myId);
				myVlog.setVlogId(myId);
				myVlog.setVlogDesc(vLogText );
				myVlogService.saveVlog(myVlog);			  

				borrower_found = false;
			}
			
			
		}
		
		for ( int i=0; i < myOldBorrowers.size(); i++ ) {
			tempBorrower = myOldBorrowers.get(i);
			
			borrower_found = false;
			for ( int j=0; j < myNewBorrowers.size(); j++ ) {
				if ( myNewBorrowers.get(j).getBrwFirstName().equals(tempBorrower.getBrwFirstName()) && 
						myNewBorrowers.get(j).getBrwLastName().equals(tempBorrower.getBrwLastName())
						) 
				{
					borrower_found = true;
					break;				
				}
			}
			
			if (!borrower_found) {
				myBorrowerService.deleteBorrowerById(tempBorrower);
				vLogText = "DELETED BORROWER: " + tempBorrower.getBrwFirstName() + " " + tempBorrower.getBrwLastName();
				myId = myutils.get_next_vlogId(myId);
				myVlog.setVlogId(myId);
				myVlog.setVlogDesc(vLogText );
				myVlogService.saveVlog(myVlog);			  
				
				borrower_found = false;
			}

		}
		
		//  CONTACTS
		
		for ( int i = 0; i < myNewContacts.size(); i++) {
			tempContact = myNewContacts.get(i);
			
			contact_found = false;
			for ( int j = 0; j < myOldContacts.size(); j++) {
				if ( myOldContacts.get(j).getCntFirstName().equals(tempContact.getCntFirstName()) &&
						myOldContacts.get(j).getCntLastName().equals(tempContact.getCntLastName())	
					) 
				{
					contact_found = true;
					break;
				}
			}			
			
			if (!contact_found) {
				myContactService.saveContact(tempContact);
				
				vLogText = "ADDED CONTACT: " + tempContact.getCntFirstName() + " " + tempContact.getCntLastName() + ":" + tempContact.getCntType() + ":" + tempContact.getCntVal();
				myId = myutils.get_next_vlogId(myId);
				myVlog.setVlogId(myId);
				myVlog.setVlogDesc(vLogText );
				myVlogService.saveVlog(myVlog);			  
				
				contact_found = false;
			}
			
			
		}
		
		for ( int i=0; i < myOldContacts.size(); i++ ) {
			tempContact = myOldContacts.get(i);
			
			contact_found = false;
			for ( int j=0; j < myNewContacts.size(); j++ ) {
				if ( myNewContacts.get(j).getCntFirstName().equals(tempContact.getCntFirstName()) && 
						myNewContacts.get(j).getCntLastName().equals(tempContact.getCntLastName())
						) 
				{
					contact_found = true;
					break;				
				}
			}
			
			if (!contact_found) {
				myContactService.deleteContactById(tempContact);
				
				vLogText = "DELETED CONTACT: " + tempContact.getCntFirstName() + " " + tempContact.getCntLastName() + ":" + tempContact.getCntType() + ":" + tempContact.getCntVal();
				myId = myutils.get_next_vlogId(myId);
				myVlog.setVlogId(myId);
				myVlog.setVlogDesc(vLogText );
				myVlogService.saveVlog(myVlog);			  
				
				contact_found = false;
			}

		}

		
		
		
	}
	

	@GetMapping("/getFilesById")
	public List<OrderFiles> getFilesById(@RequestParam("orderid") String orderFileId) {
		
		return orderFilesService.getOrderFiles(orderFileId);  
				
	}

	
	
	
	@GetMapping("/getOrderById")
	public OrderDetail getOrderById(@RequestParam("orderid") String orderDetailId) {
		
		return generalService.getOrderById(orderDetailId);
				
	}

	@PostMapping("/appointment")
	public Appointment saveAppointment(@RequestBody Appointment myappointment) {
		myappointment.setApptId(myutils.get_reverse_timestamp());
		return appointmentService.saveAppointment(myappointment);
	}

	@GetMapping("/getAppointmentByCandidate")
	public List<Appointment> getAppointmentByName(@RequestParam("candidatename") String myCandidate) {
		
		return appointmentService.getAppointmentsbyCandidateName(myCandidate);
	}

	
}
