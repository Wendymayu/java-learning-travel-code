package com.wendy.poi.service;

import com.wendy.poi.pojo.Customer;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/8 0:06
 * @Version 1.0
 */
public interface CustomerService {
    List<Customer> queryAllCustomers();
}