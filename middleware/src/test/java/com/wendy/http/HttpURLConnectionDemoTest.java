package com.wendy.http;

import com.wendy.http.HttpURLConnectionDemo;
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