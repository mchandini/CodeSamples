package com.sampleCode;

import java.util.Date;

public class Person {

	private String firstName;
	private String lastName;
	private String dob;
	private String phoneNumber;
	private String[] hobbies;
	private String sex;
	private Date modifiedAt;

	public Person(String firstName, String lastName, String dob, String phoneNumber, String[] hobbies,
			String sex, Date modifiedAt) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.phoneNumber = phoneNumber;
		this.hobbies = hobbies;
		this.sex = sex;
		this.modifiedAt = modifiedAt;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String[] getHobbies() {
		return hobbies;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	public String toString() {
		return ("Name: "+this.firstName+" "+this.lastName+", DOB: "+this.dob+
				", Phone: "+this.phoneNumber+", Hobbies: "+hobbiesToString(this.hobbies)
				+", Sex: "+this.sex+", lastModifiedAt: "+this.modifiedAt+"\n");
	}
	
	public static String hobbiesToString(String[] hobbiesArray) {
		String hobbies = "";
		for (String hobby : hobbiesArray) {
			hobbies +=" "+hobby;
		}
		
		return hobbies;		
	}
}
