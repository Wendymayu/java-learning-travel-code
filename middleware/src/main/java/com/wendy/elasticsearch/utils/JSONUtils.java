package com.wendy.elasticsearch.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/5 15:32
 * @Version 1.0
 */
public class JSONUtils {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String objectToString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}
