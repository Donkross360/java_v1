package com.brickhire.Brickhire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/providers")
public class BrickHireController {
    @Autowired
    private BrickHireService brickHireService;
    @GetMapping
    public ResponseEntity<List<BrickHire>> getAllProviders() throws IOException {
        return new ResponseEntity<List<BrickHire>>(brickHireService.allProviders(), HttpStatus.OK);
    }
    @GetMapping("/{prvId}")
    public ResponseEntity<Optional<BrickHire>> getSingleProvider(@PathVariable String prvId) throws IOException {
        return new ResponseEntity<>(brickHireService.singleProvider(prvId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BrickHire> createProvider(@RequestBody BrickHire brickHire) throws IOException {
        return new ResponseEntity<>(brickHireService.saveData(brickHire.getCategory(), brickHire.getDescription(), brickHire.getLocation(), brickHire.getName(), brickHire.getPhoneNumber(), brickHire.getServices()), HttpStatus.CREATED);
    }
}
