package io.zipcoder.springdemo.services;

/**
 * @author leon on 4/2/18.
 */

import io.zipcoder.springdemo.domain.Poll;
import io.zipcoder.springdemo.repo.PollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class PollService {
    @Autowired
    private PollRepository pollRepository;

    public PollService() {}

    public PollService(PollRepository pollRepository) {
        this.pollRepository = pollRepository;
    }

    public ResponseEntity<?> createPoll(Poll poll) {
        poll = pollRepository.save(poll);

        // Set the location header for the newly created resource
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(poll.getId())
                .toUri();
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    public ResponseEntity<Poll> getPoll(Long pollId) {
        Poll p = pollRepository.findOne(pollId);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }


    public ResponseEntity<Iterable<Poll>> getPolls() {
        Iterable<Poll> polls = pollRepository.findAll();
        return new ResponseEntity<>(polls, HttpStatus.OK);
    }

    public ResponseEntity<?> updatePoll(Poll poll, Long pollId) {
        // Save the entity
        Poll p = pollRepository.save(poll);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public ResponseEntity<?> deletePoll(Long pollId) {
        pollRepository.delete(pollId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

