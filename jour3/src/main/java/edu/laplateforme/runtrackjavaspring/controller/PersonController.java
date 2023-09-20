package edu.laplateforme.runtrackjavaspring.controller;

import edu.laplateforme.runtrackjavaspring.model.Person;
import edu.laplateforme.runtrackjavaspring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/persons")
    public String getPersonList(Model model) {
        List<Person> personList = personRepository.findAll();
        model.addAttribute("persons", personList);
        return "personList";
    }

    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "add";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return "redirect:/persons/";
    }
}
