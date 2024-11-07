package com.javaeight.features.serviceImpl;

import java.util.List;
import java.util.Collections; // Import for emptyList()

import org.springframework.stereotype.Service;

import com.javaeight.features.model.Users;
import com.javaeight.features.service.UsersInterface;
import com.javaeight.features.usersDAO.UsersData;

@Service
public class UsersService implements UsersInterface {

    private final UsersData usersData;

    public UsersService(UsersData usersData) {
        this.usersData = usersData;
    }

    public UsersService() {
		this.usersData = new UsersData();
	}

    @Override
    public List<Users> getAllusers() {
        try {
            List<Users> users = usersData.getUsers();
            Collections.sort(users, (u1, u2) -> u1.getFirstName().compareToIgnoreCase(u2.getFirstName()));
            return users;
        } catch (Exception e) {
            System.out.println("Oops, something went wrong while fetching users: " + e.getMessage());
            return Collections.emptyList(); // Return an empty list in case of error
        }
    }

}
