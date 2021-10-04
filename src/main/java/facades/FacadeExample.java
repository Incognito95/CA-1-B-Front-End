package facades;

import dtos.RenameMeDTO;
import entities.Person;
import entities.RenameMe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import utils.EMF_Creator;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeExample {

    private static FacadeExample instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private FacadeExample() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static FacadeExample getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeExample();
        }
        return instance;
    }
    
    
//    void createPerson() {
//        
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//            Query q = em.createNativeQuery("INSERT INTO person SET first_name = 'admin', last_name = 'admin', fk_hobby = 1, email = 'admin@admin.com'");
//            
//            int createPerson = q.executeUpdate();
//            System.out.println("-------------------------------------------------");
//            System.out.println("You have inserted: " + createPerson);
//
//            em.getTransaction().commit();
//
//        } finally {
//            em.close();
//        }
//    }
//    
//    void editPerson() {
//        
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//            Query q = em.createNativeQuery("UPDATE person SET email = 'hello@world.com', first_name = 'hello', last_name = 'world' WHERE id = 100");
//            
//            int createPerson = q.executeUpdate();
//            System.out.println("-------------------------------------------------");
//            System.out.println("You have inserted: " + createPerson);
//
//            em.getTransaction().commit();
//
//        } finally {
//            em.close();
//        }
//    }

    
//    void getPerson() {
//        
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//            Query q = em.createNativeQuery("SELECT first_name FROM person INNER JOIN phone WHERE number = 1234");
//            
//            int createPerson = q.executeUpdate();
//            System.out.println("-------------------------------------------------");
//            System.out.println("You have inserted: " + createPerson);
//
//            em.getTransaction().commit();
//
//        } finally {
//            em.close();
//        }
//    }

    
//    void getHobbyByNumbers() {
//        
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//            Query q = em.createNativeQuery("SELECT COUNT(name) FROM person INNER JOIN hobby WHERE hobby_id = 1");
//            
//            int createPerson = q.executeUpdate();
//            System.out.println("-------------------------------------------------");
//            System.out.println("You have inserted: " + createPerson);
//
//            em.getTransaction().commit();
//
//        } finally {
//            em.close();
//        }
//    }
//
//    
//    void getCity() {
//        
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//            Query q = em.createNativeQuery("SELECT city_name FROM city WHERE zip_code = 2450");
//            
//            int createPerson = q.executeUpdate();
//            System.out.println("-------------------------------------------------");
//            System.out.println("You have inserted: " + createPerson);
//
//            em.getTransaction().commit();
//
//        } finally {
//            em.close();
//        }
//    }
//
//    
//    void getZipCodes() {
//        
//        EntityManager em = emf.createEntityManager();
//
//        try {
//            em.getTransaction().begin();
//            Query q = em.createNativeQuery("SELECT zip_code FROM city WHERE country_name = \"Danmark\"");
//            
//            int createPerson = q.executeUpdate();
//            System.out.println("-------------------------------------------------");
//            System.out.println("You have inserted: " + createPerson);
//
//            em.getTransaction().commit();
//
//        } finally {
//            em.close();
//        }
//    }

    
    void getPersonsByHobby(int hobby) {
        
        EntityManager em = emf.createEntityManager();

        try {
          
            Query q = em.createQuery("SELECT p FROM person p WHERE p.hobby = :hobby");
            q.setParameter("hobby", hobby);
            int createPerson = q.executeUpdate();
            System.out.println("-------------------------------------------------");
            System.out.println("You have inserted: " + createPerson);


        } finally {
            em.close();
        }
    }
   
    
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        FacadeExample fe = getFacadeExample(emf);
//        fe.editPerson(); // edit
//        fe.getPerson(); // getPerson
//        fe.getHobbyByNumbers(); // getHobbyByNumbers
//        fe.getCity(); // getCity
//        fe.getZipCodes(); // getZipCodes
          fe.getPersonsByHobby(100); // getHobbyByPersons
//        fe.createPerson(); // createPerson

    }

//    void getPerson(int i) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public void GetPeopleWithAHobby() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

}