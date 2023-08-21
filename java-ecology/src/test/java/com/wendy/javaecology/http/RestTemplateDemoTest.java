package com.wendy.javaecology.http;

import com.wendy.http.rest_template.RestTemplateDemo;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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