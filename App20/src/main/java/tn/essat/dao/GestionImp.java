package tn.essat.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.mindrot.jbcrypt.BCrypt;

import tn.essat.model.Categorie;
import tn.essat.model.Emprunt;
import tn.essat.model.Livre;
import tn.essat.model.Utilisteur;

public class GestionImp implements IGestion{

    Session session;

    public GestionImp() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        session = sessionFactory.openSession();
    }

    @Override
    public List<Categorie> getAllCats() {
        Query<Categorie> req = session.createQuery("select c from Categorie c", Categorie.class);
        return req.getResultList();
    }

    @Override
    public List<Livre> getAllLivreByCatId(int id) {
        Query<Livre> req = session.createQuery("select lv from Livre lv where lv.cat.id = :x", Livre.class);
        req.setParameter("x", id);
        return req.getResultList();
    }

    @Override
    public void addLivre(Livre lv) {
        session.getTransaction().begin();
        session.save(lv);
        session.getTransaction().commit();
    }

    @Override
    public void deleteLivre(int id) {
        session.getTransaction().begin();
        Livre lv = session.find(Livre.class, id);
        session.delete(lv);
        session.getTransaction().commit();
    }

    @Override
    public void addUser(Utilisteur user) {
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public Categorie getCatById(int id) {
        return session.find(Categorie.class, id);
    }

    @Override
    public Livre getLivreById(int id) {
        return session.find(Livre.class, id);
    }

    @Override
    public Utilisteur getUser(String login, String password) {
        Query<Utilisteur> req = session.createQuery("select u from Utilisteur u where u.login = :x ");
        req.setParameter("x", login);
        List<Utilisteur> liste = req.getResultList();
        
         for (Utilisteur u:liste) {
        	 if (BCrypt.checkpw(password,u.getPassword())) {
        		 return u ; 
        	 }
         }
        
     
        
        if (req.getResultList().size()==0) {
            return null;
        } else {
            return req.getSingleResult();
        }
    }

    @Override
    public List<Emprunt> getEmpruntByUserId(int id) {
        Query<Emprunt> req = session.createQuery("select e from Emprunt e where e.user.id = :x", Emprunt.class);
        req.setParameter("x", id);
        return req.getResultList();
    }

    @Override
    public List<Emprunt> getAllEmprunts() {
        Query<Emprunt> req = session.createQuery("select e from Emprunt e", Emprunt.class);
        return req.getResultList();
    }

    @Override
    public void addEmprunt(Emprunt emp) {
        session.getTransaction().begin();
        session.save(emp);
        session.getTransaction().commit();
    }

	@Override
	public List<Livre> getAllLivre() {
		Query<Livre> req=session.createQuery("select l from Livre l");
				return req.getResultList();
	}

	
}
