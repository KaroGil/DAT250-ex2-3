package com.example.A2.Voting;
import java.time.Instant;

public class Vote {
    
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
