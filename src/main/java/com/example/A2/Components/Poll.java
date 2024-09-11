package com.example.A2.Components;
import java.time.Instant;
import java.util.UUID;
import java.util.ArrayList;

public class Poll implements java.io.Serializable {
    
    private String question;
    private Instant publishAt;
    private Instant validUntil;
    private ArrayList<VoteOption> options;
    private UUID id;
    private boolean isPublic;
    private UUID creatorUserId;
    
    public Poll(String question, Instant publishAt, Instant validUntil, ArrayList<VoteOption> options, boolean isPublic, UUID creatorUserId) {
        this.id = UUID.randomUUID();
        this.question = question;
        this.publishAt = Instant.now();
        this.validUntil = validUntil;
        this.options = options;
        this.isPublic = isPublic;
        this.creatorUserId = creatorUserId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getCreatorUserId() {
        return creatorUserId;
    }

    public String getQuestion() {
        return question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }
    
    public Instant getPublishAt() {
        return publishAt;
    }

    public void setPublishAt(Instant publishAt) {
        this.publishAt = publishAt;
    }

    public Instant getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Instant validUntil) {
        this.validUntil = validUntil;
    }

    public ArrayList<VoteOption> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<VoteOption> options) {
        this.options = options;
    }

    public Boolean getState() {
        return isPublic;
    }

    public void setState(boolean isPublic) {
        this.isPublic = isPublic;
    }
}
