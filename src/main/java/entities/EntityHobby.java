/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author danielpedersen
 */
@Entity
public class EntityHobby implements Serializable {    
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    List<Person> persons;

    public EntityHobby() {
    }

    
    public EntityHobby(String name) {
        this.name = name;
        this.persons = new ArrayList<>();
    }

    

  
    
    
    

    
    

   
    
}
