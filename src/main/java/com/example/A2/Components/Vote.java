package com.example.A2.Components;
import java.time.Instant;

public class Vote implements java.io.Serializable {
    
    private User user;
    private Instant publishAt;

    public Vote(User user, Instant publishAt) {
        this.user = user;
        this.publishAt = publishAt;
    }

    public Instant getPublishAt() {
        return publishAt;
    }

    public void setPublishAt(Instant publishAt) {
        this.publishAt = publishAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}