package com.donia.Cuisine.italienne.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class tabRequest {
	
	
	@AllArgsConstructor
	@NoArgsConstructor
	@Data
	public class TableRequest {
		
		private int numero;

		private int nbCouvert;
		
		private String type;

		private float supplement;

	
}
}