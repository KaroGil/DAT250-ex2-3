package com.example.A1;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import java.util.UUID;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import com.example.A2.Components.User;
import com.example.A2.SimpleWebServer;
import com.example.A2.Components.Poll;
import com.example.A2.Components.Vote;
import com.example.A2.Components.VoteOption;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = SimpleWebServer.class)
public class A2VotingAppTest {

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    public void testCreateAndListUsers() {
        // Step 1: Create User 1
        String createUserUrl = "http://localhost:8080/api/users";
        User user1 = new User("user1", "user1@example.com", "password123");
        ResponseEntity<User> user1Response = restTemplate.postForEntity(createUserUrl, user1, User.class);

        if (user1Response.getBody() != null) {
            UUID userId = user1Response.getBody().getId();
            System.out.println("Created User ID: " + userId);

            assertEquals(1, user1Response.getBody().toString().length());

            // Step 2: Create Poll for the user
            String createPollUrl = "http://localhost:8080/api/polls";
            Poll poll = new Poll("Favorite programming language?", Instant.now(), Instant.now().plus(7, ChronoUnit.DAYS), 
                    new ArrayList<>(List.of(new VoteOption("Java", 1), new VoteOption("Python", 2))), true, userId);
            ResponseEntity<Poll> pollResponse = restTemplate.postForEntity(createPollUrl, poll, Poll.class);
            assertEquals(200, pollResponse.getStatusCode().value());
        } else {
            System.out.println("Response body is null.");
        }
    }

    @Test
    public void testCreatePollAndVote() {
        // Step 1: Create User
        String createUserUrl = "http://localhost:8080/api/users";
        User user = new User("user1", "user1@example.com", "password123");
        ResponseEntity<User> userResponse = restTemplate.postForEntity(createUserUrl, user, User.class);
        
        // Check for null body
        if (userResponse.getBody() != null) {
            UUID userId = userResponse.getBody().getId();
            System.out.println("Created User ID: " + userId);

            // Step 2: Create Poll
            String createPollUrl = "http://localhost:8080/api/polls";
            Poll poll = new Poll("Favorite programming language?", Instant.now(), Instant.now().plus(7, ChronoUnit.DAYS), 
                    new ArrayList<>(List.of(new VoteOption("Java", 1), new VoteOption("Python", 2))), true, userId);
            ResponseEntity<Poll> pollResponse = restTemplate.postForEntity(createPollUrl, poll, Poll.class);
            assertEquals(200, pollResponse.getStatusCode().value());

            // Step 3: User Votes on the Poll
            String voteUrl = "http://localhost:8080/api/vote";
            Vote vote = new Vote(userId, poll.getOptions().get(0).getId(), poll.getId());
            ResponseEntity<Vote> voteResponse = restTemplate.postForEntity(voteUrl, vote, Vote.class);
            assertEquals(200, voteResponse.getStatusCode().value());

            // Step 4: List Votes for Poll
            ResponseEntity<Vote[]> votesResponse = restTemplate.getForEntity(voteUrl + "?pollId=" + poll.getId(), Vote[].class);
            assertEquals(1, votesResponse.getBody().length);

            // Step 5: Change User's Vote
            vote.setVoteOptionId(poll.getOptions().get(1).getId());
            restTemplate.put(voteUrl + "/" + vote.getId(), vote);
            votesResponse = restTemplate.getForEntity(voteUrl + "?pollId=" + poll.getId(), Vote[].class);
            assertEquals(1, votesResponse.getBody().length);
            assertEquals(poll.getOptions().get(1).getId(), votesResponse.getBody()[0].getVoteOptionId());
        } else {
            System.out.println("Response body is null.");
        }
    }

    @Test
    public void testDeletePollAndVotes() {
        // Step 1: Create User
        String createUserUrl = "http://localhost:8080/api/users";
        User user = new User("user1", "user1@example.com", "password123");
        ResponseEntity<User> userResponse = restTemplate.postForEntity(createUserUrl, user, User.class);
        
        // Check for null body
        if (userResponse.getBody() != null) {
            UUID userId = userResponse.getBody().getId();
            System.out.println("Created User ID: " + userId);

            // Step 2: Create Poll
            String createPollUrl = "http://localhost:8080/api/polls";
            Poll poll = new Poll("Favorite language?", Instant.now(), Instant.now().plus(7, ChronoUnit.DAYS), 
                    new ArrayList<>(List.of(new VoteOption("Java", 1), new VoteOption("Python", 2))), true, userId);
            ResponseEntity<Poll> pollResponse = restTemplate.postForEntity(createPollUrl, poll, Poll.class);
            assertEquals(200, pollResponse.getStatusCode().value());
            
            // Step 3: User Votes
            String voteUrl = "http://localhost:8080/api/vote";
            Vote vote = new Vote(userId, poll.getOptions().get(0).getId(), poll.getId());
            restTemplate.postForEntity(voteUrl, vote, Vote.class);
            
            // Step 4: Delete Poll and Verify Votes are Deleted
            restTemplate.delete(createPollUrl + "/" + poll.getId());
            ResponseEntity<Vote[]> votesResponse = restTemplate.getForEntity(voteUrl + "?pollId=" + poll.getId(), Vote[].class);
            assertEquals(0, votesResponse.getBody().length);
        } else {
            System.out.println("Response body is null.");
        }
    }
}
