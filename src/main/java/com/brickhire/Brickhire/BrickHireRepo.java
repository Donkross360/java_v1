package com.brickhire.Brickhire;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface BrickHireRepo extends MongoRepository<BrickHire, ObjectId> {

    Optional<BrickHire> findBrickHireByPrvId(String prvId);
}
