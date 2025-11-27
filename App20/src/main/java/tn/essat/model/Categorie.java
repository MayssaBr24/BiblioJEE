package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Categorie {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	
	
	
	private int id; 
	private String titre;
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public Categorie(int id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
	} 
	
	
	
	

}
