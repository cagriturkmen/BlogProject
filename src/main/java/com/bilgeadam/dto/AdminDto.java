package com.bilgeadam.dto;

import java.sql.Date;

// DTO: Data Transfer Object

public class AdminDto extends CommonProperty {
	
	private static final long serialVersionUID = -6214174547778684454L;
	
	private int registerNumberofRecords;
	
	public AdminDto() {
		
	}
	
	public AdminDto(int id, String name, String surname, String telNumber, String emailAddress, String password,
			Date createDate) {
		super(id, name, surname, telNumber, emailAddress, password, createDate);
		
	}
	
	public int getRegisterNumberofRecords() {
		return registerNumberofRecords;
	}
	
	public void setRegisterNumberofRecords(int registerNumberofRecords) {
		this.registerNumberofRecords = registerNumberofRecords;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
