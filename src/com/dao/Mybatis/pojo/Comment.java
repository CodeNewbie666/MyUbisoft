package com.dao.Mybatis.pojo;

public class Comment {
    private int id;
    private String username;
    //文字评论
    private String textComment;
    //图片评论
    private String picture;

    public Comment() {
    }

    public Comment(int id, String username, String textComment, String picture) {
        this.id = id;
        this.username = username;
        this.textComment = textComment;
        this.picture = picture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTextComment() {
        return textComment;
    }

    public void setTextComment(String textComment) {
        this.textComment = textComment;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", textComment='" + textComment + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
