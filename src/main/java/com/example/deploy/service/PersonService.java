package com.example.deploy.service;

import com.example.deploy.exception.PersonAlreadyExistException;
import com.example.deploy.exception.PersonNotFoundException;
import com.example.deploy.model.Person;
import com.example.deploy.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final IPersonRepository personRepository;

    public Person save(Person person) {
        if (personRepository.findByIdentification(person.getIdentification()).isPresent()) {
            throw new PersonAlreadyExistException();
        }
        return personRepository.save(person);
    }

    public Person findByIdentification(Long identification) {
        return personRepository.findByIdentification(identification)
                .orElseThrow(PersonNotFoundException::new);
    }

}
