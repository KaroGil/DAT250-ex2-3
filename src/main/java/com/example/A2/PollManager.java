package com.example.A2;
import java.util.HashMap;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.util.Set;

import com.example.A2.Components.Poll;
import com.example.A2.Components.User;
import com.example.A2.Components.Vote;
import com.example.A2.Components.VoteOption;
import org.slf4j.Logger;
import java.util.Collection;

@Component
public class PollManager {

    private static final Logger logger = LoggerFactory.getLogger(PollManager.class);

    
    HashMap<User, Poll> polls = new HashMap<User, Poll>();
    HashMap<VoteOption, Vote> voteOptions = new HashMap<VoteOption, Vote>();

    public PollManager() {
    }


    // POLL METHODS
    public void addPoll(String username, Poll poll) {
        User user = getUser(username);
        polls.put(user, poll);
    }

    public Collection<Poll> getAllPolls() {
        return  polls.values();
    }

    public Poll getPoll(String username) {
        User user = getUser(username);
        return polls.get(user);
    }

    public void removeAllPolls(String username) {
        User user = getUser(username);
        polls.remove(user);
    }

    public void removePoll(String username, Poll poll) {
        User user = getUser(username);
        polls.remove(user, poll);
    }

    public void updatePoll(String username, Poll poll) {
        User user = getUser(username);
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
        throw new IllegalArgumentException("User not found");
        //return null;
    }

    public void addUser(User user) {
        polls.put(user, null);
    }

    public void deleteUser(User user) {
        polls.remove(user);
    }

    public void updateUser(User user) {
        logger.info("Updating user: " + user.getName());
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