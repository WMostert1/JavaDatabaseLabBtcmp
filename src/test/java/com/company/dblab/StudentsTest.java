package com.company.dblab;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.*;
import org.junit.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentsTest {
	
	private IDatabaseManager dbm;
	
	@Before
	public void setUp() throws SQLException{
		Connection c = DriverManager.getConnection("jdbc:derby:c:\\temp\\db");
		dbm = new JDBCDatabaseManager(c);	
	}
	
	@After
	public void tearDown() throws SQLException{
		dbm.getConnection().close();
	}
	
	@Test
	public void testClean() {
		try {
			dbm.delete();
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testInsert(){
		try {
			String [] names = {"Sannie","Wally","Jaun"};
			int [] ages = {4, 58 , 29};
			String [] cities = {"Betlehem", "Witbank", "Danville"};
			for(int i = 0; i < names.length; i++){
				dbm.create(new Student(names[i],ages[i],cities[i],i+1));	
			}

		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testRetrieveData(){
		try{
		ArrayList<Student> studentsList = dbm.read();
		assertNotNull(studentsList);
		assertTrue(!studentsList.isEmpty());
		
		assertTrue(studentsList.get(0).isEqual("Sannie", 1, 4, "Betlehem"));
		assertTrue(studentsList.get(1).isEqual("Wally", 2, 58, "Witbank"));
		assertTrue(studentsList.get(2).isEqual("Jaun", 3, 29, "Danville"));
		}catch(Exception e){
			fail();
		}
		
	}
}
