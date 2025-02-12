package com.donia.Cuisine.italienne.entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Entity
public class ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	private Date date;
	private int  nbCouvert;
	private float addition;
	
	@ManyToOne
	/*	@JoinColumn(name = "table_id")*/
		
		private tabl table;
		
		@ManyToOne
		
		/*@JoinColumn(name = "client_id")*/
		private client client;
		
		
		@ManyToMany(cascade = CascadeType.REMOVE)
		    @JoinTable(name = "ticket_met",
		            joinColumns = @JoinColumn(name = "numero"),
		            inverseJoinColumns = @JoinColumn(name = "nom"))
		private List<met>mets;

		
		

		public ticket() {
			super();
			
		}
		


		public ticket(int numero, Date date, int nbCouvert, float addition, tabl table,
				com.donia.Cuisine.italienne.entities.client client, List<met> mets) {
			super();
			this.numero = numero;
			this.date = date;
			this.nbCouvert = nbCouvert;
			this.addition = addition;
			this.table = table;
			this.client = client;
			this.mets = mets;
		}



		public int getNumero() {
			return numero;
		}


		public void setNumero(int numero) {
			this.numero = numero;
		}


	


		public Date getDate() {
			return date;
		}



		public void setDate(Date date) {
			this.date = date;
		}



		public int getNbCouvert() {
			return nbCouvert;
		}


		public void setNbCouvert(int nbCouvert) {
			this.nbCouvert = nbCouvert;
		}


		public float getAddition() {
			return addition;
		}


		public void setAddition(float addition) {
			this.addition = addition;
		}


		public tabl getTable() {
			return table;
		}


		public void setTable(tabl table) {
			this.table = table;
		}


		public client getClient() {
			return client;
		}


		public void setClient(client client) {
			this.client = client;
		}


		public List<met> getMets() {
			return mets;
		}


		public void setMets(List<met> mets) {
			this.mets = mets;
		}



		@Override
		public String toString() {
			return "ticket [numero=" + numero + ", date=" + date + ", nbCouvert=" + nbCouvert + ", addition=" + addition
					+ ", table=" + table + ", client=" + client + ", mets=" + mets + "]";
		}




	

}
