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
import java.util.UUID;
import java.util.Collection;

@RestController
@RequestMapping("/api/polls")
public class PollController {
    
    private final PollManager pollManager;

    public PollController(PollManager pollManager) {
        this.pollManager = pollManager;
    }
    
    @GetMapping
    public Collection<Poll> getAllPolls() {
        return pollManager.getAllPolls();
    }

    @PostMapping
    public void createPoll(@RequestBody Poll poll) {
        pollManager.addPoll(poll);
    }


    @GetMapping("/{pollId}")
    public Poll getPoll(@PathVariable UUID pollId) {
        return pollManager.getPoll(pollId);
    }

    @PutMapping("/{pollId}")
    public void updatePoll(@PathVariable UUID pollId, @RequestBody Poll poll) {
        pollManager.updatePoll(pollId, poll);
    }

    @DeleteMapping
    public void deleteAllPolls() {
        pollManager.removeAllPolls();
    }

    @DeleteMapping("/{pollId}")
    public void deletePoll(@PathVariable UUID pollId) {
        pollManager.removePoll(pollId);
    }
}
