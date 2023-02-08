package com.example.threetypesdidemo.dao;

import com.example.threetypesdidemo.model.Dog;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DogsRepository {

    public DogsRepository() {
        System.out.println("DogsRepository no-argument constructor called");
    }

    public List<Dog> getAllDogs() {
        System.out.println("DogsRepository getAllDogs called");
        return null;
    }
}
