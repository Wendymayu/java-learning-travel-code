package com.wendy.elasticsearch.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2022/6/5 13:40
 * @Version 1.0
 */
@Configuration
public class ElasticsearchClientConfig {
    /**
     * create by: wendyMa
     * description: 自己配置一个RestHighLevelClient，实际上ES也会自动配置一个RestHighLevelClient
     * create time: 2022/6/5 14:00
     * @return
     */
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("127.0.0.1", 9200, "http")));
        return client;
    }
}
