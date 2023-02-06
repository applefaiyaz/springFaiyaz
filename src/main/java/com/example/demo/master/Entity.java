package com.example.demo.master;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@javax.persistence.Entity
@javax.persistence.Table(name = "ENTITY")
public class Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String fullName;
	private String emailId;
	private Long mobileNumber;
	private String gender;
	private LocalDate DOB;
	private Long ssn;
	private String password;
	private String activeSwitch;
	private LocalDate createLocalDate;
	private LocalDate updatedLocalDate;
	private String createdBy;
	private String updatedBy;

	public Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entity(Integer userId, String fullName, String emailId, Long mobileNumber, String gender, LocalDate dOB,
			Long ssn, String password, String activeSwitch, LocalDate createLocalDate, LocalDate updatedLocalDate,
			String createdBy, String updatedBy) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.mobileNumber = mobileNumber;
		this.gender = gender;
		DOB = dOB;
		this.ssn = ssn;
		this.password = password;
		this.activeSwitch = activeSwitch;
		this.createLocalDate = createLocalDate;
		this.updatedLocalDate = updatedLocalDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActiveSwitch() {
		return activeSwitch;
	}

	public void setActiveSwitch(String activeSwitch) {
		this.activeSwitch = activeSwitch;
	}

	public LocalDate getCreateLocalDate() {
		return createLocalDate;
	}

	public void setCreateLocalDate(LocalDate createLocalDate) {
		this.createLocalDate = createLocalDate;
	}

	public LocalDate getUpdatedLocalDate() {
		return updatedLocalDate;
	}

	public void setUpdatedLocalDate(LocalDate updatedLocalDate) {
		this.updatedLocalDate = updatedLocalDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "Entity [userId=" + userId + ", fullName=" + fullName + ", emailId=" + emailId + ", mobileNumber="
				+ mobileNumber + ", gender=" + gender + ", DOB=" + DOB + ", ssn=" + ssn + ", password=" + password
				+ ", activeSwitch=" + activeSwitch + ", createLocalDate=" + createLocalDate + ", updatedLocalDate="
				+ updatedLocalDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + "]";
	}

}
