package com.wangzhihao.springboot.blog.entity;

import java.util.Date;

/**
 * @ClassName Comment
 * @Description 留言评论实体类
 * @Author wangzhihao
 * @Date 2019/12/30 13:54
 * @Version 1.0
 **/
public class Comment{
    private Integer id;
    private Integer articleId;
    private String userNickName;
    private String comment;
    private Date date;
    private Integer isReported;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIsReported() {
        return isReported;
    }

    public void setIsReported(Integer isReported) {
        this.isReported = isReported;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", userNickName='" + userNickName + '\'' +
                ", comment='" + comment + '\'' +
                ", date=" + date +
                ", isReported=" + isReported +
                '}';
    }
}
