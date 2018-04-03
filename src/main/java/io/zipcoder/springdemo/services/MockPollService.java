package io.zipcoder.springdemo.services;

import io.zipcoder.springdemo.domain.Poll;
import io.zipcoder.springdemo.services.PollService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

public class MockPollService extends PollService {
    @Override
    public ResponseEntity<Iterable<Poll>> getPolls() {
        Iterable<Poll> polls = null;
        return new ResponseEntity<>(polls, HttpStatus.OK);
    }
}