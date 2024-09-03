package com.example.A2;
import java.util.HashMap;

import org.springframework.stereotype.Component;
import java.util.Set;

import com.example.A2.Components.Poll;
import com.example.A2.Components.User;

@Component
public class PollManager {
    
    HashMap<User, Poll> polls = new HashMap<User, Poll>();


    public PollManager() {
    }
    
    public void addPoll(User user, Poll poll) {
        polls.put(user, poll);
    }

    public Poll getPoll(User user) {
        return polls.get(user);
    }

    public void removePoll(User user) {
        polls.remove(user);
    }

    public void updatePoll(User user, Poll poll) {
        polls.put(user, poll);
    }

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
}