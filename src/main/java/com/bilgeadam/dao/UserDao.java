package com.bilgeadam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bilgeadam.dto.UserDto;

public class UserDao implements IDAOImplements<UserDto> {
	
	@Override
	public void insert(UserDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "insert into user_blog (user_name,user_surname,user_tel_number,user_email_address,user_password) values (?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, t.getName());
			preparedStatement.setString(2, t.getSurname());
			preparedStatement.setString(3, t.getTelNumber());
			preparedStatement.setString(4, t.getEmailAddress());
			preparedStatement.setString(5, t.getPassword());
			preparedStatement.executeUpdate();
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(UserDao.class + "Ekleme başarılı");
			} else {
				System.out.println("Ekleme sırasında bir hata meydana geldi");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + "UserDao Hata meydana geldi");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(UserDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "update user_blog set user_name=?,user_surname=?,user_tel_number=?,user_email_address=?,user_password=? where user_id=?";
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
				System.out.println(UserDao.class + "Günceleme başarılı");
			} else {
				System.out.println("Güncelleme sırasında bir hata meydana geldi");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage() + "UserDao Hata meydana geldi");
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(UserDto t) {
		try (Connection connection = getInterfaceConnection()) {
			String sql = "delete from user_blog where user_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, t.getId());
			int rowEffected = preparedStatement.executeUpdate();
			if (rowEffected > 0) {
				System.out.println(UserDao.class + "Silme başarılı");
			} else {
				System.out.println("Silme sırasında bir hata meydana geldi");
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "UserDao delete işleminde hata meydana geldi");
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<UserDto> list() {
		ArrayList<UserDto> list2 = new ArrayList<UserDto>();
		UserDto userDto;
		try (Connection connection = getInterfaceConnection()) {
			String sql = "select *  from user_blog";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userDto = new UserDto();
				userDto.setId(resultSet.getInt("user_id"));
				userDto.setEmailAddress(resultSet.getString("user_name"));
				userDto.setName(resultSet.getString("user_name"));
				userDto.setPassword(resultSet.getString("user_password"));
				userDto.setSurname(resultSet.getString("user_surname"));
				userDto.setCreateDate(resultSet.getDate("created_date"));
				userDto.setTelNumber(resultSet.getString("user_tel_number"));
				list2.add(userDto);
				
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "UserDao listeleme işleminde hata meydana geldi");
			e.printStackTrace();
		}
		return list2;
	}
	
}
