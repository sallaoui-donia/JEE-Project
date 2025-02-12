package com.donia.Cuisine.italienne.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
public class client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;
	private String  nom;
	private String prenom;
	private LocalDate dateDeNaissance;
	private String courriel;
	private String telephone;
	
	 @OneToMany(mappedBy = "client" ,cascade = CascadeType.REMOVE)
	 @JsonIgnore
	private List<ticket> tickets;



	public client() {
		super();
		
	}
	

	public client(int id, String nom, String prenom, LocalDate dateDeNaissance, String courriel, String telephone,
			List<ticket> tickets) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.courriel = courriel;
		this.telephone = telephone;
		this.tickets = tickets;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public  LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}


	public String getCourriel() {
		return courriel;
	}

	public void setCourriel(String courriel) {
		this.courriel = courriel;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public List<ticket> getTickets() {
		return tickets;
	}


	public void setTickets(List<ticket> tickets) {
		this.tickets = tickets;
	}


	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}


	@Override
	public String toString() {
		return "client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance
				+ ", courriel=" + courriel + ", telephone=" + telephone + ", tickets=" + tickets + "]";
	}


	
	}

	
	


