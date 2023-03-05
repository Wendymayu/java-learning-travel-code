package com.wendy.basic.jdbc;

import lombok.extern.slf4j.Slf4j;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/3/5 21:42
 * @Version 1.0
 */
@Slf4j
public class BlogService {
    private static final String QUERY_ALL_BLOG_SQL = "select * from blog";

    private static final int[] QUERY_ALL_BLOG_TYPES = new int[]{
            Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR,
            Types.DATE, Types.VARCHAR, Types.DATE, Types.VARCHAR
    };

    private static final DBService dbService = DBService.getInstance();

    public List<Object> queryAllBlog(int offset, int size) {
        List<Object> params = new ArrayList<>();
        List<Map<String, Object>> maps = dbService.select(QUERY_ALL_BLOG_SQL, QUERY_ALL_BLOG_TYPES, params);
        log.info("There are {} element", maps.size());
        return null;
    }
}
