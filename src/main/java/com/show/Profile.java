package com.show;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Profile {
    final String profileId;
    String picture;
    String nickname;
    String introduction;
    List<Profile> followings;
    List<Profile> followers;
    List<String> uploadedVideos;
    List<String> likedVideos;
    String visibility;

    public Profile(String profileId, String nickname) {
        this.profileId = profileId;
        this.nickname = nickname;

        this.followings = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.visibility = "public";
    }

    public void changePicture(String newPicture) {
        this.picture = newPicture;
    }

    public void changeNickname(String newNickname) {
        this.nickname = newNickname;
    }

    public void changeIntroduction(String newIntroduction) {
        this.introduction = newIntroduction;
    }

    private boolean isAlreadyFollowed(Profile user) {
        return followings.contains(user);
    }

    public void follow(Profile user) {
        if (isAlreadyFollowed(user)) {
            followings.remove(user);
            user.followers.remove(this);
            return ;
        }
        followings.add(user);
        user.followers.add(this);
    }

    private boolean isPublic() {
        return Objects.equals(this.visibility, "public");
    }

    public void changeVisibility() {
        if (isPublic()) {
            this.visibility = "private";
            return ;
        }
        this.visibility = "public";
    }

//    like 기능 보류
//    private boolean isAlreadyLiked(String video) {
//        return likes.contains(video);
//    }
//
//    public void like(String video) {
//        // 1. video가 likes 안에 있는지 찾는다.
//        // 2. 1 조건에 만족하면 likes에서 video를 지운다.
//        // 3. 1 조건에 만족하지 않으면 likes에 video를 추가한다.
//        if(isAlreadyLiked(video)) {
//            likes.remove(video);
//            return;
//        }
//        likes.add(video);
//    }
}
