package com.donia.Cuisine.italienne.controller;

	
	
	import java.util.List;
	import java.util.NoSuchElementException;

	import javax.validation.Valid;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.validation.FieldError;
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

import com.donia.Cuisine.italienne.service.clientService;
import com.donia.Cuisine.italienne.service.ticketService;


import  com.donia.Cuisine.italienne.DTO.clientRequest;
	import com.donia.Cuisine.italienne.DTO.clientResponse;
	import com.donia.Cuisine.italienne.entities.client;
	import com.donia.Cuisine.italienne.entities.ticket;
	import com.donia.Cuisine.italienne.service.clientService;
	import com.donia.Cuisine.italienne.service.ticketService;

	@RestController
	@RequestMapping("/cLient")
	
	public class clientController {

		private clientService serclient;
	@Autowired
		public clientController(clientService serclient) {
			super();
			this.serclient = serclient;
		}
		
		@GetMapping
		public List<clientResponse> getAll(){
			return serclient.getAllEntities();
		}

		@GetMapping("/{id}")
		public clientResponse getById(@PathVariable("id") Integer id) {
			return serclient.getEntityById(id);
		}
		
		@PostMapping
		public clientResponse createclient(@RequestBody clientRequest client) {
			return serclient.createclient(client);
		}

		@PutMapping("/{id}")
		public clientResponse modifymedecin(@PathVariable("id") Integer id, @RequestBody clientRequest client) {
			return serclient.modifyclient(id, client);
		}

		@DeleteMapping("/{id}")
		public clientResponse deleteById(@PathVariable("id") Integer id) {
			return serclient.deletclient(id);
		}

		@ExceptionHandler(NoSuchElementException.class)
		public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
		
		

		
	}
