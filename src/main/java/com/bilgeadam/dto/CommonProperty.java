package com.bilgeadam.dto;

import java.io.Serializable;
import java.sql.Date;

public class CommonProperty implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3192737203606727158L;
	private int id;
	private String name;
	private String surname;
	private String telNumber;
	private String emailAddress;
	private String password;
	private Date createDate;
	
	public CommonProperty() {
		
	}
	
	public CommonProperty(int id, String name, String surname, String telNumber, String emailAddress, String password,
			Date createDate) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.telNumber = telNumber;
		this.emailAddress = emailAddress;
		this.password = password;
		this.createDate = createDate;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getTelNumber() {
		return telNumber;
	}
	
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "CommonProperty [id=" + id + ", name=" + name + ", surname=" + surname + ", telNumber=" + telNumber
				+ ", emailAddress=" + emailAddress + ", password=" + password + ", createDate=" + createDate + "]";
	}
	
}
