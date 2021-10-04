/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author danielpedersen
 */
@Entity
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    
    
    @ManyToMany(mappedBy = "people", cascade = CascadeType.PERSIST)
    private List<HobbyEntity> hobbies;

    public PersonEntity() {
    }


    public void SearchPeopleThatHaveAGivenHobby(HobbyEntity name) {
        if (name != null) {
            this.hobbies.add(name); // adding hobby to list
            name.getPeople().add(this); // person
        }
    }
    
    public void CreatePersonToSaveDataIntoDatabase() {
        
    }
    

    public PersonEntity(String firstName) {
        this.firstName = firstName;
        this.hobbies = new ArrayList<>();
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}
