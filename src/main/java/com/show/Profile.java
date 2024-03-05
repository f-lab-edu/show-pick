package com.show;

import java.util.ArrayList;
import java.util.List;

public class Profile {
    String picture;
    final String nickname;
    final int profileId;
    String introduction;
    List<String> videos;
    List<Profile> followings;
    List<Profile> followers;
    List<String> likes = new ArrayList<>();

    public Profile(String nickname, int profileId) {
        this.nickname = nickname;
        this.profileId = profileId;
    }

    private boolean isAlreadyLiked(String video) {
        return likes.contains(video);
    }

    public void like(String video) {
        // 1. video가 likes 안에 있는지 찾는다.
        // 2. 1 조건에 만족하면 likes에서 video를 지운다.
        // 3. 1 조건에 만족하지 않으면 likes에 video를 추가한다.
        if(isAlreadyLiked(video)) {
            likes.remove(video);
            return;
        }
        likes.add(video);
    }
}
