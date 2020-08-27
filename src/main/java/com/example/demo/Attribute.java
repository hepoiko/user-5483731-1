package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Attribute")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Attribute 
{
    @Id
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String name;
    
    @Override
    public String toString()
    {
        return "Attribute [id=" + id + ", name=" + name + "]";
    }


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public String getName()
    {
        return name;
    }


    public void setName(String name)
    {
        this.name = name;
    }

    
}