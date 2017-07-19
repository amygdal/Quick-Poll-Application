package io.zipcoder.springdemo.controller;

import io.zipcoder.springdemo.domain.Vote;
import io.zipcoder.springdemo.dtos.OptionCount;
import io.zipcoder.springdemo.dtos.VoteResult;
import io.zipcoder.springdemo.repo.VoteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ComputeResultController {
    @Inject
    private VoteRepository voteRepository;

    @RequestMapping(value = "/computeresult", method = RequestMethod.GET)
    public ResponseEntity<?> computeResult(@RequestParam Long pollId) {
        VoteResult voteResult = new VoteResult();
        Iterable<Vote> allVotes = voteRepository.findVotesByPoll(pollId);

        // Algorithm to count votes
        return new ResponseEntity<VoteResult>(voteResult, HttpStatus.OK);
    }

    public Map<Long, OptionCount> getVoteResults(long pollId) {
        Map<Long, OptionCount> voteResults = new HashMap<Long, OptionCount>();
        for (Vote v : voteRepository.findVotesByPoll(pollId)) {
            // Get the OptionCount corresponding to this Option
            OptionCount optionCount = voteResults.get(v.getOption().getId());
            if (optionCount == null) {
                optionCount = new OptionCount();
                optionCount.setOptionId(v.getOption().getId());
                voteResults.put(v.getOption().getId(), optionCount);
            }
            optionCount.setCount(optionCount.getCount() + 1);
        }
        return voteResults;
    }
}