package com.example.A2.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.A2.PollManager;
import com.example.A2.Components.Poll;
import com.example.A2.Components.User;


@RestController
@RequestMapping("/api/polls")
public class PollController {
    
    private final PollManager pollManager;

    public PollController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping("/{user}")
    public void createPoll(@PathVariable User user, @RequestBody Poll poll) {
        pollManager.addPoll(user, poll);
    }
}
