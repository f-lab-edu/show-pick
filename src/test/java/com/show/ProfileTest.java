package com.show;

import org.junit.jupiter.api.Test;

import static com.show.Profile.Visibility.PRIVATE;
import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {

    @Test
    void follow() {
        Profile me = new Profile("@jjy1004");
        Profile user = new Profile("@kmk2024");
        me.follow(user);

        assertTrue(me.isAlreadyFollowed(user));
        assertTrue(user.getFollowers().contains(me));
    }

    @Test
    void changeVisibility() {
        Profile me = new Profile("@jjy1004");
        me.changeVisibility();

        assertFalse(me.isPublic());
        assertEquals(PRIVATE, me.getVisibility());
    }

    @Test
    void like() {
        Profile me = new Profile("@jjy1004");
        Video video = new Video("v001", "https://aws.com/video");

        me.like(video);
        assertTrue(me.isAlreadyLiked(video));
    }
}