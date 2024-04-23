package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals;

    @Value("${project.developer.fullname}")
    private String fullName;

    @Value("${course.name}")
    private String courseName;

    @PostConstruct
    public void loadAll(){
        this.animals = new HashMap<>();
        this.animals.put(1, new Animal(1, "aslan"));
    }

    @GetMapping
    public List<Animal> getAnimals(){
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal getAnimal(@PathVariable Integer id){
        return animals.get(id);
    }

    @PostMapping
    public Animal addAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal animal){
        animals.put(id, animal);
        return animal;
    }

    @DeleteMapping("{id}")
    public Animal deleteAnimal(@PathVariable Integer id){
        Animal animal = animals.get(id);
        animals.remove(id, animal);
        return animal;
    }


}
