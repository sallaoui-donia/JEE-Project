package com.donia.Cuisine.italienne.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class tabl {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int numero;
	private int nbCouvert;
	private String  type;
	private float supplement;
	 
	@OneToMany(mappedBy = "table",cascade = CascadeType.REMOVE)
	@JsonIgnore
	private List<ticket> tickets;
	 
	public tabl() {
		super();
		
	}
	public tabl(int nbCouvert, String type, float supplement) {
		super();
	
		this.nbCouvert = nbCouvert;
		this.type = type;
		this.supplement = supplement;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNbCouvert() {
		return nbCouvert;
	}
	public void setNbCouvert(int nbCouvert) {
		this.nbCouvert = nbCouvert;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getSupplement() {
		return supplement;
	}
	public void setSupplement(float supplement) {
		this.supplement = supplement;
	}
	public List<ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<ticket> tickets) {
		this.tickets = tickets;
	}
	 

}
