package com.example.A2;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import java.util.Set;

import com.example.A2.Components.Poll;
import com.example.A2.Components.User;
import com.example.A2.Components.Vote;
import com.example.A2.Components.VoteOption;

@Component
public class PollManager {
    
    HashMap<User, Poll> polls = new HashMap<User, Poll>();
    HashMap<VoteOption, Vote> voteOptions = new HashMap<VoteOption, Vote>();

    public PollManager() {
    }
    
    // POLL METHODS
    public void addPoll(User user, Poll poll) {
        polls.put(user, poll);
    }

    public Poll getPoll(User user) {
        return polls.get(user);
    }

    public void removeAllPolls(User user) {
        polls.remove(user);
    }

    public void removePoll(User user, Poll poll) {
        polls.remove(user, poll);
    }

    public void updatePoll(User user, Poll poll) {
        polls.put(user, poll);
    }

    // USER METHODS
    public Set<User> getUsers() {
        return polls.keySet();
    }

    public User getUser(String username) {
        for (User user : polls.keySet()) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        polls.put(user, null);
    }

    public void deleteUser(User user) {
        polls.remove(user);
    }

    public void updateUser(User user) {
        polls.put(user, polls.get(user));
    }

    // // VOTE METHODS
    // public Set<User> getVotes() {
    //     return votes.keySet();
    // }

    // public void addVote(User user, Vote vote) {
    //     votes.put(user, vote);
    // }

    // public void deleteVote(String vote) {
    //     for (User user : polls.keySet()) {
    //         if (user.getName().equals(vote)) {
    //             polls.remove(user);
    //         }
    //     }
    // }

    // public void updateVote(User user, Vote vote) {
    //     votes.put(user, vote);
    // }


}