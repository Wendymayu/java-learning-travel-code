package com.wendy.basic.io;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2021/9/27 7:51
 * @Version 1.0
 */
@AllArgsConstructor
@Data
public class Student implements Serializable{
    private String name;

    private int age;
}
