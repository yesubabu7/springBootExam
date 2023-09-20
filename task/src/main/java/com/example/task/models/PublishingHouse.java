package com.example.task.models;

import java.util.ArrayList;
import java.util.List;

public class PublishingHouse {
	
	
    private Long id;
    private String name;
    

    public PublishingHouse() {
        // Default constructor
    }

    public PublishingHouse(Long id, String name) {
        this.id = id;
        this.name = name;
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   

    @Override
    public String toString() {
        return "PublishingHouse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                
                '}';
    }
}
