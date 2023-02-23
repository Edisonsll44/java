package com.ejercicio.conferencia.data.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="conferences")

public class Conference{

    public Conference(String description){
        this.description = description;
    }
    public Conference(){}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description; 

    public long getId(){
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}