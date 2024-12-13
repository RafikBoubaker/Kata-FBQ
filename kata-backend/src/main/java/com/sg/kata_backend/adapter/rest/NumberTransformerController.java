package com.sg.kata_backend.adapter.rest;

import com.sg.kata_backend.domain.model.NumberTransformerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transform")
@CrossOrigin(origins = "http://localhost:4200")
public class NumberTransformerController {

    private final NumberTransformerService transformerService;

    @Autowired
    public NumberTransformerController(NumberTransformerService transformerService) {
        this.transformerService = transformerService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<String> transformNumber(@PathVariable int number) {
        try {
            String result = transformerService.transform(number);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Veuillez entrer un nombre entre 0 et 100.");
        }
    }
}
