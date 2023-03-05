package com.wendy.poi.service;

import com.wendy.poi.mapper.CustomerMapper;
import com.wendy.poi.pojo.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName CustomerServiceImpl
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/8 0:08
 * @Version 1.0
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> queryAllCustomers() {
        return customerMapper.queryAllCustomers();
    }
}
