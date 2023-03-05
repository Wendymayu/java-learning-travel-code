package com.wendy.poi.pojo;

import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/4 20:40
 * @Version 1.0
 */
@Data
public class Customer {
    private Integer custId;

    private String custName;

    private String custAddress;

    private String custCity;

    private String custState;

    private String custCountry;

    private String custZip;

    //顾客联系名
    private String custContact;

    private String custEmail;
}