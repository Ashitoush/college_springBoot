package com.texas.collegemgmnt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.texas.collegemgmnt.models.*;

@Service
public class collegeServiceImpl implements CollegeService {
	
	static List<College> collegeList = new ArrayList<College>();
	static {
		College college = new College();
		college.setCollegeId(1L);
		college.setCollegeName("Texas International College");
		college.setCollegePhone("1387438975");
		college.setCollegeEmail("texas@gmail.com");
		collegeList.add(college);
		
		college = new College();
		college.setCollegeId(2L);
		college.setCollegeName("Orchid International College");
		college.setCollegePhone("3543438975");
		college.setCollegeEmail("orchid@gmail.com");
		collegeList.add(college);
	}
	
	@Override
	public List<College> getColleges(){
		return collegeList;
	}
	
	@Override
	public College getCollege(Long CollegeId) {
		College college = null;
		for(College coll : collegeList) {
			if(coll.getCollegeId() == CollegeId) {
				college = coll;
				break;
			}
		}
		return college;
	}
}
