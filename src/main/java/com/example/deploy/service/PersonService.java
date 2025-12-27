package com.example.deploy.service;

import com.example.deploy.model.Person;
import com.example.deploy.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person save(Person person) {
        if (personRepository.findByIdentification(person.getIdentification()).isPresent()) {
            throw new RuntimeException("Persona ya existe");
        }
        return personRepository.save(person);
    }

    public Person findByIdentification(Long identification) {
        return personRepository.findByIdentification(identification)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

}
