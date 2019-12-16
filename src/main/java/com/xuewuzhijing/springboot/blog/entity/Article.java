package com.xuewuzhijing.springboot.blog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Article
 * @Description 博客文章实体类
 * @Author wangzhihao
 * @Date 2019/12/16 15:57
 * @Version 1.0
 **/
public class Article implements Serializable{
    private static final long serialVersionUID = 1L;

    //文章id
    private Integer id;
    //标题
    private String title;
    //内容
    private String content;
    //类型
    private String type;
    //标签
    private String tags;
    //分类
    private String categories;
    //评论数量
    private Integer commentsCount;
    //开启评论
    private Integer allowComment;
    //状态
    private Integer status;
    //作者
    private String author;
    //作者id
    private Integer authorId;
    //创建时间
    private Date createDate;
    //修改时间
    private Date modifiedDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Integer getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(Integer allowComment) {
        this.allowComment = allowComment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", type='" + type + '\'' +
                ", tags='" + tags + '\'' +
                ", categories='" + categories + '\'' +
                ", commentsCount=" + commentsCount +
                ", allowComment=" + allowComment +
                ", status=" + status +
                ", author='" + author + '\'' +
                ", authorId=" + authorId +
                ", createDate=" + createDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }
}
