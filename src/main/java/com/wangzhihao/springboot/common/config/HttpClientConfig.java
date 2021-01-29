package com.wangzhihao.springboot.common.config;

import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName HttpClientConfig
 * @Description TODO
 * @Author wangzhihao
 * @Date 21/1/8 09:39
 * @Version 1.0
 **/
@Configuration
public class HttpClientConfig {
    private Integer maxTotal = 200;

    private Integer defaultMaxPerRoute = 20;

    private Integer connectTimeout = 20000;

    private Integer connectionRequestTimeout = 20000;

    private Integer socketTimeout = 20000;

    @Bean(name = "httpClientConnectionManager")
    public PoolingHttpClientConnectionManager getHttpClientConnectionManager(){
        PoolingHttpClientConnectionManager httpClientConnectionManager = new PoolingHttpClientConnectionManager();
        httpClientConnectionManager.setMaxTotal(maxTotal);
        httpClientConnectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        return httpClientConnectionManager;
    }

    @Bean(name = "httpClientBuilder")
    public HttpClientBuilder getHttpClientBuilder(
            @Qualifier("httpClientConnectionManager") PoolingHttpClientConnectionManager httpClientConnectionManager){
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        httpClientBuilder.setConnectionManager(httpClientConnectionManager);
        return httpClientBuilder;
    }

    @Bean
    public CloseableHttpClient getCloseableHttpClient(@Qualifier("httpClientBuilder") HttpClientBuilder httpClientBuilder){
        return httpClientBuilder.build();
    }

    @Bean(name = "builder")
    public RequestConfig.Builder getBuilder(){
        RequestConfig.Builder builder = RequestConfig.custom();
        return builder.setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setSocketTimeout(socketTimeout).setCookieSpec(CookieSpecs.STANDARD_STRICT);
    }

    @Bean
    public RequestConfig getRequestConfig(@Qualifier("builder") RequestConfig.Builder builder){
        return builder.build();
    }
}
