package com.brickhire.Brickhire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/reviews")
public class BrickHireReviewController {
    @Autowired
    private BrickHireReviewService brickHireReviewService;
    @PostMapping
    public ResponseEntity<BrickHireReview> createReview(@RequestBody Map<String, String> payload) throws IOException {
        return new ResponseEntity<>(brickHireReviewService.createReview(payload.get("reviewBody"), payload.get("prvId")), HttpStatus.CREATED);
    }
}
