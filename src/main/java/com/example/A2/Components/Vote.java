package com.example.A2.Components;
import java.time.Instant;
import java.util.UUID;

public class Vote implements java.io.Serializable {
    
    private UUID votedBy;
    private Instant publishAt;
    private UUID id;
    private UUID voteOptionId;

    public Vote(UUID votedBy, UUID voteOptionId) {
        this.id = UUID.randomUUID();
        this.votedBy = votedBy;
        this.voteOptionId = voteOptionId;
        this.publishAt = Instant.now();
    }
    public Vote() {
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

    public UUID getVotedBy() {
        return votedBy;
    }

    public void setVotedBy(UUID votedBy) {
        this.votedBy = votedBy;
    }

    public UUID getVoteOptionId() {
        return voteOptionId;
    }

    public void setVoteOptionId(UUID voteOptionId) {
        this.voteOptionId = voteOptionId;
    }
}