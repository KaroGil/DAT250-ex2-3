package com.example.A2.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.A2.PollManager;
import com.example.A2.Components.Vote;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/vote")
public class VoteController {
    
    private final PollManager pollManager;

    public VoteController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @GetMapping
    public Collection<Vote> getVotes() {
        return pollManager.getAllVotes();
    }

    @PostMapping
    public void createVote(@RequestBody Vote vote) {
        Vote newVote = new Vote(vote.getVotedBy(), vote.getVoteOptionId(), vote.getPollId());
        pollManager.addVote(newVote);
    }

    @DeleteMapping("/{voteId}")
    public void deleteVote(@PathVariable UUID voteId) {
        pollManager.removeVote(voteId);
    }

    @PutMapping("/{voteId}")
    public void updateVote(@PathVariable UUID voteId, @RequestBody Vote newVote) {
            pollManager.updateVote(voteId, newVote);
}
}