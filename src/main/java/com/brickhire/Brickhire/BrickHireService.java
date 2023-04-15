package com.brickhire.Brickhire;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BrickHireService {
    @Autowired
    private BrickHireRepo brickHireRepo;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<BrickHire> allProviders() { return brickHireRepo.findAll(); }

    public Optional<BrickHire> singleProvider(String prvId) { return  brickHireRepo.findBrickHireByPrvId(prvId); }

    public BrickHire saveData(String category, String description, String location, String name, String phoneNumber, List<String> services) {

        UUID uuid = UUID.randomUUID();
        BrickHire myBrickHireData = new BrickHire();
        myBrickHireData.setId(new ObjectId());
        myBrickHireData.setPrvId(uuid.toString());
        myBrickHireData.setCategory(category);
        myBrickHireData.setDescription(description);
        myBrickHireData.setLocation(location);
        myBrickHireData.setName(name);
        myBrickHireData.setPhoneNumber(phoneNumber);
        myBrickHireData.setServices(services);
        return mongoTemplate.save(myBrickHireData, "providers");

    }
}
