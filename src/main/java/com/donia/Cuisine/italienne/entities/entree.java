package com.donia.Cuisine.italienne.entities;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "entree")
@PrimaryKeyJoinColumn(name = "id")
public class entree extends met {

	public entree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public entree(String nom, float prix) {
		super(nom, prix);
		
	}

}
