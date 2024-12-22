package com.clientecrud.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.clientecrud.model.Cliente;

@Repository
public class ClienteJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cliente> findAll() {
        String sql = "SELECT * FROM cliente";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Cliente cliente = new Cliente();
            cliente.setId(rs.getLong("id"));
            cliente.setNome(rs.getString("nome"));
            cliente.setEmail(rs.getString("email"));
            return cliente;
        });
    }
}
