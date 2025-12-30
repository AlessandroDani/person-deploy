package com.example.deploy.controller;

import com.example.deploy.dto.PersonRequestDto;
import com.example.deploy.model.Person;
import com.example.deploy.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public ResponseEntity<Person> save(@Valid @RequestBody PersonRequestDto personRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(personService.save(Person.fromDTO(personRequestDto)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> findByIdentification(@PathVariable Long id) {
        return ResponseEntity.ok(personService.findByIdentification(id));
    }

    @PutMapping
    public Map<String, Object> updatePerson(@RequestBody Map<String, Object> body) {
        return Map.of(
                "message", "Usuario actualizado con éxito (Spring Boot - PUT)",
                "technology", "Java",
                "method", "PUT",
                "data_recibida", body
        );
    }

    @DeleteMapping
    public Map<String, Object> deletePerson() {
        return Map.of(
                "message", "Usuario eliminado con éxito (Spring Boot - DELETE)",
                "technology", "Java",
                "method", "DELETE"
        );
    }
}
