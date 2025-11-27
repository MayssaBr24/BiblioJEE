package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 

public class Utilisteur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id ; 
	private String nom ; 
	private String login ; 
	private String password ;
	private String role ;
	public Utilisteur(int id, String nom, String login, String password, String role) {
		super();
		this.id = id;
		this.nom = nom;
		this.login = login;
		this.password = password;
		this.role = role;
	}
	public Utilisteur() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	} 
	
	
	

}
