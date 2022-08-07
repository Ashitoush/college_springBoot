package com.texas.collegemgmnt.services;

import java.util.List;

import com.texas.collegemgmnt.models.*;

public interface CollegeService {
	
	public List<College> getColleges();
	
	public College getCollege(Long collegeId);

	public String setCollege(College college);
	
	public String deleteCollege(Long collegeId);
	
	public College updateCollege(Long collegeId, College college);
}
