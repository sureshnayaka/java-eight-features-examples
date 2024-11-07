package com.javaeight.features.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Users {

	private String firstName;
	private String lastName;
	private String address;
	private int age;
	private boolean isMarriged;
	
	@Override
	public String toString() {
		return "Users [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", age=" + age
				+ ", isMarriged=" + isMarriged + "]";
	}

}
