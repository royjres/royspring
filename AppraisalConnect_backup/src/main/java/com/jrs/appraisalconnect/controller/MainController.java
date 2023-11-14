package com.jrs.appraisalconnect.controller;


import java.io.IOException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jrs.appraisalconnect.model.OrderFiles;
import com.jrs.appraisalconnect.model.Organization;
import com.jrs.appraisalconnect.model.User;
import com.jrs.appraisalconnect.service.OrderFilesService;
import com.jrs.appraisalconnect.service.OrderService;
import com.jrs.appraisalconnect.service.OrganizationService;
import com.jrs.appraisalconnect.service.UserService;
import com.jrs.appraisalconnect.utils.FileDownloadUtil;
import com.jrs.appraisalconnect.utils.FileUploadResponse;
import com.jrs.appraisalconnect.utils.FileUploadUtil;

@CrossOrigin
@RestController
//@RequestMapping("/api/v1")     ==> commented out because we inserted "server.servlet.context-path=/api/v1" in application prpoerties file
public class MainController {
	
	@Autowired
	private UserService myuserService;

	@Autowired
	private OrganizationService myOrganizationService;

	@Autowired
	OrderFilesService myOrderFilesService;
	
	@Autowired
	private OrderService myOrderService;
	

	
//	@GetMapping("/downloadFile/{fileCode}")
//	public ResponseEntity<?> downloadfile(@PathVariable("fileCode") String filecode) throws IOException {
//		String fileName = "";
//		OrderFiles myOrderFile = myOrderFilesService.getFileInfo(filecode);
//
//		fileName = myOrderFile.getFilFileName();
//
//
//		FileDownloadUtil downloadUtil = new FileDownloadUtil();
//
//		Resource resource = null;
//		try {
//			resource = downloadUtil.getFileAsResource(fileName);
//		} catch (IOException e) {
//			return ResponseEntity.internalServerError().build();
//
//		}
//
//		if ( resource == null ) {
//			return new ResponseEntity<>("File Not Found",  HttpStatus.NOT_FOUND);
//		}
//
//		String contentType = "application/octet-stream";
//		String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";
//
//		return ResponseEntity.ok()
//				.contentType(MediaType.parseMediaType(contentType))
//				.header(HttpHeaders.CONTENT_DISPOSITION, headerValue)
//				.body(resource);
//	}

	
//	@PostMapping("/uploadFile")
//	public ResponseEntity<FileUploadResponse> uploadfile(@RequestParam("file") MultipartFile multipartFile,
//														 @RequestParam("ordertimestamp") String ordertimestamp,
//														 @RequestParam("filetimestamp") String filetimestamp)
//											throws IOException {
//
//
//		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//		long size = multipartFile.getSize();
//
//		fileName = filetimestamp + "_" + fileName;
//		FileUploadUtil.saveFile(fileName, multipartFile);
//
//		FileUploadResponse response = new FileUploadResponse();
//		response.setFileName(fileName);
//		response.setSize(size);
//		response.setDownloadUri("/downloadFile");
//
//		OrderFiles myorderFile = new OrderFiles();
//		myorderFile.setFilOrdId(ordertimestamp);
//		myorderFile.setFilId(filetimestamp);
//		myorderFile.setFilFileName(fileName);
//		myOrderFilesService.saveOrderFiles(myorderFile);
//
//		return new ResponseEntity<>(response, HttpStatus.OK);
//	}
	
	

	
	
	
	@RequestMapping(value="/users", method = RequestMethod.GET)
	//GetMapping("/users")
	//@ResponseBody     ===> ONLY USED IF @Controller is used vs. @RestController
	public List<User> getUsers() {
		return myuserService.getUsers();
	}
	

	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Long id) {
		return myuserService.getSingleUser(id);
	}


	@PostMapping("/user")
	public User saveUser(@RequestBody User myuser) {
		
		return myuserService.saveUser(myuser) ;
	}

	@PutMapping("/user/{id}")
	public User updateUser(@PathVariable("id") Long id, @RequestBody User myuser) {
		myuser.setUsrId(id);
		return myuserService.updateUser(myuser);
	}
	
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		myuserService.deleteUser(id);
	}
	
	
	
	@RequestMapping(value="/organizations", method = RequestMethod.GET)
	public List<Organization> getOrganizations() {
		return myOrganizationService.getOrganizations();
	}
	

	@PostMapping("/organization")
	public Organization saveOrganization(@RequestBody Organization myOrganization) {
		
		return myOrganizationService.saveOrganization(myOrganization);
	}

	
	
	
}
