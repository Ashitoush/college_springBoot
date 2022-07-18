package com.texas.collegemgmnt.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class College {
	private long collegeId;
	private String collegeName;
	private String collegePhone;
	private String collegeEmail;
}
