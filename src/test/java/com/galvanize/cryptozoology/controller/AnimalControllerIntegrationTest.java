package com.galvanize.cryptozoology.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.cryptozoology.model.Animal;
import com.galvanize.cryptozoology.repository.ZooRepository;
import com.galvanize.cryptozoology.service.AnimalService;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class AnimalControllerIntegrationTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	AnimalService service;

	@Autowired
	ZooRepository zooRepository;

	@Test
	public void test_addAnimalIntegration_ReturnsCreatedAnimal() throws Exception {
		mockMvc.perform(
				post("/api/zoo/animals")
				.content(animalContentString())
				.contentType(MediaType.APPLICATION_JSON)
				)
				.andExpect(status().isCreated()).andExpect(jsonPath("id").exists())
				.andExpect(jsonPath("name").value("Bird")).andExpect(jsonPath("type").value("flying"));
	}

	@Test
	public void test_getAnimalsIntegration_ReturnsListOfAnimals() throws Exception {
		zooRepository.save(animalContent());
		zooRepository.save(animalContent());
		mockMvc.perform(
				get("/api/zoo/animals")).andExpect(status().isOk()).andExpect(jsonPath("$").isNotEmpty());

	}

	private Animal animalContent() {
		Animal animal = new Animal();
		animal.setName("Bird");
		animal.setType("flying");
		return animal;

	}

	private String animalContentString() throws IOException {
		return new ObjectMapper().writeValueAsString(animalContent());
	}
}
