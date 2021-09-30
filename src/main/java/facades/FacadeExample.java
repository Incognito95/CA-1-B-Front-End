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
    
    public Person createPerson(RenameMeDTO rm) {

        EntityManager em = emf.createEntityManager();
        
        try{
        Query q1 = em.createNativeQuery("INSERT INTO person SET email = ?, first_name = ?, last_name = ?");
            List<RenameMeDTO> personList =  q1.getResultList();
        for (RenameMeDTO p: personList) {
            System.out.println("This is the number that belongs to this person: " + personList);
        } 
           
        } finally {
             em.close();
        }
        
        return null;
    }



    public Person editPerson() {
       
        EntityManager em = emf.createEntityManager();
        try{
        Query q1 = em.createNativeQuery("UPDATE person SET email = ?, first_name = ?, last_name = ? WHERE id = ?");
            List<RenameMeDTO> personList =  q1.getResultList();
        for (RenameMeDTO p: personList) {
            System.out.println("This is the number that belongs to this person: " + personList);
        } 
           
        } finally {
             em.close();
        }
        
        return null;
    }

    public Person getPerson(int phone) {
        EntityManager em = emf.createEntityManager();
        try{
            // correct it in database
        Query q1 = em.createNativeQuery("SELECT first_name FROM person INNER JOIN phone WHERE number = 1234");
            List<RenameMeDTO> personList =  q1.getResultList();
        for (RenameMeDTO p: personList) {
            System.out.println("This is the number that belongs to this person: " + personList);
        } 
           
        } finally {
             em.close();
        }
        
        return null;
    }



    public Person getHobbyByNumbers() {
        EntityManager em = emf.createEntityManager();
        try{
        Query q1 = em.createNativeQuery("SELECT COUNT(name) FROM person INNER JOIN hobby WHERE hobby_id = 1");
            List<RenameMeDTO> personList =  q1.getResultList();
        for (RenameMeDTO p: personList) {
            System.out.println("This is the number that belongs to this person: " + personList);
        } 
           
        } finally {
             em.close();
        }
        
        return null;
    }


    public Person getCity() {
         EntityManager em = emf.createEntityManager();
        try{
        Query q1 = em.createNativeQuery("SELECT city_name FROM city WHERE zip_code = 2450");
            List<RenameMeDTO> personList =  q1.getResultList();
        for (RenameMeDTO p: personList) {
            System.out.println("This is the number that belongs to this person: " + personList);
        } 
           
        } finally {
             em.close();
        }
        
        return null;
    }

    public Person getZipCodes() {
        EntityManager em = emf.createEntityManager();
        try{
        Query q1 = em.createNativeQuery("SELECT zip_code FROM city WHERE country_name = \"Danmark\"");
            List<RenameMeDTO> personList =  q1.getResultList();
        for (RenameMeDTO p: personList) {
            System.out.println("This is the number that belongs to this person: " + personList);
        } 
           
        } finally {
             em.close();
        }
        
        return null;
    }

    public Person getHobbyByPersons() {
        EntityManager em = emf.createEntityManager();
        try{
        Query q1 = em.createNativeQuery("SELECT first_name FROM person INNER JOIN hobby WHERE hobby_id = 1");
            List<RenameMeDTO> personList =  q1.getResultList();
        for (RenameMeDTO p: personList) {
            System.out.println("This is the number that belongs to this person: " + personList);
        } 
           
        } finally {
             em.close();
        }
        
        return null;
    }
   
    
    
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        FacadeExample fe = getFacadeExample(emf);
        fe.editPerson(); // edit
        fe.getPerson(123456); // getPerson
        fe.getHobbyByNumbers();
        fe.getCity();
        fe.getZipCodes();
        fe.getHobbyByPersons();

    }

}
