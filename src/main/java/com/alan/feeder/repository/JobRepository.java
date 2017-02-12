package com.alan.feeder.repository;

import com.alan.feeder.model.upwork.Job;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by aleh on 11/30/16.
 */
public interface JobRepository extends MongoRepository<Job, String> {

}
