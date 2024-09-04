package com.example.A2.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{user}")
    public Poll getPoll(@PathVariable User user) {
        return pollManager.getPoll(user);
    }

    @PutMapping("/{user}")
    public void updatePoll(@PathVariable User user, @RequestBody Poll poll) {
        pollManager.updatePoll(user, poll);
    }

    @DeleteMapping("/{user}")
    public void deleteAllPolls(@PathVariable User user) {
        pollManager.removeAllPolls(user);
    }

    @DeleteMapping("/{user}/{poll}")
    public void deletePoll(@PathVariable User user, @PathVariable Poll poll) {
        pollManager.removePoll(user, poll);
    }
}
