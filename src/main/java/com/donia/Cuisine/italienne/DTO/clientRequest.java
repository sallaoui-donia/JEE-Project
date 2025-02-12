package com.donia.Cuisine.italienne.DTO;

import java.time.LocalDate;

	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class clientRequest {
		private String nom;
		private String prenom;
	    private LocalDate dateofbirth;
		private String couriel;
		private int telephone;

}
