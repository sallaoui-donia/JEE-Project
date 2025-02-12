package com.donia.Cuisine.italienne.DTO;

import java.time.LocalDateTime;
import java.util.List;

import com.donia.Cuisine.italienne.entities.tabl;
import com.donia.Cuisine.italienne.entities.client;
import com.donia.Cuisine.italienne.entities.met;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ticketResponse {
	 private LocalDateTime date;
	  private int nbCouvert;
	  private float addition;
	  private tabl table;
	  private client client;
	  private List<met> mets;
	

}
