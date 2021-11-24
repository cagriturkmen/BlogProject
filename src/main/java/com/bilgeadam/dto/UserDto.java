package com.bilgeadam.dto;

import java.io.Serializable;
import java.sql.Date;

public class UserDto extends CommonProperty implements Serializable {
	
	private static final long serialVersionUID = -6909316477482845301L;
	
	private boolean isActive;
	private String HesCodes;
	
	public UserDto() {
		this.isActive = true;
	}
	
	public UserDto(int id, String name, String surname, String telNumber, String emailAddress, String password,
			Date createDate) {
		super(id, name, surname, telNumber, emailAddress, password, createDate);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isActive() {
		return isActive;
	}
	
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public String getHesCodes() {
		return HesCodes;
	}
	
	public void setHesCodes(String hesCodes) {
		HesCodes = hesCodes;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
