package com.example.A2.Components;
import java.time.Instant;
import java.util.UUID;

enum Visibility {
    PUBLIC,
    PRIVATE
}

public class Poll implements java.io.Serializable {
    
    private String question;
    private Instant publishAt;
    private Instant validUntil;
    private VoteOption[] options;
    private UUID id;
    private Visibility state = Visibility.PRIVATE;
    
    public Poll(String question, Instant publishAt, Instant validUntil, VoteOption[] options, Visibility state) {
        this.question = question;
        this.publishAt = publishAt;
        this.validUntil = validUntil;
        this.options = options;
        this.state = state;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public VoteOption[] getOptions() {
        return options;
    }

    public void setOptions(VoteOption[] options) {
        this.options = options;
    }

    public Visibility getState() {
        return state;
    }

    public void setState(Visibility state) {
        this.state = state;
    }
}
