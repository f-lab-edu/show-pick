package com.show;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {

    @Test
    void follow() {
        Profile me = new Profile("@jjy1004", "judy");
        Profile user = new Profile("@kmk2024", "pingu");
        me.follow(user);

        assertEquals("pingu", me.followings.get(0).nickname);
        assertEquals("judy", user.followers.get(0).nickname);
    }

    @Test
    void changeVisibility() {
        Profile me = new Profile("@jjy1004", "judy");
        me.changeVisibility();

        assertEquals("private", me.visibility);
    }
//    @Test
//    void like() {
//        String video = "mp4";
//        Profile profile = new Profile("jjy_0123", "juan");
//        profile.like(video);
//
//
//        assertEquals(video, profile.likes.get(0));
//    }
}