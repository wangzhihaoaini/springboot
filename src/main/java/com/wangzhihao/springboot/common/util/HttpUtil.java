package com.wangzhihao.springboot.common.util;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HttpUtil
 * @Description Http调用接口工具类
 * @Author wangzhihao
 * @Date 2020/1/19 16:01
 * @Version 1.0
 **/
@Component
public class HttpUtil{
    //创建HttpClient对象
    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private CloseableHttpResponse response = null;

    /**
    *@Author wangzhihao
    *@Description Get请求
    *@Date 16:34 2020/1/19
    *@Param []
    *@return void
    **/
    public void doGet(){
        // 创建http GET请求
        HttpGet httpGet=new HttpGet("http://www.oschina.net/");
        try {
            //执行请求
            response=httpClient.execute(httpGet);
            //判断返回状态码
            if(response.getStatusLine().getStatusCode()==200){
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println("内容长度：" + content.length());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    httpClient.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
    *@Author wangzhihao
    *@Description Get请求带参数
    *@Date 16:06 2020/1/19
    *@Param [text, desp]
    *@return void
    **/
    public void doGetParam(String text, String desp) {
        try {
            //定义请求的参数
            URI uri = new URIBuilder("https://sc.ftqq.com/SCU78171Te9617c64e7b92156151d4087685a6bc25e23bded99257.send").setParameter("text", text).setParameter("desp", desp).build();
            System.out.println(uri);
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpClient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    httpClient.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
    *@Author wangzhihao
    *@Description Post请求
    *@Date 16:35 2020/1/19
    *@Param []
    *@return void
    **/
    public void doPost(){
        // 创建Httpclient对象
        httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();

        // 创建http POST请求
        HttpPost httpPost = new HttpPost("http://www.oschina.net/");

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpClient.execute(httpPost);
            System.out.println(response.getStatusLine());
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (response != null) {
                try {
                    response.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            try {
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
    *@Author wangzhihao
    *@Description Post请求带参数
    *@Date 16:40 2020/1/19
    *@Param []
    *@return void
    **/
    public void doPostParam() throws Exception{
        // 创建Httpclient对象
        httpClient = HttpClientBuilder.create().setRedirectStrategy(new LaxRedirectStrategy()).build();
        // 创建http POST请求
        HttpPost httpPost = new HttpPost("http://www.oschina.net/search");
        // 设置2个post参数，一个是scope、一个是q
        List<NameValuePair> parameters = new ArrayList<NameValuePair>();
        parameters.add(new BasicNameValuePair("scope", "project"));
        parameters.add(new BasicNameValuePair("q", "java"));
        // 构造一个form表单式的实体
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = httpClient.execute(httpPost);
            System.out.println(response.getStatusLine());
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpClient.close();
        }
    }
}
