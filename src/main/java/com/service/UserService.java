package com.service;

import com.domain.Address;
import com.domain.ComplexAddress;
import com.domain.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private HashMap<Long,User> users;

    public UserService() {
        this.users = new HashMap<Long, User>();
    }

    public void addUser(User user) {
        user.setId();
        users.put(user.getDatabaseId(), user);
    }

    public void mapUser(long id, User user) {
        users.put(id, user);
    }

    public User getUser(long databaseId) {
        if (users.containsKey(databaseId)) {
            return users.get(databaseId);
        } else {
            throw new IllegalArgumentException(("Database ID not valid!"));
        }
    }

    public void editFirstName(User user, String firstName) {
        if (user == null || firstName == null) {
            throw new IllegalArgumentException();
        }
        user.getName().setFirst(firstName);
    }

    public void editLastName(User user, String lastName) {
        if(user == null || lastName == null) {
            throw new IllegalArgumentException();
        }
        user.getName().setSecond(lastName);
    }

    public void editEmail(User user, String email) {
        if(user == null || email == null) {
            throw new IllegalArgumentException();
        }
        user.setEmail(email);
    }

    public void editAddress(int databaseId, ComplexAddress address) {
        users.get(databaseId).setAddress(address);
    }

    public void printUser(int databaseId) {
        if(users.containsKey(databaseId)) {
            System.out.println(users.get(databaseId));
        } else {
            throw new IllegalArgumentException("Database ID not valid!");
        }
    }

    public void printUsers() {
        System.out.println("User list: ");
        for (User user : users.values()) {
            System.out.println(user);
        }
        System.out.println("--------------------------");
    }

    public Map<Long, User> getUsers() {
        return users;
    }
}
