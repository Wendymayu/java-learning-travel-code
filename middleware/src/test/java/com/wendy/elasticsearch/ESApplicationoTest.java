package com.wendy.elasticsearch;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.wendy.elasticsearch.entity.User;
import com.wendy.elasticsearch.utils.JSONUtils;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.core.TimeValue;
import org.elasticsearch.index.query.AbstractQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/5 13:45
 * @Version 1.0
 */
@SpringBootTest
public class ESApplicationoTest {
    //@Autowired
    //@Qualifier("restHighLevelClient")
    //private RestHighLevelClient client; //如果对象名是自己取的，需要使用 @Qualifier 才能注入RestHighLevelClient

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * create by: wendyMa
     * description: 创建索引
     * create time: 2022/6/5 14:27
     *
     * @return
     */
    @Test
    void testCreateIndex() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest("ma_index");
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }

    /**
     * create by: wendyMa
     * description: 获取索引
     * create time: 2022/6/5 14:27
     *
     * @return
     */
    @Test
    void testExistsIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("ma_index");
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * create by: wendyMa
     * description: 删除索引
     * create time: 2022/6/5 14:32
     *
     * @return
     */
    @Test
    void testDeleteIndexRequest() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("ma_index");
        AcknowledgedResponse response = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(response.isAcknowledged());
    }

    /**
     * create by: wendyMa
     * description: 添加文档
     * create time: 2022/6/5 15:23
     *
     * @return
     */
    @Test
    void testAddDocument() throws IOException {
        // 创建对象
        User user = new User("wendy", 25);
        // 创建请求
        IndexRequest request = new IndexRequest("ma_index");
        // 设置文档id
        request.id("1");
        // 设置过期时间
        request.timeout(TimeValue.timeValueSeconds(1));
        // 转为json字符串再保存
        ObjectMapper objectMapper = new ObjectMapper();
        request.source(objectMapper.writeValueAsString(user), XContentType.JSON);
        // 发送请求
        IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        // 获取响应结果
        System.out.println(indexResponse.toString());
        RestStatus Status = indexResponse.status();
        System.out.println(Status == RestStatus.OK || Status == RestStatus.CREATED);
    }

    /**
     * create by: wendyMa
     * description: 判断文档是否存在  get  /index/_doc/id
     * create time: 2022/6/5 15:26
     *
     * @return
     */
    @Test
    void testIsExists() throws IOException {
        GetRequest getRequest = new GetRequest("ma_index", "1");
        // 不获取_source上下文 storedFields
        getRequest.fetchSourceContext(new FetchSourceContext(false));
        getRequest.storedFields("_none_");
        // 判断此id是否存在！
        boolean exists = restHighLevelClient.exists(getRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * create by: wendyMa
     * description: 获取文档信息  get  /index/_doc/id
     * create time: 2022/6/5 15:28
     *
     * @return
     */
    @Test
    void testGetDocument() throws IOException {
        GetRequest getRequest = new GetRequest("ma_index", "1");
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        // 打印文档内容
        System.out.println(getResponse);
    }

    // 更新文档记录
    @Test
    void testUpdateDocument() throws IOException {
        UpdateRequest request = new UpdateRequest("ma_index", "1");
        request.timeout(TimeValue.timeValueSeconds(1));
        request.timeout("1s");
        User user = new User("wendyma", 28);
        request.doc(JSONUtils.objectToString(user), XContentType.JSON);
        UpdateResponse updateResponse = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        System.out.println(updateResponse.status() == RestStatus.OK);
    }

    // 删除文档测试
    @Test
    void testDelete() throws IOException {
        DeleteRequest request = new DeleteRequest("ma_index", "1");
        request.timeout(TimeValue.timeValueSeconds(1));
        DeleteResponse deleteResponse = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        System.out.println(deleteResponse.status() == RestStatus.OK);
    }

    @Test
    void testBulkRequest() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout(TimeValue.timeValueMinutes(2));
        bulkRequest.timeout("2m");
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("kuangshen1", 11));
        userList.add(new User("kuangshen2", 12));
        userList.add(new User("kuangshen3", 13));
        userList.add(new User("qinjiang1", 14));
        userList.add(new User("qinjiang2", 15));
        userList.add(new User("qinjiang3", 16));
        for (int i = 0; i < userList.size(); i++) {
            bulkRequest
                    .add(new IndexRequest("ma_index")
                            .id("" + (i + 1))
                            .source(JSONUtils.objectToString(userList.get(i)), XContentType.JSON));
        }// bulk
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(!bulkResponse.hasFailures());
    }

    /**
     * create by: wendyMa
     * description:
     *   SearchRequest  1 搜搜请求
     *   SearchSourceBuilder   2 条件构造
     *   HighlightBuilder   3-1 构造高亮
     *   TermQueryBuilder  3-2 精确查询
     *   MatchAllQueryBuilder  3-3 查询所有
     *
     * create time: 2022/6/5 17:27
     * @return
     */
    @Test
    void testSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest("ma_index");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //AbstractQueryBuilder queryBuilder = QueryBuilders.termQuery("name", "qinjiang1");
        AbstractQueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        sourceBuilder.query(queryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);
        SearchResponse response = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSONUtils.objectToString(response.getHits()));
        System.out.println("================SearchHit==================");
        for (SearchHit documentFields : response.getHits().getHits()) {
            System.out.println(documentFields.getSourceAsMap());
        }
    }
}
