package com.galvanize.cryptozoology.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.cryptozoology.model.Animal;

@WebMvcTest(AnimalController.class)
public class AnimalControllerTest {

	private String animalPath = "src/test/resources/newAnimal.json";
	
	@Autowired
	MockMvc mockMvc;

	/**
	 * Tests creation of animal
	 * @throws Exception 
	 */
	@Test
	public void test_addAnimal_ReturnsCreatedAnimal() throws Exception {		
		mockMvc.perform(post("/api/zoo/animals").content(createAnimal()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("id").exists())
				.andExpect(jsonPath("name").value("Lion"))
				.andExpect(jsonPath("type").value("walking"));
	}
	
	
	private String createAnimal() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Animal animal = mapper.readValue(new File(animalPath), Animal.class);
		return mapper.writeValueAsString(animal);
		
	}
	

}
