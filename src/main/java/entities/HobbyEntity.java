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
public class HobbyEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
 
    @ManyToMany
    private List<PersonEntity> people;

    public HobbyEntity() {
    }

    public HobbyEntity(String name) {
        this.name = name;
        this.people = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PersonEntity> getPeople() {
        return people;
    }

    public void setPeople(List<PersonEntity> people) {
        this.people = people;
    }
    

    
    
    
    public Long getId() {
        return id;
    }
    

    public void setId(Long id) {
        this.id = id;
    }

    
}
