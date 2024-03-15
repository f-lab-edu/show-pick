package com.show;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.Set;

@Getter
public class Profile {
    public enum Visibility {
        PUBLIC, PRIVATE
    }
    private final String id;
    private String picture;
    private String nickname;
    private String intro;
    private Set<Profile> followings;
    private Set<Profile> followers;
    private Visibility visibility;
    private Set<Video> uploadedVideos;
    private Set<Video> likedVideos;

    public Profile(String id) {
        this.id = id;

        this.visibility = Visibility.PUBLIC;
        this.followings = new HashSet<>();
        this.followers = new HashSet<>();
        this.uploadedVideos = new HashSet<>();
        this.likedVideos = new HashSet<>();
    }

    public boolean isAlreadyFollowed(Profile user) {
        return followings.contains(user);
    }

    // 팔로우, 언팔로우를 분리하는 게 좋을지.
    public void follow(Profile user) {
        if (isAlreadyFollowed(user)) {
            followings.remove(user);
            user.followers.remove(this);
            return ;
        }
        followings.add(user);
        user.followers.add(this);
    }

    public boolean isPublic() {
        return this.visibility == Visibility.PUBLIC;
    }

    public void changeVisibility() {
        if (isPublic()) {
            this.visibility = Visibility.PRIVATE;
            return ;
        }
        this.visibility = Visibility.PUBLIC;
    }

    public boolean isAlreadyLiked(Video video) {
        return likedVideos.contains(video);
    }

    public void like(Video video) {
        if (isAlreadyLiked(video)) {
            likedVideos.remove(video);
            video.subtractLikes();
            return ;
        }
        likedVideos.add(video);
        video.addLikes();
    }
}
