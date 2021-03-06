package com.gcyh.mvp.mvp.model;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class InfoItem {

    /**
     * articleId : 0
     * author : string
     * commentNumber : 0
     * picture : string
     * praiseNumber : 0
     * title : string
     */
    @Id
    long id;
    private long articleId;
    private String author;
    private int commentNumber;
    private String picture;
    private int praiseNumber;
    private String title;
    private String articleUuid;
    private int categoryId;

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getPraiseNumber() {
        return praiseNumber;
    }

    public void setPraiseNumber(int praiseNumber) {
        this.praiseNumber = praiseNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArticleUuid() {
        return articleUuid;
    }

    public void setArticleUuid(String articleUuid) {
        this.articleUuid = articleUuid;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
