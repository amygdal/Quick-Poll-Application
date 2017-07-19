package io.zipcoder.springdemo.repo;

import io.zipcoder.springdemo.domain.Option;
import org.springframework.data.repository.CrudRepository;

public interface OptionRepository extends CrudRepository<Option, Long> {
}