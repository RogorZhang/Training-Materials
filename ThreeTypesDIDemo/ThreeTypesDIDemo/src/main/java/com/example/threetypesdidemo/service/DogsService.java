package com.example.threetypesdidemo.service;

import com.example.threetypesdidemo.dao.DogsRepository;
import com.example.threetypesdidemo.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class DogsService {
    @Autowired
    private DogsRepository repository;

    public DogsService() {
        System.out.println("DogsService no arg constructor called");
    }


    public DogsService(DogsRepository repository) {
        System.out.println("DogsService arg constructor called");
        this.repository = repository;
    }


    public void setRepository(DogsRepository repository) {
        System.out.println("DogsService setter called");
        this.repository = repository;
    }

    public List<Dog> getDogs() {
        return repository.getAllDogs();
    }
}
