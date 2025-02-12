package com.donia.Cuisine.italienne.entities;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "dessert")
@PrimaryKeyJoinColumn(name = "id")
public class dessert extends met{

	public dessert() {
		super();
	
	}

	public dessert(String nom, float prix) {
		super(nom, prix);
	
	}
	
	
	

}
