package edu.laplateforme.runtrackjavaspring.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class FormModel {
    @NotEmpty(message = "Name is required")
    private String name;

    @Min(value = 15, message = "Cannot be less than 0")
    private int age;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
