package com.example.pro_attempt_1.services;

import com.example.pro_attempt_1.mapper.impl.userMapper;
import com.example.pro_attempt_1.models.User;
import com.example.pro_attempt_1.queryExecution.generalDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class userService extends generalDB<User> {
    public User findByUserNameAndPassword(String userName, String password) throws SQLException {
        System.out.println("Finding by username and password");
        String q = "SELECT username FROM users WHERE username = ? AND password = ?";

        List<User> users = query(q, new userMapper(), userName, password);
        return users.isEmpty() ? null : users.get(0);
    }


}
