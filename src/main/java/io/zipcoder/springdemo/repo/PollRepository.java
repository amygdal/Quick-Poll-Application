package io.zipcoder.springdemo.repo;

import io.zipcoder.springdemo.domain.Poll;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by leon on 7/18/17.
 */
public interface PollRepository extends CrudRepository<Poll, Long> {
}
