package com.wendy.spring_jdbc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/7/10 12:14
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class Category {
    private int id;

    private String avatar;

    private String categaryName;

    private String description;
}
