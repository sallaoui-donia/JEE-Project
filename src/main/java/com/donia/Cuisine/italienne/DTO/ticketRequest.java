package com.donia.Cuisine.italienne.DTO;

import java.time.LocalDateTime;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import com.donia.Cuisine.italienne.entities.met;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ticketRequest {
	@JsonDeserialize
	@FutureOrPresent(message = "la date doit etre présente")
	private LocalDateTime date;
	@Positive(message = "ce champ doit etre positive")
	private int nbCouvert;
	@PositiveOrZero(message = "ce champ doit etre positive")
	private float addition;
	@Valid
	private clientRequest client;
	@Valid
	private tabRequest table;
	
	private java.util.List<met> mets;

}
