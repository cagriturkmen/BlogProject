package com.bilgeadam.main;

import java.util.ArrayList;

import com.bilgeadam.dao.AdminDao;
import com.bilgeadam.dto.AdminDto;

public class DataBlog {
	
	public static void main(String[] args) {
		// ekleme
		// AdminDto adminDto = new AdminDto();
		// adminDto.setName("Çağrı");
		// adminDto.setSurname("Türkmen");
		// adminDto.setTelNumber("5454545454");
		// adminDto.setEmailAddress("cagri@turkmen.com");
		// adminDto.setPassword("1234şifre");
		//
		// AdminDao adminDao = new AdminDao();
		// adminDao.insert(adminDto);
		
		// güncelleme
		// AdminDto adminDto2 = new AdminDto();
		// adminDto2.setName("Çağrı");
		// adminDto2.setSurname("Türkmen");
		// adminDto2.setTelNumber("5454545454");
		// adminDto2.setEmailAddress("cagri@turkmen.com");
		// adminDto2.setPassword("1234şifre6789");
		// adminDto2.setId(2);
		//
		// AdminDao adminDao2 = new AdminDao();
		// adminDao2.update(adminDto2);
		
		// silme
		// AdminDto adminDto3 = new AdminDto();
		// adminDto3.setId(4);
		//
		// AdminDao adminDao3 = new AdminDao();
		// adminDao3.delete(adminDto3);
		
		AdminDao adminDao4 = new AdminDao();
		
		ArrayList<AdminDto> temp = adminDao4.list();
		temp.forEach(System.out::println);
	}
}