package com.example.deploy.controller;

import com.example.deploy.model.Person;
import com.example.deploy.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<Person> save(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findByIdentification(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findByIdentification(id));
    }
}
