package com.alan.feeder.repository;

import com.alan.feeder.model.upwork.Job;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by aleh on 11/30/16.
 */
public interface JobRepository extends MongoRepository<Job,String>{

//    @Query()
//    Set<String> findId();

}
