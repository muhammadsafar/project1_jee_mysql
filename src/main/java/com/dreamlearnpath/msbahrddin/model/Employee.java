package com.dreamlearnpath.msbahrddin.model;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String nip;
	private int age;
	private boolean isActive;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String nip, int age, boolean isActive) {
		super();
		this.name = name;
		this.nip = nip;
		this.age = age;
		this.isActive = isActive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
