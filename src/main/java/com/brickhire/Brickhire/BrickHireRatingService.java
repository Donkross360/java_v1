package com.brickhire.Brickhire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class BrickHireRatingService {
    @Autowired
    private BrickHireRatingRepo brickHireRatingRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    public BrickHireRating createRating(String ratingBody, String prvId) {

        BrickHireRating brickHireRating = brickHireRatingRepo.insert(new BrickHireRating(ratingBody));

        mongoTemplate.update(BrickHire.class)
                .matching(Criteria.where("prvId").is(prvId))
                .apply(new Update().push("rating").value(brickHireRating))
                .first();
        return brickHireRating;
    }
}
