package com.sirius.pet.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sirius.petservice.api.PetsApi;
import com.sirius.petservice.models.Pet;


@RestController
@RequestMapping("${openapi.reflectoring.base-path:/api}")
public class PetController implements PetsApi {

	@Override
	public ResponseEntity<List<Pet>> listPets() {
		
		System.out.println("API Service call to List Pets");
		
		List<Pet> pets = new ArrayList<>();
		
		Pet pet = new Pet();
		pet.setId("1");
		pet.setName("Dog");
		pet.setStatus("Available");
		pets.add(pet);
		
		Pet pet1 = new Pet();
		pet1.setId("2");
		pet1.setName("Cat");
		pet1.setStatus("NA");
		pets.add(pet1);
		
		
		return new ResponseEntity<>(pets, HttpStatus.OK);
	}
	
	@GetMapping("/greetings")
	public String sayHello() {
		return "hello";
	}
	
//	@GetMapping("/api/pets")
//	public ResponseEntity<List<Pet>> getPets() {
//		
//		System.out.println("API Service call to List Pets");
//		
//		List<Pet> pets = new ArrayList<>();
//		
//		Pet pet = new Pet();
//		pet.setId("1");
//		pet.setName("Dog");
//		pet.setStatus("Available");
//		pets.add(pet);
//		
//		Pet pet1 = new Pet();
//		pet1.setId("2");
//		pet1.setName("Cat");
//		pet1.setStatus("NA");
//		pets.add(pet1);
//		
//		
//		return new ResponseEntity<>(pets, HttpStatus.OK);
//	}

	@Override
	public ResponseEntity<String> addPet(@Valid Pet body) {
		
		return new ResponseEntity<>(body.getName()+":"+body.getStatus(), HttpStatus.OK);
	}
	

}
