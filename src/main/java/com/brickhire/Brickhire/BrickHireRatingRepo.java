package com.brickhire.Brickhire;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrickHireRatingRepo extends MongoRepository<BrickHireRating, ObjectId> {
}
