package com.company.dblab;

import java.sql.Connection;
import java.util.ArrayList;

public interface IDatabaseManager {
	public Connection getConnection();
	public void create(Student student) throws Exception;
	public ArrayList<Student> read() throws Exception;
	public void update (int id) throws Exception;
	public void delete () throws Exception;
	
}
