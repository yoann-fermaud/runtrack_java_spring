package edu.laplateforme.runtrackjavaspring.controller;

import edu.laplateforme.runtrackjavaspring.model.FormModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ViewController {

    @GetMapping("/job02")
    public String displayMessage(Model model) {
        model.addAttribute("message", "Hello World print in ThymeLeaf");
        return "view";
    }

    @GetMapping("/job03")
    public String displayList(Model model) {
        List<String> list = new ArrayList<>();
        list.add("Item 1");
        list.add("Item 2");
        list.add("Item 3");
        list.add("Item 4");
        list.add("Item 5");
        model.addAttribute("list", list);
        return "view";
    }

//    @GetMapping("/job04")
//    public String displayForm() {
//        return "view";
//    }

//    @PostMapping("/job04")
//    public String submitForm(@RequestParam("name") String name, Model model) {
//        String message = "Bienvenue, " + name + " !";
//        model.addAttribute("message", message);
//        return "view";
//    }

    @GetMapping("/job05")
    public String displayForm() {
        return "view";
    }

    @PostMapping("/job05")
    public String submitForm(@Valid FormModel formModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "view";
        }
        String message = "Bienvenue, " + formModel.getName() + "! Tu as " + formModel.getAge() + " ans.";
        model.addAttribute("message", message);
        return "view";
    }

}
