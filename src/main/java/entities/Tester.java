package entities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entities.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import junit.framework.TestCase;

/**
 *
 * @author danielpedersen
 */
public class Tester extends TestCase {
    
    public static void main(String[] args) {
        
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    EntityManager em = emf.createEntityManager();
    
        
    // using objects to put data into database
    PersonEntity p1 = new PersonEntity("Admin 1");
    PersonEntity p2 = new PersonEntity("Admin 2");
    PersonEntity p3 = new PersonEntity("Admin 3");
    
    HobbyEntity h1 = new HobbyEntity("Basketball");
    HobbyEntity h2 = new HobbyEntity("Formula 1");
    HobbyEntity h3 = new HobbyEntity("The Olympic Games");

    p1.addHobby(h1);
    
    em.getTransaction().begin();
    em.persist(p1);
    em.persist(p2);
    em.persist(p3);
    em.persist(h2);
    em.persist(h3);
    em.getTransaction().commit();
        
    }
   
    
}
