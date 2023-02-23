package com.ejercicio.conferencia.repository;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ConferenceRepositoryTest {

    @Id
    private long id;
    private String description; 

    public ConferenceRepositoryTest(String description){
        this.description = description;
    }
}
