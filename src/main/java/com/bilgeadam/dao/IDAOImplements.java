package com.bilgeadam.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.bilgeadam.utils.DatabaseConnection;

public interface IDAOImplements<T> {
	
	// gövdesiz methodlarımızı yazdık
	public void insert(T t); // insert into tabloAdi() values()
	
	public void update(T t); // update tabloAi() set adi=""
	
	public void delete(T t); // delete from tabloAdi where id = 5
	
	public ArrayList<T> list(); // select
	
	// gövdeli method
	default Connection getInterfaceConnection() {
		return DatabaseConnection.getInstance().getConnection();
		// DatabaseConnection sınıfının getter'ını çağırdık. DatabaseConnection
		// parametresiz constructor'ı private olduğu için new ile connection
		// oluşturamıyoruz.
		// Bu yüzden getinstance diyip getconnectionla bağlantıyı kurabiliyoruz.
	}
	
}
