package com.rainier.gc.system.gc.dto;

import java.util.Date;

import com.rainier.gc.system.gc.model.StatusEnum;

public class UserResponse {
	
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String mobileNumber;
	private StatusEnum status;
	private String emailAddress;
	private String responsMessage;
	
	
	public UserResponse() {
		super();
	}
	public UserResponse(Long id, String firstName, String lastName, Date dateOfBirth, String mobileNumber,
			StatusEnum status, String emailAddress, String responsMessage) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.mobileNumber = mobileNumber;
		this.status = status;
		this.emailAddress = emailAddress;
		this.responsMessage = responsMessage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public StatusEnum getStatus() {
		return status;
	}
	public void setStatus(StatusEnum status) {
		this.status = status;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getResponsMessage() {
		return responsMessage;
	}
	public void setResponsMessage(String responsMessage) {
		this.responsMessage = responsMessage;
	}
	
}
