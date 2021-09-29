package facades;

import dtos.RenameMeDTO;
import entities.RenameMe;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public String createPerson(RenameMeDTO rm) {

        EntityManager em = emf.createEntityManager();
        try{
            String createPerson = (String) em.createQuery("INSERT INTO person SET email = ?, first_name = ?, last_name = ?").getSingleResult();
            return createPerson;
        }finally{
            em.close(); // closes the connection
        }
    }

    public String editPerson() {
        EntityManager em = emf.createEntityManager();
        try{
            String renameMeCount = (String) em.createQuery("UPDATE person SET email = ?, first_name = ?, last_name = ? WHERE id = ?").getSingleResult();
            return renameMeCount;
        }finally{
            em.close();
        }
    }

    public String getPerson() {
        EntityManager em = emf.createEntityManager();
        try{
            String renameMeCount = (String) em.createQuery("SELECT * FROM person WHERE phone_number = ?").getSingleResult();
            return renameMeCount;
        }finally{
            em.close();
        }
    }

    public String getHobbyByNumbers() {
        EntityManager em = emf.createEntityManager();
        try{
            String renameMeCount = (String) em.createQuery("SELECT COUNT(name) FROM person INNER JOIN hobby WHERE hobby_id = 1").getSingleResult();
            return renameMeCount;
        }finally{
            em.close();
        }
    }


    public String getCity() {
        EntityManager em = emf.createEntityManager();
        try{
            String renameMeCount = (String) em.createQuery("SELECT city_name FROM city WHERE zip_code = 2450").getSingleResult();
            return renameMeCount;
        }finally{
            em.close();
        }
    }

    public String getZipCodes() {
        EntityManager em = emf.createEntityManager();
        try{
            String renameMeCount = (String) em.createQuery("SELECT zip_code FROM city WHERE country_name = \"Danmark\"").getSingleResult();
            return renameMeCount;
        }finally{
            em.close();
        }
    }

    public String getHobbyByPersons() {
        EntityManager em = emf.createEntityManager();
        try{
            String renameMeCount = (String) em.createQuery("SELECT first_name FROM person INNER JOIN hobby WHERE hobby_id = 1").getSingleResult();
            return renameMeCount;
        }finally{
            em.close();
        }
    }


    public RenameMeDTO getById(long id){
        EntityManager em = emf.createEntityManager();
        return new RenameMeDTO(em.find(RenameMe.class, id));
    }
    
    //TODO Remove/Change this before use
    public long getRenameMeCount() {
        EntityManager em = emf.createEntityManager();
        try{
            long renameMeCount = (long)em.createQuery("SELECT COUNT(r) FROM RenameMe r").getSingleResult();
            return renameMeCount;
        }finally{  
            em.close();
        }
    }


    
    public List<RenameMeDTO> getAll(){
        EntityManager em = emf.createEntityManager();
        TypedQuery<RenameMe> query = em.createQuery("SELECT r FROM RenameMe r", RenameMe.class);
        List<RenameMe> rms = query.getResultList();
        return RenameMeDTO.getDtos(rms);
    }
    
    public static void main(String[] args) {
        emf = EMF_Creator.createEntityManagerFactory();
        FacadeExample fe = getFacadeExample(emf);
        fe.getAll().forEach(dto->System.out.println(dto));
        fe.editPerson(); // edit
        fe.getPerson(); // getPerson
        fe.getHobbyByNumbers();
        fe.getCity();
        fe.getZipCodes();
        fe.getHobbyByPersons();

    }

}
