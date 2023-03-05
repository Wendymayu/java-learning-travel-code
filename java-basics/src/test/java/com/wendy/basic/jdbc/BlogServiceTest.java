package com.wendy.basic.jdbc;

import org.junit.jupiter.api.Test;

class BlogServiceTest {
    @Test
    void test_querryAllBlog_when_0_10() {
        BlogService blogService = new BlogService();
        blogService.queryAllBlog(0, 10);
    }

}