package com.example.demo.bindings;

import java.time.LocalDate;

public class User {

	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", emailId=" + emailId + ", mobileNumber=" + mobileNumber + ", gender="
				+ gender + ", DOB=" + DOB + ", ssn=" + ssn + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String fullName, String emailId, Long mobileNumber, String gender, LocalDate dOB, Long ssn) {
		super();
		this.fullName = fullName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		DOB = dOB;
		this.ssn = ssn;
	}

	private String fullName;
	private String emailId;
	private Long mobileNumber;
	private String gender;
	private LocalDate DOB;
	private Long ssn;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate dOB) {
		DOB = dOB;
	}

	public Long getSsn() {
		return ssn;
	}

	public void setSsn(Long ssn) {
		this.ssn = ssn;
	}

}
