package com.show;

import lombok.Getter;

@Getter
public class Video {
    private final String id;
    private final String videoUrl;
    private String caption;
    private int views;
    private int likes;
    private int shares;
    private List<Comment> comments;

    public Video(String id, String videoUrl) {
        this.id = id;
        this.videoUrl = videoUrl;
    }

    public int addLikes() {
        return this.likes + 1;
    }

    public int subtractLikes() {
        return this.likes - 1;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
