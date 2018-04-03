package io.zipcoder.springdemo.integration;

import io.zipcoder.springdemo.controller.PollController;
import io.zipcoder.springdemo.domain.Poll;
import io.zipcoder.springdemo.services.PollService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author leon on 4/2/18.
 */
@AutoConfigureTestDatabase
public class PollControllerTest {

    private PollService pollService;
    private PollController pollController;

    @Before
    public void setup() {
//        Assert.assertNotNull(restTemplate);
        this.pollService = new MockPollService();
        this.pollController = new PollController(pollService);

    }


    @Test
    public void test() {
        Iterable<Poll> polls = null;
        ResponseEntity expected = new ResponseEntity<Iterable<Poll>>(polls, HttpStatus.OK);

        ResponseEntity<Iterable<Poll>> actual = pollController.getPolls();


        Assert.assertEquals(expected, actual);
    }

}

