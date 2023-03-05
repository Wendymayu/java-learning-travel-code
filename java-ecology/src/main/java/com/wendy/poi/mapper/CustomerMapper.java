package com.wendy.poi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wendy.poi.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/7/8 0:09
 * @Version 1.0
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
    List<Customer> queryAllCustomers();
}