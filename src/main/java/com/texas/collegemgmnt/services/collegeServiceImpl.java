package com.texas.collegemgmnt.services;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texas.collegemgmnt.models.*;
import com.texas.collegemgmnt.repository.CollegeRepository;

@Service
public class collegeServiceImpl implements CollegeService {
	
	@Autowired
	private CollegeRepository collegeRepository;
	
	@Override
	public List<College> getColleges(){
		return collegeRepository.findAll();
	}
	
	@Override
	public College getCollege(Long collegeId) {
		return collegeRepository.findByCollegeId(collegeId);
	}
	
	@Override
	public String setCollege(College college) {
		collegeRepository.save(college);
		return "Data added successfully";
	}
	
	@Override
	public String deleteCollege(Long collegeId) {
		collegeRepository.deleteById(collegeId);
		return "Data deleted successfully";
	}
	
	@Override
	public College updateCollege(Long collegeId, College college) {
//		if(college.getCollegeContactInfo().getCollegeContactInfoId() != 0 && college.getCollegeId() == collegeId) {
//			collegeRepository.deleteById(collegeId);
//		}
		return collegeRepository.saveAndFlush(college);
//		return collegeRepository.save(college);
	}
	
//	@Override
//	public List<College> getColleges(){
//		return collegeList;
//	}
//	
//	@Override
//	public College getCollege(Long CollegeId) {
//		College college = null;
//		for(College coll : collegeList) {
//			if(coll.getCollegeId() == CollegeId) {
//				college = coll;
//				break;
//			}
//		}
//		return college;
//	}
//	
//	@Override
//	public String setCollege(College college) {
//		collegeList.add(college);
//		return "Data Added Successfully";
//	}
//
//	@Override
//	public String deleteCollege(Long collegeId) {
//		for(College coll : collegeList) {
//			if(coll.getCollegeId() == collegeId) {
//				collegeList.remove(coll);
//				break;
//			}
//		}
//		return "Data Deleted";
//	}
//
//	@Override
//	public College updateCollege(Long collegeId, College college) {
//		College resCollege = null;
//		for(College coll : collegeList) {
//			if(coll.getCollegeId() == collegeId) {
//				collegeList.remove(coll);
//				collegeList.add(college);
//				resCollege = college;
//				break;
//			}
//		}
//		return resCollege;
//	}
}
