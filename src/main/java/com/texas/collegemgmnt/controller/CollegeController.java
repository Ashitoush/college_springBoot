package com.texas.collegemgmnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.texas.collegemgmnt.models.College;
import com.texas.collegemgmnt.services.CollegeService;


@RestController
public class CollegeController {
	
	@Autowired
	private CollegeService collegeService;
	
	@GetMapping("/colleges")
	public List<College> getColleges() {
		return this.collegeService.getColleges();
	}
	
	@GetMapping("/colleges/{collegeId}")
	public College getCollege(@PathVariable("collegeId") Long collegeId) {
		return this.collegeService.getCollege(collegeId);
	}
	
	@PostMapping("/colleges")
	public String addCollege() {
		return "Added";
	}
}
