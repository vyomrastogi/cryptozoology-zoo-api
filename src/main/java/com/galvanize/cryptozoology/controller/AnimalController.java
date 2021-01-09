package com.galvanize.cryptozoology.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.galvanize.cryptozoology.model.Animal;

@RestController
@RequestMapping("api/zoo")
public class AnimalController {

	@PostMapping("/animals")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Animal addAnimal(@RequestBody Animal animal) {
		animal.setId("123");
		return animal;
	}
}
