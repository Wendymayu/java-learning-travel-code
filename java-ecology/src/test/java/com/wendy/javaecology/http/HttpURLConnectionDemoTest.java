package com.wendy.javaecology.http;

import com.wendy.http.java_net.HttpURLConnectionDemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HttpURLConnectionDemoTest {
    @Test
    void getRequest() {
        HttpURLConnectionDemo httpURLConnectionDemo = new HttpURLConnectionDemo();
        String result = httpURLConnectionDemo.translateText("apple", "en", "zh");
        Assertions.assertEquals("苹果", result);
    }
}