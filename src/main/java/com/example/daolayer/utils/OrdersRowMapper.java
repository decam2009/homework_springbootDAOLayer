package com.example.daolayer.utils;

import com.example.daolayer.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersRowMapper implements RowMapper<Order> {
    private final String PRODUCT_NAME = "product_name";
    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setProductName(rs.getString(PRODUCT_NAME));
        return order;
    }
}
