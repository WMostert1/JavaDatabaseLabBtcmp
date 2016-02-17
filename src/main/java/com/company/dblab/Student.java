package com.company.dblab;

public class Student {
	private String name;
	private int age;
	private String city;
	private int id;
	
	public Student(String name,int age, String city, int id) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.id = id;
	}
	
	public boolean isEqual(String name, int id, int age, String city){
		return this.name.equals(name) && this.id == id
				&& this.age == age && this.city.equals(city);	
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
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
}
