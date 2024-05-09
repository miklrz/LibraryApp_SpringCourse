package ru.hxastur.springcourse.model;

import org.springframework.stereotype.Component;

@Component
public class Person {
    private int person_id;
    private String name;
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
