package com.donia.Cuisine.italienne.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class tabResponse {

	private int numero;
	private int nbCouvert;
	private String type;
	private float supplement;

}
