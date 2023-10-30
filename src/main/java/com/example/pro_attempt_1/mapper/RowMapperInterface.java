package com.example.pro_attempt_1.mapper;

import java.sql.ResultSet;

public interface RowMapperInterface<T> {
    T mapRow(ResultSet r);
}
