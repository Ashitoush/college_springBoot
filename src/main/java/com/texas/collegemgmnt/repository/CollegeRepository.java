package com.texas.collegemgmnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.texas.collegemgmnt.models.College;

public interface CollegeRepository extends JpaRepository<College, Long> {
	public College findByCollegeId(Long collegeId);
}
