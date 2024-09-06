package com.example.A2.Components;
import java.time.Instant;
import java.util.UUID;

public class Vote implements java.io.Serializable {
    
    private UUID votedBy;
    private Instant publishAt;
    private UUID id;

    public Vote(UUID votedBy) {
        this.id = UUID.randomUUID();
        this.votedBy = votedBy;
        this.publishAt = Instant.now();
    }

    public UUID getId() {
        return id;
    }

    public Instant getPublishAt() {
        return publishAt;
    }

    public void setPublishAt(Instant publishAt) {
        this.publishAt = publishAt;
    }

    public UUID getUser() {
        return votedBy;
    }

    public void setUser(UUID votedBy) {
        this.votedBy = votedBy;
    }
}