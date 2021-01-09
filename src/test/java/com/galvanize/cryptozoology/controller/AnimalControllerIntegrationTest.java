package com.galvanize.cryptozoology.controller;

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
import com.galvanize.cryptozoology.service.AnimalService;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class AnimalControllerIntegrationTest {
	
	@Autowired
	MockMvc mockMvc;

	@Autowired
	AnimalService service;
	
	@Test
	public void test_addAnimalIntegration_ReturnsCreatedAnimal() throws Exception {
		mockMvc.perform(post("/api/zoo/animals").content(animalContent()).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("id").exists())
		.andExpect(jsonPath("name").value("Bird"))
		.andExpect(jsonPath("type").value("flying"));		
	}
	
	private String animalContent() throws IOException {
		Animal animal = new Animal();
		animal.setName("Bird");
		animal.setType("flying");
		return new ObjectMapper().writeValueAsString(animal);		
	}
}
