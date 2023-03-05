package com.wendy.elasticsearch;

import com.wendy.elasticsearch.dao.CrawlerDao;
import com.wendy.elasticsearch.entity.Content;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/5 21:43
 * @Version 1.0
 */
@SpringBootTest
public class CrawlerTest {
    @Autowired
    private CrawlerDao crawlerDao;

    @Test
    void testParseJD() throws Exception {
        List<Content> contents = crawlerDao.parseJD("Java");
        contents.forEach(System.out::println);
    }
}
