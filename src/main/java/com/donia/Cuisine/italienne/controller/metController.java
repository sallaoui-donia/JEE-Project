package com.donia.Cuisine.italienne.controller;

import java.util.List;
import java.util.NoSuchElementException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donia.Cuisine.italienne.service.metService;

import com.donia.Cuisine.italienne.DTO.metRequest;
import com.donia.Cuisine.italienne.DTO.metResponse;
import com.donia.Cuisine.italienne.entities.met;
import com.donia.Cuisine.italienne.service.metService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/met")
public class metController {
private metService servicemet;
@Autowired
public metController(metService servicemet) {
	super();
	this.servicemet = servicemet;
}
@GetMapping
public List<metResponse> getAll(){
	return servicemet.getAllEntities();
}

@GetMapping("/{id}")
public metResponse getById(@PathVariable("id") Integer id) {
	return servicemet.getEntityById(id);
}
@GetMapping("/plat/{nom}")
public met getById(@PathVariable("nom") String nom) {
	return servicemet.getbynom(nom);
}

@PostMapping("/plat")
public metResponse createPlat(@RequestBody metRequest met) {
	return servicemet.createplat(met);
}
@PostMapping("/dessert")
public metResponse createdessert(@RequestBody metRequest met) {
	return servicemet.createdessert(met);
}
@PostMapping("/entree")
public metResponse createentree(@RequestBody metRequest met) {
	return servicemet.createentree(met);
}
@PutMapping("/{id}")
public metResponse modifymedecin(@PathVariable("id") Integer id, @RequestBody metRequest newmet) {
	return servicemet.modifymet(id, newmet);
}

@DeleteMapping("/{id}")
public metResponse deleteById(@PathVariable("id") Integer id) {
	return servicemet.deletemet(id);
}

@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
	return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
}


	
	
	
}
