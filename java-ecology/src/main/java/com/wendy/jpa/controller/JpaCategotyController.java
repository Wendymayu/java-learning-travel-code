package com.wendy.jpa.controller;

import com.wendy.jpa.pojo.JpaCategory;
import com.wendy.jpa.service.JpaCategoryService;
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
@RequestMapping("v2/category")
public class JpaCategotyController {

    @Resource
    private JpaCategoryService jpaCategoryService;

    @GetMapping("/{id}")
    public JpaCategory findOne(@PathVariable("id") String id) {
        return jpaCategoryService.findOne(id);
    }

    @GetMapping("/info/{category_name}")
    public Iterable<JpaCategory> findByCategoryName(@PathVariable("category_name") String categoryName) {
        return jpaCategoryService.findByCategoryName(categoryName);
    }

    @GetMapping("/all")
    public Iterable<JpaCategory> findAll() {
        return jpaCategoryService.findAll();
    }
}
