package com.texas.collegemgmnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.texas.collegemgmnt.models.College;
import com.texas.collegemgmnt.response.ResponseHandler;
import com.texas.collegemgmnt.services.CollegeService;


@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService;
	
	@Value("${user.texas: Abc}")
	private String userTexas;
	
	@Value("${password.texas: 12567}")
	private String passwordTexas;
	
	
	@GetMapping("/userValue")
	public String userValue() {
		return userTexas + " " + passwordTexas;
	}
	
	@GetMapping("/colleges")
	public ResponseEntity<Object> getColleges() {
				
		try {
			List<College> lstColleges = collegeService.getColleges();
			return ResponseHandler.generateResponse("Successfully retrieve", HttpStatus.OK, lstColleges);
		}
		catch(Exception e) {
			return ResponseHandler.generateResponse("Error", HttpStatus.MULTI_STATUS, null);
		}
		
		
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Version", "1.0");
//		headers.add("ProjectName", "College Management");
//		
//		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(lstColleges);
	}
	
	@GetMapping("/colleges/{collegeId}")
//	public College getCollege(@PathVariable("collegeId") Long collegeId) {
//		return this.collegeService.getCollege(collegeId);
//	}
	public ResponseEntity<Object> getCollege(@PathVariable("collegeId") Long collegeId) {
		try {
			College col = collegeService.getCollege(collegeId);
			return ResponseHandler.generateResponse("successfully Retried", HttpStatus.OK, col);
		}
		catch(Exception e) {	
			return ResponseHandler.generateResponse("Error", HttpStatus.MULTI_STATUS, null);
		}
	
	}
	
	@PostMapping("/colleges")
	public ResponseEntity<Object> addCollege(@RequestBody College college) {
		try {
			String msg = collegeService.setCollege(college);
			return ResponseHandler.generateResponse(msg, HttpStatus.CREATED, college);
		}catch(Exception e) {
			return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
		}
		
	}
	
	@DeleteMapping("/colleges")
	public ResponseEntity<Object> deleteCollege(@RequestParam("collegeId")String collegeId) {
		try{
			String msg = collegeService.deleteCollege(Long.parseLong(collegeId));
			return ResponseHandler.generateResponse(msg, HttpStatus.OK, collegeId);
		}catch(Exception e) {
			return ResponseHandler.generateResponse("Error", HttpStatus.MULTI_STATUS, null); 
		}
	}
	
	@PutMapping("/colleges/{collegeId}")
	public ResponseEntity<Object> updateCollege(@PathVariable("collegeId") String collegeId, @RequestBody College college) {
		try{
			College col = collegeService.updateCollege(Long.parseLong(collegeId), college);
			return ResponseHandler.generateResponse("Successfully Updated", HttpStatus.OK, col);
		}
		catch(Exception e) {
			return ResponseHandler.generateResponse("Error", HttpStatus.MULTI_STATUS, null);
		}
	}
	
}
