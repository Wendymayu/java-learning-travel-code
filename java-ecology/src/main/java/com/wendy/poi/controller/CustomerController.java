package com.wendy.poi.controller;

import com.wendy.poi.CustomerExcelUtil;
import com.wendy.poi.pojo.Customer;
import com.wendy.poi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/4 21:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/export")
    public void export(){
        List<Customer> customers = customerService.queryAllCustomers();
        CustomerExcelUtil.exportExcel(customers);
    }

    @GetMapping("/customers")
    public List<Customer> getCustomersFromExcel() throws IOException {
        return CustomerExcelUtil.customersFromExcel();
    }
}
