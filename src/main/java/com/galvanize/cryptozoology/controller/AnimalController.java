package com.galvanize.cryptozoology.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.galvanize.cryptozoology.model.Animal;
import com.galvanize.cryptozoology.service.AnimalService;

@RestController
@RequestMapping("api/zoo")
public class AnimalController {
	
	AnimalService animalService;
	
	public AnimalController(AnimalService service) {
		this.animalService = service;
	}
	

	@PostMapping("/animals")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Animal addAnimal(@RequestBody Animal animal) {
		return animalService.addAnimal(animal);
	}
	
	@GetMapping("/animals")
	public List<Animal> getAnimals() {
		return animalService.getAnimals();
	}
	
	@PutMapping("/animals/{id}/treat")
	public Animal treatAnimal(@PathVariable int id) {
		return animalService.treatAnimal(id);
	}
}
