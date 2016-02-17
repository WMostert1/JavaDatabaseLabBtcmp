package com.company.dblab;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DatabaseManager {

	private Connection connection;
	
	public DatabaseManager(Connection connection) throws SQLException {
		this.connection = connection;
	}
	
	public Connection getConnection(){
		return this.connection;
	}
	
	public void clean() throws Exception{
		 Statement stmt = connection.createStatement();
         stmt.executeUpdate("delete from students");
	}
	
	public void populateStudents() throws Exception{
		PreparedStatement stmt = connection.prepareStatement("insert into students (id, name, age, city) values (?, ?, ?, ?)");
		
		String [] names = {"Sannie","Wally","Jaun"};
		int [] ages = {4, 58 , 29};
		String [] cities = {"Betlehem", "Witbank", "Danville"};
	
		for(int i = 0; i < names.length; i++){
			stmt.setInt(1, i+1);
			stmt.setString(2, names[i]);
			stmt.setInt(3, ages[i]);
			stmt.setString(4, cities[i]);
			stmt.executeUpdate();
		}

	}
	
	public ArrayList<Student> getStudents() throws Exception{
		Statement s = connection.createStatement();
		ResultSet set = s.executeQuery("SELECT * FROM students");
		ArrayList<Student> result = new ArrayList<Student>();
		
		while(set.next())
			result.add(new Student(set.getString("name"),set.getInt("age"),set.getString("city"),set.getInt("id")));
		
		return result;
	}
	
}
