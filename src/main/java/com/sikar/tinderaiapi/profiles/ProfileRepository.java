package com.sikar.tinderaiapi.profiles;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ProfileRepository extends MongoRepository<Profile, String> {
    @Aggregation (pipeline = { "{ $sample: { size: 1 } }" }) // MongoDB aggregation pipeline to get a random profile
    Profile getRandomProfile();
}
