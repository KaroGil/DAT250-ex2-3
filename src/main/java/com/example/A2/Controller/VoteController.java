package com.example.A2.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vote")
public class VoteController {
    
    // private final PollManager pollManager;

    // public VoteController(PollManager pollManager) {
    //     this.pollManager = pollManager;
    // }

    // @GetMapping
    // public Set<User> getVotes() {
    //     return pollManager.getVotes();
    // }

    // @PostMapping
    // public  void createVote(User u) {
    //     Vote newVote = new Vote(u, Instant.now());
    //     pollManager.addVote(newVote);
    // }

//     @DeleteMapping("/{vote}")
//     public void deleteVote(@PathVariable String vote) {
//         pollManager.deleteVote(vote);
//     }

//     @PutMapping("/{username}")
//     public void updateVote(@PathVariable String username, Vote newVote) {
//         User existingUser = pollManager.getUser(username);
//         if (existingUser != null) {
//             pollManager.updateVote(existingUser, newVote);
//         }
//         else {
//             throw new IllegalArgumentException("User does not exist");
//         }
// }
}