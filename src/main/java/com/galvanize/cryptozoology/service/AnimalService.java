package com.galvanize.cryptozoology.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.galvanize.cryptozoology.model.Animal;
import com.galvanize.cryptozoology.repository.ZooRepository;

@Service
public class AnimalService {
	
	private ZooRepository zooRepository;
	
	public AnimalService(ZooRepository zooRepository) {
		this.zooRepository = zooRepository;
	}

	public Animal addAnimal(Animal animal) {
		return zooRepository.save(animal);
	}

	public List<Animal> getAnimals() {
		return zooRepository.findAll();
	}

}
