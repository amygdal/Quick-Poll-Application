package io.zipcoder.springdemo.integration;

import io.zipcoder.springdemo.domain.Poll;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

/**
 * @author leon on 4/2/18.
 */
public class MockClient {
    private final TestRestTemplate restTemplate;

    public MockClient(TestRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void createPoll(Poll poll) {
    }

    public ResponseEntity<String> getPoll(Long id) {
        String uri = "/polls/{pollId}";
        return this.restTemplate.getForEntity(
                uri,
                String.class,
                id);
    }
}
