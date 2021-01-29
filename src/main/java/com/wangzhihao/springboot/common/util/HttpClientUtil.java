package com.wangzhihao.springboot.common.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @ClassName HttpClientUtil
 * @Description TODO
 * @Author wangzhihao
 * @Date 21/1/8 09:43
 * @Version 1.0
 **/
@Component
public class HttpClientUtil {
    @Autowired
    private CloseableHttpClient httpClient;

    @Autowired
    private RequestConfig requestConfig;

    //httpClientConnectionManager post 线程池请求 application/json
    public String doPost(String url, Map<String, String> headerMap, String contentMap) {

        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);

        //添加请求头
        Iterator<Map.Entry<String, String>> headIterator = headerMap.entrySet().iterator();
        while (headIterator.hasNext()) {
            Map.Entry<String, String> next = headIterator.next();
            httpPost.addHeader(next.getKey(), next.getValue());
        }

        try {
            if (StringUtils.isNotBlank(contentMap)) {
                StringEntity entity = new StringEntity(contentMap,"utf-8");
                httpPost.setEntity(entity);
            }
            //执行返回结果
            CloseableHttpResponse response = httpClient.execute(httpPost);
            if (response != null && response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity);
                return result;
            }
            httpPost.abort();
        } catch (Exception e) {
            httpPost.abort();
            return "fail";
        }
        return null;
    }

}
