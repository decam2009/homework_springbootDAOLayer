package com.example.daolayer.repository;

import com.example.daolayer.model.Order;
import com.example.daolayer.utils.OrdersRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class OrdersRepositoryImpl implements OrdersRepository {

    private final String QUERY_FILENAME = "query.sql";
    private final NamedParameterJdbcTemplate template;
    private final String sqlScript = read(QUERY_FILENAME);

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> findProductsByCustomerName(String customerName) {
        SqlParameterSource params = new MapSqlParameterSource()
                .addValue("name", customerName);
        return template.query(sqlScript, params, new OrdersRowMapper());
    }
}
