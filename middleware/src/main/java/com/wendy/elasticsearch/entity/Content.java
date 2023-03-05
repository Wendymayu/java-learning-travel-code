package com.wendy.elasticsearch.entity;

import lombok.Data;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/5 21:38
 * @Version 1.0
 */
@Data
public class Content {
    private String title; // 商品名称

    private String price; // 商品价格

    private String img; // 商品封面
}
