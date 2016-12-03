package br.com.teste.call.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Shots implements Serializable {
    private static final long serialVersionUID = 8464531271271783035L;

    private int id;
    private String title;
    private String description;
    @SerializedName("views_count")
    private int viewsCount;
    @SerializedName("likes_count")
    private int likesCount;
    @SerializedName("comments_count")
    private int commentCount;
    private Team team;
    private MyImages images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(int viewsCount) {
        this.viewsCount = viewsCount;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public MyImages getImages() {
        return images;
    }

    public void setImages(MyImages images) {
        this.images = images;
    }
}
