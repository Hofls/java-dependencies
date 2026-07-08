package com.github.hofls.hiber.storage.jpa_repository;


import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Data
public class Campus {

    @Id
    @GeneratedValue
    private long id;

    private String name;

}
