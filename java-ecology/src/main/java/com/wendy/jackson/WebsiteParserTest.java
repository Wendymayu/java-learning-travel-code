package com.wendy.jackson;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/3/1 23:43
 * @Version 1.0
 */
public class WebsiteParserTest {
    public static void main(String[] args) {
        WebsiteParser parser = new WebsiteParser();
        List<Website> websiteList = parser.getWebsiteList();
        for (Website website : websiteList) {
            System.out.println(website);
        }
    }
}
