package com.javaeight.features.usersDAO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.javaeight.features.model.EkartEmployees;
import com.javaeight.features.model.Employee;
import com.javaeight.features.model.Users;

public class UsersData {
	
		
		public List<Users> getUsers() {
		    return Stream.of(
		            new Users("Surya", "Rathan", "Hyderabad", 28, false),
		            new Users("Vignesh", "Nivas", "Chennai", 38, true),
		            new Users("Arun", "Kumar", "Kerala", 38, true),
		            new Users("Akhil", "Rathan", "Hyderabad", 48, false),
		            new Users("Surya", "Nayak", "Hyderabad", 28, false)
		    ).collect(Collectors.toList());
		}
		
		
	public static List<Employee> getEmployes() {
		    return Stream.of(
		            new Employee(116,"Surya", "CHILI Publish", 1100000),
		            new Employee(143,"Vignesh", "Monster", 2100000),
		            new Employee(118,"Alex", "Solution", 3100000),
		            new Employee(112,"Mohana", "Dinsey", 700000),
		            new Employee(146,"Arun", "CSM", 2600000)
		    ).collect(Collectors.toList());
		}

	public static List<EkartEmployees> getAllEkartEmployees() {
	    return Stream.of(
	            new EkartEmployees("Surya", "suryaRathan005@gmail.com",Arrays.asList("889737227327","122193248328")),
	            new EkartEmployees("Raki", "raki@gmail.com",Arrays.asList("33393093303","93393229220")),
	            new EkartEmployees("Akhil", "akhil@gmail.com",Arrays.asList("0912193229","6549430330")),
	            new EkartEmployees("Ravi", "ravi@gmail.com",Arrays.asList("21344294","833292294"))

	    ).collect(Collectors.toList());
	}


}
