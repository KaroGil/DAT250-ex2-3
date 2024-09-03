package com.example.A2.Components;
import java.time.Instant;

public class Vote implements java.io.Serializable {
    
    private User user;
    private Instant publishAt;

    public Vote() {
    }

    public Instant getPublishAt() {
        return publishAt;
    }

    public void setPublishAt(Instant publishAt) {
        this.publishAt = publishAt;
    }

}
