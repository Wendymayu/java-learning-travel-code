package com.wendy.http;

import com.wendy.http.RestTemplateDemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class RestTemplateDemoTest {
    @Resource
    private RestTemplateDemo restTemplateDemo;

    @Test
    private void translateText_test() {
        String res = restTemplateDemo.translateText("apple", "en", "zh");
        Assertions.assertEquals("苹果", res);
    }
}