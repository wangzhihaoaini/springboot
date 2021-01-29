package com.wangzhihao.springboot.system.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @ClassName LearnResouce
 * @Description ConfigurationProperties从yml中取值
 * @Author wangzhihao
 * @Date 2019/9/25 22:26
 * @Version 1.0
 **/
@Component
public class Resource {
    private String author;
    private String title;
    private String url;

    private Map<String,Object> map;
    private List<String> list;
    public Resource() {
    }

    public Resource(String author, String title, String url) {
        this.author = author;
        this.title = title;
        this.url = url;
    }

    public Resource(String author, String title, String url, Map<String, Object> map, List<String> list) {
        this.author = author;
        this.title = title;
        this.url = url;
        this.map = map;
        this.list = list;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "LearnResouce{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", map=" + map +
                ", list=" + list +
                '}';
    }
}
