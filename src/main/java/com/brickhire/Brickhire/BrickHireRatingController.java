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
@RequestMapping("/api/v1/ratings")
public class BrickHireRatingController {
    @Autowired
    private BrickHireRatingService brickHireRatingService;
    @PostMapping
    public ResponseEntity<BrickHireRating> createRating(@RequestBody Map<String, String> payload) throws IOException {
        try {
            BrickHireRating createdRating = brickHireRatingService.createRating(payload.get("ratingBody"), payload.get("prvId"));
            return new ResponseEntity<>(createdRating, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
