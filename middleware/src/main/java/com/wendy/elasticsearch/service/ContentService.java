package com.wendy.elasticsearch.service;

import com.wendy.elasticsearch.dao.CrawlerDao;
import com.wendy.elasticsearch.entity.Content;
import com.wendy.elasticsearch.utils.JSONUtils;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/5 22:24
 * @Version 1.0
 */
@Service
public class ContentService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @Autowired
    private CrawlerDao crawlerDao;

    // 1、解析数据存入es
    public boolean parseContent(String keywords) throws Exception {
        // 解析查询出来的数据
        List<Content> contents = this.crawlerDao.parseJD(keywords);
        // 封装数据到索引库中！
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout(TimeValue.timeValueMinutes(2));
        bulkRequest.timeout("2m");
        for (int i = 0; i < contents.size(); i++) {
            bulkRequest.add(new IndexRequest("jd_goods").source(JSONUtils.objectToString(contents.get(i)), XContentType.JSON));
        }
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        return !bulkResponse.hasFailures();
    }

    // 2、实现搜索功能，带分页处理
    public List<Map<String, Object>> searchContentPage(String keyword, int pageNo, int pageSize) throws IOException {
        // 基本的参数判断！
        if (pageNo <= 1) {
            pageNo = 1;
        }
        // 基本的条件搜索
        SearchRequest searchRequest = new SearchRequest("jd_goods");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        // 分页
        sourceBuilder.from(pageNo);
        sourceBuilder.size(pageSize);
        // 精准匹配 QueryBuilders 根据自己要求配置查询条件即可！
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("title", keyword);
        sourceBuilder.query(termQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        // 搜索
        searchRequest.source(sourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        // 解析结果！
        List<Map<String, Object>> list = new ArrayList<>();
        for (SearchHit documentFields : response.getHits().getHits()) {
            list.add(documentFields.getSourceAsMap());
        }
        return list;
    }
}
