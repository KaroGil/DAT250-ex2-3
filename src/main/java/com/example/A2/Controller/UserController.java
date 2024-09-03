package com.example.A2.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;

import com.example.A2.PollManager;
import com.example.A2.Components.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    private final PollManager pollManager;

    public UserController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @GetMapping
    public Set<User> getUsers() {
        return pollManager.getUsers();
    }

    @PostMapping
    public  void createUser(User user) {
        pollManager.addUser(user);
    }

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username) {
        return pollManager.getUser(username);
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        pollManager.deleteUser(pollManager.getUser(username));
    }

    @PutMapping("/{username}")
    public void updateUser(@PathVariable String username, String newName, String newEmail) {
        User existingUser = pollManager.getUser(username);
        if (existingUser != null) {
            existingUser.setName(newName);
            existingUser.setEmail(newEmail);

            pollManager.updateUser(existingUser);
        }
        else {
            // If the user does not exist, create a new user
            pollManager.addUser(new User());
        }

    }



}
