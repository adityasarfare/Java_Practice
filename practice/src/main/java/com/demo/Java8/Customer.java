package com.demo.Java8;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	
	int id ;
	String name;
	String city;
	List<String> phone;
	
	public Customer(int id, String name, String city, List<String> phone) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.phone = phone;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getPhone() {
		return phone;
	}

	public void setPhone(List<String> phone) {
		this.phone = phone;
	}
	
	
	
	
}
