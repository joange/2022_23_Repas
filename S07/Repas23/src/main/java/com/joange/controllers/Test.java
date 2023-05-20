package com.joange.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class Test {
	
	@Value("${aplicacion.nombre}")
	public String nombreApp;

	@GetMapping("/")
	public String hello() {
		return "Hello world!";
	}
	
	@GetMapping("/name")
	public String name(@RequestParam String name) {
		return "Hello <b>" + name +"</b> to " + nombreApp;
	}
	
	@GetMapping("/people")
	public String people(@RequestBody Object people) {
		return "Hello <br>" + people +"<br>";
	}
	
	@GetMapping("/people/{data}/year")
	public String birthday(@PathVariable int year) {
		return "Hello to all people who were born in " + year;
	}
	
}
