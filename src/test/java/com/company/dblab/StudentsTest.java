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
	
	private DatabaseManager dbm;
	
	@Before
	public void setUp() throws SQLException{
		Connection c = DriverManager.getConnection("jdbc:derby:c:\\temp\\db");
		dbm = new DatabaseManager(c);	
	}
	
	@After
	public void tearDown() throws SQLException{
		dbm.getConnection().close();
	}
	
	@Test
	public void testClean() {
		try {
			dbm.clean();
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testInsert(){
		try {
			dbm.populateStudents();	
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void testRetrieveData(){
		try{
		ArrayList<Student> studentsList = dbm.getStudents();
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
