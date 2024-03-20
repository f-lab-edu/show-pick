package com.show;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class Comment {
    private String id;
    private Profile profile;
    private String content;
    private int likes;
    private List<Comment> recomments;

    public void addRecomment(Comment comment) {
        recomments.add(comment);
    }
}
