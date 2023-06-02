package com.joange.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joange.DTO.ProductDTO;
import com.joange.model.People;
import com.joange.service.PeopleService;

@RestController
@RequestMapping("people")
public class PeopleController {
	private static final Logger myLog=LoggerFactory.getLogger(PeopleController.class);

	@Autowired
	PeopleService peopleService;
	
	@PostMapping()
	public ResponseEntity<People> newProduct(@RequestBody People people) {
		People newPeople=peopleService.savePeople(people);
		return new ResponseEntity<>(newPeople,HttpStatus.OK);
	}
	
	
	@GetMapping()
	public ResponseEntity<?> getAllPeople(){
		List<People> peoples=peopleService.listAllPeople();
		
		if (peoples.isEmpty())
			return new ResponseEntity<>("Sin clientes en la base de datos",HttpStatus.OK);
		else
			return new ResponseEntity<>(peoples,HttpStatus.OK);

	}
	
	@GetMapping("/{id}/")
	public ResponseEntity<?> getPeople(@PathVariable Long id){
		People people=peopleService.getPeopleById(id);
		
		if (people == null)
			return new ResponseEntity<>("Sin productos en la base de datos",HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<>(people,HttpStatus.OK);

	}
}
