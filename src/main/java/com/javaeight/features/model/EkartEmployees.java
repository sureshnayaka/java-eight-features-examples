package com.javaeight.features.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class EkartEmployees {

	
	private String name;
	private String email;
	private List<String> phoneNumbers;
}
