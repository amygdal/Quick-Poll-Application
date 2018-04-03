package io.zipcoder.springdemo.repo;

import io.zipcoder.springdemo.domain.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepositoryTest extends CrudRepository<Option, Long> {
}