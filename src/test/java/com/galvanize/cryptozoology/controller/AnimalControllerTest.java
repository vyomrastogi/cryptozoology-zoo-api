package com.galvanize.cryptozoology.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.galvanize.cryptozoology.model.Animal;
import com.galvanize.cryptozoology.service.AnimalService;

@WebMvcTest(AnimalController.class)
public class AnimalControllerTest {

	private String animalPath = "src/test/resources/newAnimal.json";
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	AnimalService animalService;

	/**
	 * Tests creation of animal
	 * @throws Exception 
	 */
	@Test
	public void test_addAnimal_ReturnsCreatedAnimal() throws Exception {	
		when(animalService.addAnimal(Mockito.any(Animal.class))).thenReturn(new Animal("Lion","walking"));
		mockMvc.perform(post("/api/zoo/animals").content(animalContent()).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("id").exists())
				.andExpect(jsonPath("name").value("Lion"))
				.andExpect(jsonPath("type").value("walking"));
	}
	
	
	private String animalContent() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Animal animal = mapper.readValue(new File(animalPath), Animal.class);
		return mapper.writeValueAsString(animal);
		
	}
	

}
