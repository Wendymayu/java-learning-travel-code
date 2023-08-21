package com.wendy.spring_jdbc.controller;

import com.wendy.spring_jdbc.pojo.Category;
import com.wendy.spring_jdbc.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/10 11:33
 * @Version 1.0
 */
@RestController
@RequestMapping("category")
public class CategotyController {

    @Resource
    private CategoryService categoryService;

    @GetMapping("/{id}")
    public Category findOne(@PathVariable("id") int id) {
        return categoryService.findOne(id);
    }

    @GetMapping("/all")
    public Iterable<Category> findAll() {
        return categoryService.findAll();
    }
}
