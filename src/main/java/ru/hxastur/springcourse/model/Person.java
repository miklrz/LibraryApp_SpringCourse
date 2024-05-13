package ru.hxastur.springcourse.model;

import jakarta.validation.constraints.*;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private int person_id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min  = 1, max = 30, message = "Name should be greater than 1 and less than 30")
    @Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+ [A-Z]\\w+", message="Name should be in this format: Name Surname Patronymic")
    private String name;

//    @NotEmpty(message = "Year of birth should not be empty")
    @Max(value = 2025, message="Year of birth should be less than 2025")
    @Min(value = 1900, message="Year of birth should be grater than 1900")
    private int year_of_birth;

    public Person(){}

    public Person(int person_id, String name, int year_of_birth){
        this.person_id = person_id;
        this.name = name;
        this.year_of_birth = year_of_birth;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

}
