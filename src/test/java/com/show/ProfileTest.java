package com.show;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProfileTest {
    @Test
    void like() {
        String video = "mp4";
        Profile profile = new Profile("juan", 1);
        profile.like(video);


        assertEquals(video, profile.likes.get(0));
    }
}