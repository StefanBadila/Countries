package com.stefan.Countries;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/countries")

public class CountryController {
    private final CountryRepository repository;

    public CountryController(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Country> getAll() {
        return repository.findAll();
    }

    @GetMapping("/id/{id}")
    public Country getById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("This id: " + id + " does not exist"));
    }

    @GetMapping("/name/{name}")
    public Country getByName(@PathVariable String name) {
        return repository.findByCountry(name)
                .orElseThrow(() -> new RuntimeException("Name: " + name + " not found"));
    }

    @PostMapping
    public ResponseEntity<?> add(@Valid @RequestBody Country country) {
        if (repository.existsByCountry(country.getCountry())) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("Error: '" + country.getCountry() + "' already exists");
        }
        Country savedCountry = repository.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCountry);
    }

    @PutMapping("/{id}")
    public Country update(@PathVariable Long id, @Valid @RequestBody Country details) {
        return repository.findById(id).map(c -> {
            c.setCountry(details.getCountry());
            c.setCapital(details.getCapital());
            c.setPopulation(details.getPopulation());
            return repository.save(c);
        }).orElseThrow(() -> new RuntimeException("ID not found: " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCountry(@PathVariable Long id) {
        return repository.findById(id)
                .map(country -> {
                    repository.delete(country);
                    return ResponseEntity.ok((Object) country);
                })
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("ID: " + id + " not found"));
    }
}
