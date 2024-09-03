package com.example.A2.Controller;
import java.util.HashMap;

import org.springframework.stereotype.Component;

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

}
