package com.bilgeadam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bilgeadam.dto.AdminDto;

public class AdminDao implements IDAOImplements<AdminDto> {
	
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
	
	@Override
	public void insert(AdminDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "insert into admin_blog (admin_name,admin_surname,admin_tel_number,admin_email_address,admin_password) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getSurname());
			preparedStatement.setString(3, t.getTelNumber());
			preparedStatement.setString(4, t.getEmailAddress());
			preparedStatement.setString(5, t.getPassword());
			preparedStatement.executeUpdate();
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(AdminDao.class + "Ekleme başarılı");
			} else {
				System.out.println("Ekleme sırasında bir hata meydana geldi");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + "AdminDao Hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(AdminDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "update admin_blog set admin_name=?,admin_surname=?,admin_tel_number=?,admin_email_address=?,admin_password=? where admin_id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getSurname());
			preparedStatement.setString(3, t.getTelNumber());
			preparedStatement.setString(4, t.getEmailAddress());
			preparedStatement.setString(5, t.getPassword());
			preparedStatement.setInt(6, t.getId());
			preparedStatement.executeUpdate();
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(AdminDao.class + "Günceleme başarılı");
			} else {
				System.out.println("Güncelleme sırasında bir hata meydana geldi");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + "AdminDao Hata meydana geldi");
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(AdminDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "delete from admin_blog where admin_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(AdminDao.class + "Silme başarılı");
			} else {
				System.out.println("Silme sırasında bir hata meydana geldi");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "AdminDao delete işleminde hata meydana geldi");
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<AdminDto> list() {
		ArrayList<AdminDto> list2 = new ArrayList<AdminDto>();
		AdminDto adminDto;
		try (Connection connection = getInterfaceConnection()) {
			String sql = "select *  from admin_blog";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				adminDto = new AdminDto();
				adminDto.setId(resultSet.getInt("admin_id"));
				adminDto.setEmailAddress(resultSet.getString("admin_name"));
				adminDto.setName(resultSet.getString("admin_name"));
				adminDto.setPassword(resultSet.getString("admin_password"));
				adminDto.setSurname(resultSet.getString("admin_surname"));
				adminDto.setCreateDate(resultSet.getDate("created_date"));
				adminDto.setRegisterNumberofRecords(resultSet.getInt("admin_number_of_records"));
				adminDto.setTelNumber(resultSet.getString("admin_tel_number"));
				list2.add(adminDto);
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "AdminDao listeleme işleminde hata meydana geldi");
			e.printStackTrace();
		}
		return list2;
	}
	
}
