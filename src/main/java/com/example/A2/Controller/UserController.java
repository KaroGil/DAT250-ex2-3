package com.example.A2.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.A2.PollManager;
import com.example.A2.Components.User;
import java.util.Collection;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
    
    private final PollManager pollManager;
    private static final Logger logger = LoggerFactory.getLogger(PollManager.class);

    public UserController(PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @GetMapping
    public Collection<User> getUsers() {
        logger.info("getting users");
        return pollManager.getUsers();
    }

    @PostMapping
    public  void createUser(@RequestBody User user) {
        logger.info("creating user");
        pollManager.addUser(user);
        logger.info("user created");
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable UUID userId) {
        return pollManager.getUser(userId);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable UUID userId) {
        pollManager.deleteUser(userId);
    }

    @PutMapping("/{userId}")
    public void updateUser(@PathVariable UUID userId, @RequestBody User newUser) {    
        logger.info("updating user");
        pollManager.updateUser(userId, newUser);
        logger.info("user updated");
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        if(user == null || user.getName() == null || user.getPassword() == null) {
            logger.info("user/name/pass is null");
            return null;
        }
        logger.info("user gotten for login: " + user.getName() + ", password: " + user.getPassword());
        logger.info("logging in " + user.getName());
        User userFound = pollManager.login(user.getName(), user.getPassword());
        if(userFound == null) {
            logger.info("user not found");
            return null;
        }
        logger.info("user found: " + userFound.getName());

        return userFound;
    }
}
