package tn.essat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Livre {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ; 
    private String titre ; 
    
    @ManyToOne
     @JoinColumn(name = "cat_id")
    
    private  Categorie cat ;
    
    
public Livre(int id, String titre, Categorie cat) {
	super();
	this.id = id;
	this.titre = titre;
	this.cat = cat;
}
public Livre() {
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
public Categorie getCat() {
	return cat;
}
public void setCat(Categorie cat) {
	this.cat = cat;
} 
 
 
}
