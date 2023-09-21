package edu.laplateforme.runtrackjavaspring.service;

import edu.laplateforme.runtrackjavaspring.model.Person;
import edu.laplateforme.runtrackjavaspring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPerson() {
        return this.personRepository.findAll();
    }

    public void savePerson(Person person) {
        this.personRepository.save(person);
    }

    public void deletePersonById(Long id) {
        this.personRepository.deleteById(id);
    }
}
