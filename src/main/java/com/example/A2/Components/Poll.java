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
    private String[] options;
    private UUID id;
    private Visibility state = Visibility.PRIVATE;
    
    public Poll(String question, Instant publishAt, Instant validUntil, String[] options) {
        this.question = question;
        this.publishAt = publishAt;
        this.validUntil = validUntil;
        this.options = options;
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

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }
}
