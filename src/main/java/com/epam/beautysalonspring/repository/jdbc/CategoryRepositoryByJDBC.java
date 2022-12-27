package com.epam.beautysalonspring.repository.jdbc;

import com.epam.beautysalonspring.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CategoryRepositoryByJDBC {
    private final JdbcTemplate jdbcTemplate;
    private final CategoryRowMapper rowMapper;


    public Set<Category> getAllCategories(){
        return new HashSet<>(jdbcTemplate.query("SELECT * FROM category", rowMapper));
    }

    @Component
    private static class CategoryRowMapper implements RowMapper<Category> {

        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category();
            category.setId(rs.getLong("id"));
            category.setName(rs.getString("name"));
            return category;
        }
    }
}
