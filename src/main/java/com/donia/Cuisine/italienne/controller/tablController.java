package com.donia.Cuisine.italienne.controller;


	import java.text.ParseException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
	import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.donia.Cuisine.italienne.entities.tabl;
	import com.donia.Cuisine.italienne.service.tablService;

import com.donia.Cuisine.italienne.DTO.tabRequest;
import com.donia.Cuisine.italienne.DTO.tabResponse;
import com.donia.Cuisine.italienne.entities.tabl;
import com.donia.Cuisine.italienne.service.tablService;
	@RestController
	@RequestMapping("/table")
	public class tablController {
	 private tablService servicetable;

	 @Autowired
	public tablController(tablService servicetable) {
		super();
		this.servicetable = servicetable;
	}
	 @GetMapping
		public List<tabResponse> getAll(){
			return servicetable.getAllEntities();
		}
		
		@GetMapping("/{id}")
		public tabResponse getById(@PathVariable("id") Integer id) {
			return servicetable.getEntityById(id);
		}
		@GetMapping("/num/{numero}")
		public tabl getBynumero(@PathVariable("numero") int numero) {
			return servicetable.findbynumero(numero);
		}
		
		@PostMapping
		public tabResponse createtable(@RequestBody tabRequest table) {
			return servicetable.createtable(table);
		}
		
		@PutMapping("/{id}")
		public tabResponse modifymedecin(@PathVariable("id") Integer id, @RequestBody tabRequest newtable) {
			return servicetable.modifytable(id, newtable);
		}
			@DeleteMapping("/{id}")
		public tabResponse deleteById(@PathVariable("id") Integer id) {
			return servicetable.deletetable(id);
		}
		
		@ExceptionHandler(NoSuchElementException.class)
		public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}



