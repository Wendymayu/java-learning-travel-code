package com.wendy.jpa.service;

import com.wendy.jpa.dao.CategoryRepository;
import com.wendy.jpa.pojo.JpaCategory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/10 15:14
 * @Version 1.0
 */
@Service
public class JpaCategoryService {

    @Resource
    private CategoryRepository categoryRepository;

    public Iterable<JpaCategory> findAll() {
        return categoryRepository.findAll();
    }

    public JpaCategory findOne(String id) {
        Optional<JpaCategory> optional = categoryRepository.findById(id);
        return optional.orElse(null);
    }

    public Iterable<JpaCategory> findByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName4(categoryName);
    }
}
