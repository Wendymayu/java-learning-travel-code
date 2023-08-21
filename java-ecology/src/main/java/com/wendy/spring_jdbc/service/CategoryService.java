package com.wendy.spring_jdbc.service;

import com.wendy.spring_jdbc.dao.CategoryRepository;
import com.wendy.spring_jdbc.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/10 12:39
 * @Version 1.0
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categaryRepository;

    public Iterable<Category> findAll() {
        return categaryRepository.findAll();
    }

    public Category findOne(int id) {
        return categaryRepository.findOne(id);
    }
}
