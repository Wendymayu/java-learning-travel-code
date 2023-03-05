package com.wendy.spring_jdbc.dao;

import com.wendy.jpa.pojo.JpaCategory;
import com.wendy.spring_jdbc.pojo.Category;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/10 12:24
 * @Version 1.0
 */
public interface CategoryRepository {
    Iterable<Category> findAll();

    Category findOne(int id);

    void save(JpaCategory category);
}
