package edu.laplateforme.runtrackjavaspring.controller;

import edu.laplateforme.runtrackjavaspring.model.Person;
import edu.laplateforme.runtrackjavaspring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/persons")
    public String getPersonList(Model model) {
        model.addAttribute("persons", personService.getAllPerson());
        return "personList";
    }

    @GetMapping("/add")
    public String displayAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "add";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute Person person) {
        personService.savePerson(person);
        return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePersonById(id);
        return "redirect:/persons";
    }
}
