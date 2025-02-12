package com.donia.Cuisine.italienne.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "met")
@Inheritance(strategy =InheritanceType.JOINED)
public class met {
	
	@Id
	private String nom;
	private float prix;
	
	  @ManyToMany(mappedBy = "mets")
	 @JsonIgnore
	private List<ticket> tickets;
	
	
	public met() {
		super();
		
	}
	public met(String nom, float prix) {
		super();
		this.nom = nom;
		this.prix = prix;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	public List<ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<ticket> tickets) {
		this.tickets = tickets;
	}
	@Override
	public String toString() {
		return "met [nom=" + nom + ", prix=" + prix + ", tickets=" + tickets + "]";
	}
	
	
	
	
	

}
