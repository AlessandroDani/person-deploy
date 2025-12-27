package com.example.deploy.controller;

import com.example.deploy.model.Person;
import com.example.deploy.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    @GetMapping("/{id}")
    public Person findByIdentification(@PathVariable Long id) {
        return personService.findByIdentification(id);
    }
}
