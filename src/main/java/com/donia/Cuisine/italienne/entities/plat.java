package com.donia.Cuisine.italienne.entities;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "plat")
@PrimaryKeyJoinColumn(name = "id")
public class plat extends met  {

	public plat() {
		super();
	
	}

	public plat(String nom, float prix) {
		super(nom, prix);
		
	}
	

}
