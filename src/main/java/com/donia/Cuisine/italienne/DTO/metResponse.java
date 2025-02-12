package com.donia.Cuisine.italienne.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class metResponse {
	private int id;
	private String nom;
    private float prix;

}
