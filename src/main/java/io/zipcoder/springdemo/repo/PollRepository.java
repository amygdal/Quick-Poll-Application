package io.zipcoder.springdemo.repo;

import io.zipcoder.springdemo.domain.Poll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by leon on 7/18/17.
 */
@Repository
public interface PollRepository extends CrudRepository<Poll, Long> {
}
