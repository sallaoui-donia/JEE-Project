package com.donia.Cuisine.italienne.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class metRequest {
	private int id;
    private String nom;

    private float prix;

}
