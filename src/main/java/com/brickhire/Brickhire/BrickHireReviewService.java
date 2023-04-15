package com.brickhire.Brickhire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class BrickHireReviewService {
    @Autowired
    private BrickHireReviewRepo brickHireReviewRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    public BrickHireReview createReview(String reviewBody, String prvId) {

        BrickHireReview brickHireReview = brickHireReviewRepo.insert(new BrickHireReview(reviewBody));

        mongoTemplate.update(BrickHire.class)
                .matching(Criteria.where("prvId").is(prvId))
                .apply(new Update().push("reviewIds").value(brickHireReview))
                .first();
        return brickHireReview;
    }
}
