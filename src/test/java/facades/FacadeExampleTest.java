package facades;

import dtos.RenameMeDTO;
import entities.Person;
import utils.EMF_Creator;
import entities.RenameMe;
import static facades.FacadeExample.getFacadeExample;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class FacadeExampleTest {

    private static EntityManagerFactory emf;
    private static FacadeExample facade;

    public FacadeExampleTest() {
    }

    @BeforeAll
    public static void setUpClass() {
       emf = EMF_Creator.createEntityManagerFactoryForTest();
       facade = FacadeExample.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the code below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("RenameMe.deleteAllRows").executeUpdate();
//            em.persist(new RenameMe("Some txt", "More text"));
//            em.persist(new RenameMe("aaa", "bbb"));

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    @Test
    void createPerson() {
        
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery("INSERT INTO person SET first_name = 'admin', last_name = 'admin', fk_hobby = 1, email = 'admin@admin.com'");
            
            int createPerson = q.executeUpdate();
            System.out.println("-------------------------------------------------");
            System.out.println("You have inserted: " + createPerson);

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
    
    @Test
    void editPerson() {
        
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery("UPDATE person SET email = 'hello@world.com', first_name = 'hello', last_name = 'world' WHERE id = 100");
            
            int createPerson = q.executeUpdate();
            System.out.println("-------------------------------------------------");
            System.out.println("You have inserted: " + createPerson);

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    @Test
    void getPerson() {
        
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery("SELECT first_name FROM person INNER JOIN phone WHERE number = 1234");
            
            int createPerson = q.executeUpdate();
            System.out.println("-------------------------------------------------");
            System.out.println("You have inserted: " + createPerson);

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    @Test
    void getHobbyByNumbers() {
        
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery("SELECT COUNT(name) FROM person INNER JOIN hobby WHERE hobby_id = 1");
            
            int createPerson = q.executeUpdate();
            System.out.println("-------------------------------------------------");
            System.out.println("You have inserted: " + createPerson);

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    @Test
    void getCity() {
        
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery("SELECT city_name FROM city WHERE zip_code = 2450");
            
            int createPerson = q.executeUpdate();
            System.out.println("-------------------------------------------------");
            System.out.println("You have inserted: " + createPerson);

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    @Test
    void getZipCodes() {
        
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery("SELECT zip_code FROM city WHERE country_name = \"Danmark\"");
            
            int createPerson = q.executeUpdate();
            System.out.println("-------------------------------------------------");
            System.out.println("You have inserted: " + createPerson);

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }

    @Test
    void getHobbyByPersons() {
        
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            Query q = em.createNativeQuery("SELECT first_name FROM person INNER JOIN hobby WHERE hobby_id = 100");
            
            int createPerson = q.executeUpdate();
            System.out.println("-------------------------------------------------");
            System.out.println("You have inserted: " + createPerson);

            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
    
    @Test
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        FacadeExample fe = getFacadeExample(emf);
        fe.editPerson(); // edit
        fe.getPerson(); // getPerson
        fe.getHobbyByNumbers(); // getHobbyByNumbers
        fe.getCity(); // getCity
        fe.getZipCodes(); // getZipCodes
        fe.getHobbyByPersons(); // getHobbyByPersons
        fe.createPerson(); // createPerson
    }


}