package com.example.A2;
import java.util.HashMap;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.A2.Components.Poll;
import com.example.A2.Components.User;
import com.example.A2.Components.Vote;
import com.example.A2.Components.VoteOption;
import org.slf4j.Logger;
import java.util.Collection;
import java.util.UUID;

@Component
public class PollManager {

    private static final Logger logger = LoggerFactory.getLogger(PollManager.class);

    
    //HashMap<User, Poll> polls = new HashMap<User, Poll>();
    HashMap<UUID, Poll> polls = new HashMap<UUID, Poll>();
    HashMap<UUID, User> users = new HashMap<UUID, User>();
    HashMap<UUID, Vote> votes = new HashMap<UUID, Vote>();
    HashMap<UUID, VoteOption> voteOptions = new HashMap<UUID, VoteOption>();

    public PollManager() {
    }


    // POLL METHODS
    public void addPoll(Poll poll) {
        polls.put(poll.getId(), poll);
    }

    public Collection<Poll> getAllPolls() {
        return  polls.values();
    }

    public Poll getPoll(UUID pollId) {
        return polls.get(pollId);
    }

    public void removeAllPolls() {
        polls.clear();
    }

    public void removePoll(UUID pollId) {
        polls.remove(pollId);
    }

    public void updatePoll(UUID pollId, Poll poll) {
        polls.put(pollId, poll);
    }

    // USER METHODS
    public Collection<User> getUsers() {
        return users.values();
    }

    public User getUser(UUID userId) {
        return users.get(userId);
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void deleteUser(UUID userId) {
        users.remove(userId);
    }

    public void updateUser(UUID userId, User user) {
        logger.info("Updating user: " + user.getName());
        users.put(userId, user);
    }


    // VOTE METHODS
    public void addVote(Vote vote) {
        logger.info("Adding vote: " + vote);
        votes.put(vote.getId(), vote);
    }

    public Collection<Vote> getAllVotes() {
        logger.info("Getting all votes");
        return  votes.values();
    }

    public Vote getVote(UUID voteId) {
        logger.info("Getting vote: " + voteId);
        return votes.get(voteId);
    }

    public void removeAllVotes() {
        votes.clear();
    }

    public void removeVote(UUID voteId) {
        logger.info("Removing vote: " + voteId);
        votes.remove(voteId);
    }

    public void updateVote(UUID voteId, Vote vote) {
        logger.info("Updating vote: " + voteId + " with " + vote);
        votes.put(voteId, vote);
    }

    // VOTE OPTION METHODS
    public void addVoteOptions(VoteOption voteOption) {
        voteOptions.put(voteOption.getId(), voteOption);
    }

    public Collection<VoteOption> getAllVoteOptions() {
        return  voteOptions.values();
    }

    public VoteOption getVoteOption(UUID voteOptionId) {
        return voteOptions.get(voteOptionId);
    }

    public void removeAllVoteOptions() {
        voteOptions.clear();
    }

    public void removeVoteOption(UUID voteOptionId) {
        voteOptions.remove(voteOptionId);
    }

    public void updateVote(UUID voteOptionId, VoteOption voteOption) {
        voteOptions.put(voteOptionId, voteOption);
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