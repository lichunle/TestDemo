package com.example.demo.common.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Elasticsearch rest 配置
 *
 * @author yaox
 * @version [V1.0.0, 2020年6月1日]
 */
@Configuration
public class ElasticsearchConfiguration {

    @Value("${elasticsearch.rest.uris}")
    private String[] esUris;

    @Value("${elasticsearch.rest.connection-timeout}")
    private int connectTimeOut;

    @Value("${elasticsearch.rest.max-connection}")
    private int maxConnection;

    @Value("${elasticsearch.rest.username}")
    private String userName;

    @Value("${elasticsearch.rest.password}")
    private String password;

    /**RestHighLevelClient
     * @return
     */
    @Bean
    public RestHighLevelClient restHighLevelClient() {

        if (StringUtils.isEmpty(userName)) {
            RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(httpHostHandlerDev()));
            return client;

        } else {
            final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            credentialsProvider.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(
                    userName, password
            ));

            // 初始化ES客户端的构造器
            RestClientBuilder restClientBuilder = RestClient.builder(httpHostHandlerDev());
            // 异步的请求配置
            restClientBuilder.setRequestConfigCallback(builder -> {
                // 连接超时时间 默认-1
                builder.setConnectTimeout(connectTimeOut);
                //
                builder.setSocketTimeout(connectTimeOut);
                // 获取连接的超时时间 默认-1
                builder.setConnectionRequestTimeout(connectTimeOut);
                return builder;
            });
            // 异步的httpclient连接数配置
            restClientBuilder.setHttpClientConfigCallback(httpAsyncClientBuilder -> {
                // 最大连接数
                httpAsyncClientBuilder.setMaxConnTotal(maxConnection);
                // 最大路由连接数
                httpAsyncClientBuilder.setMaxConnPerRoute(10);
                // 赋予连接凭证
                httpAsyncClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                return httpAsyncClientBuilder;
            });
            return new RestHighLevelClient(restClientBuilder);
        }
    }

    /**
     * 为了应对集群部署的es，使用以下写法，返回HttpHost数组
     */
    private HttpHost[] httpHostHandlerDev() {
        String[] hosts = esUris;
        HttpHost[] httpHosts = new HttpHost[hosts.length];
        for (int i = 0; i < hosts.length; i++) {
            String ip = hosts[i].split(":")[0];
            int port = Integer.parseInt(hosts[i].split(":")[1]);
            httpHosts[i] = new HttpHost(ip, port, "http");
        }
        return httpHosts;
    }


}
