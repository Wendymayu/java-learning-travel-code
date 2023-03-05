package com.wendy.spring_jdbc.dao;

import com.wendy.jpa.pojo.JpaCategory;
import com.wendy.spring_jdbc.pojo.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/10 12:16
 * @Version 1.0
 */
@Repository
public class CategaryRepositoryImpl implements CategoryRepository {
    @Resource
    private JdbcTemplate jdbc;

    @Override
    public Iterable<Category> findAll() {
        return jdbc.query("select * from ms_category", this::mapRowToCategory);
    }

    @Override
    public Category findOne(int id) {
        return jdbc.queryForObject("select id, avatar, category_name, description from ms_category where id=?",
                this::mapRowToCategory, id);
    }

    @Override
    public void save(JpaCategory category) {
    }

    private Category mapRowToCategory(ResultSet rs, int rowNum) throws SQLException {
        return new Category(rs.getInt("id"), rs.getString("avatar"),
                rs.getString("category_name"), rs.getString("description"));
    }
}
