package tn.essat.dao;

import java.util.List;

import tn.essat.model.Categorie;
import tn.essat.model.Emprunt;
import tn.essat.model.Livre;
import tn.essat.model.Utilisteur;

public interface IGestion {
  
    public List<Categorie> getAllCats();
    public List<Livre> getAllLivreByCatId(int id);
    
    public void addLivre(Livre lv);
    public void deleteLivre(int id);
    
    public void addUser(Utilisteur user);
    
    public Categorie getCatById(int id);
    public Livre getLivreById(int id);
    
    public Utilisteur getUser(String login, String password);
    
    public List<Emprunt> getEmpruntByUserId(int id);
    public List<Emprunt> getAllEmprunts();
    
    public void addEmprunt(Emprunt emp);
    
    public List<Livre> getAllLivre();
}
