package com.wangzhihao.springboot.entity;

/**
 * @ClassName Article
 * @Description TODO
 * @Author wangzhihao
 * @Date 19/11/18 22:07
 * @Version 1.0
 **/
public class Article{
    private Integer id;
    private String articleTitle;
    private String articleContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                '}';
    }
}
