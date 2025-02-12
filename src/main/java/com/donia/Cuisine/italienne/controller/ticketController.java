package com.donia.Cuisine.italienne.controller;

import java.time.Instant;
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

import com.donia.Cuisine.italienne.DTO.metResponse;
import com.donia.Cuisine.italienne.DTO.tabResponse;
import com.donia.Cuisine.italienne.entities.ticket;
import com.donia.Cuisine.italienne.service.ticketService;



@RestController
@RequestMapping("/ticket")
public class ticketController {

	private ticketService serviceticket;
	
	
@Autowired
	public ticketController(ticketService serviceticket) {
		super();
		this.serviceticket = serviceticket;
	}
	
	
@GetMapping
public List<ticket> getAll(){
	return serviceticket.getAllEntities();
}

@GetMapping("/{id}")
public ticket getById(@PathVariable("id") Integer id) {
	return serviceticket.getEntityById(id);
}
@GetMapping("clientjour/{id}")
public Instant clientjour(@PathVariable("id") Integer id) {
	return serviceticket.mostresrvedday(id);
}
@GetMapping("/most")
public tabResponse most() {
	return serviceticket.mostReservedTable();
}
@GetMapping("/x")
public String Revnue() {
	return serviceticket.RevenuejSm();
}

@PostMapping
public ticket createticket(@RequestBody ticket ticket) {
	return serviceticket.createTicket(ticket);
}

@PutMapping("/{id}")
public ticket modifyticket(@PathVariable("id") Integer id, @RequestBody ticket newticket) {
	return serviceticket.modifyticket(id, newticket);
}
@DeleteMapping("/{id}")
public ticket deleteById(@PathVariable("id") Integer id) {
	return serviceticket.deleteticket(id);
}

@ExceptionHandler(NoSuchElementException.class)
public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
	return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
}


@GetMapping("/revenue/period/{begin}/{end}")
public Double RevenuePeriod(@PathVariable("begin") Instant begin, @PathVariable("end") Instant end){
    return serviceticket.revenudansperiode(begin, end);
}
@GetMapping("/client/fidel/{begin}/{end}")
public com.donia.Cuisine.italienne.entities.client clientplusFidel(@PathVariable("begin") Instant begin, @PathVariable("end") Instant end){
    return serviceticket.clientplusFidel(begin, end);
}	
	
@GetMapping("/top/plat/{begin}/{end}")
public metResponse getTopPlat(@PathVariable("begin") Instant begin, @PathVariable("end") Instant end){
    return serviceticket.mostBuyedPlat(begin,end);
	
	
}


}
