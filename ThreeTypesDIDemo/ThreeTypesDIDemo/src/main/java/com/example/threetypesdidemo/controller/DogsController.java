package com.example.threetypesdidemo.controller;

import com.example.threetypesdidemo.model.Dog;
import com.example.threetypesdidemo.service.DogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DogsController {
    @Autowired
    private DogsService service;


    public DogsController() {
        System.out.println("DogsController no arg constructor called");
    }


    public DogsController(DogsService service) {
        System.out.println("DogsController arg constructor called");
        this.service = service;
    }


    public void setService(DogsService service) {
        System.out.println("DogsController setter called");
        this.service = service;
    }

    public List<Dog> getAllDogs() {
        return service.getDogs();
    }
}
