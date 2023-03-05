package com.wendy.elasticsearch.utils;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/5 13:42
 * @Version 1.0
 */
public class ESUtils {
    @Autowired
    private RestHighLevelClient client;

}
