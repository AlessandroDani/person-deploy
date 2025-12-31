package com.example.deploy.controller;

import com.example.deploy.model.PersonDynamo;
import com.example.deploy.service.PersonServiceDynamo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PersonController {
    private final PersonServiceDynamo personServiceDynamo;

    @PutMapping
    public ResponseEntity<Map<String, Object> > updatePerson(@RequestBody PersonDynamo person) {
        personServiceDynamo.update(person);
        return ResponseEntity.ok(Map.of(
                "message", "Usuario actualizado con éxito (Spring Boot)",
                "technology", "Java",
                "data", person
        ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object> > deletePerson(@PathVariable String id) {
        personServiceDynamo.delete(id);

        return ResponseEntity.ok(Map.of(
                "message", "Usuario eliminado con éxito",
                "id_eliminado", id
        ));
    }
}
