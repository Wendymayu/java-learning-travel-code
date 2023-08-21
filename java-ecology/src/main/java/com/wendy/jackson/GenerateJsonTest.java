package com.wendy.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/2 19:59
 * @Version 1.0
 */
public class GenerateJsonTest {
    public static final String OUTPUT_JSON = "json/output.json";

    public static void main(String[] args) throws IOException {
        File file = new File("output.json");
        if (!file.exists()) {
            file.createNewFile();
        }
        Website website = new Website();
        website.setId("1");
        website.setZhName("阿里");
        website.setEnName("alibaba");
        website.setOtherService(true);
        website.setUrl("www.alibaba.com");
        ObjectMapper objectMapper = new ObjectMapper();
        // 将对象转为字符串
        String s = objectMapper.writeValueAsString(website);
        System.out.println(s);
        // 将json对象写入文件
        objectMapper.writeValue(file, website);
    }
}
