package com.brickhire.Brickhire;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Document(collection = "providers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrickHire {
@Id
private ObjectId id;
private String prvId;
private String category;
private String description;
private String location;
private String name;
private String phoneNumber;
private List<String> services;
@DBRef
private List<BrickHireRating> rating;
@DBRef
private List<BrickHireReview> reviewIds;

    public BrickHire(String prvId, String category, String description, String location, String name, String phoneNumber, List<String> services) {
        this.prvId = prvId;
        this.category = category;
        this.description = description;
        this.location = location;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.services = services;
    }
}
