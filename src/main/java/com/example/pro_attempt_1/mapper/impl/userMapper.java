package com.example.pro_attempt_1.mapper.impl;

import com.example.pro_attempt_1.mapper.RowMapperInterface;
import com.example.pro_attempt_1.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class userMapper implements RowMapperInterface<User>{

    @Override
    public User mapRow(ResultSet resultSet) {
        try {
            User user = new User();
            user.setUsername(resultSet.getString("username").trim());
            return user;
        } catch (SQLException e) {
            return null;
        }
    }
}

