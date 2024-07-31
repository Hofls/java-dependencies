package com.github.hofls.javatests.utils.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class Person {
    public int id;
    public String name;
    @JsonFormat(pattern = "yyyy-MM-dd") // this annotation is unnecessary (everything works without it)
    public LocalDate birthDate;
    public List<String> list;

    public Person() {
    }

    public Person(int id, String name, LocalDate birthDate, List<String> list) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.list = list;
    }
}
