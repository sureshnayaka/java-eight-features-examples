package com.javaeight.features.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee {

	private Integer id;
	private String name;
	private String department;
	private Integer salary;
}
