/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sergio
 */
@Entity
public class Assignment implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    private String type;
    @ManyToOne
    private UniversityClass uniClass;

    public Assignment() {
    }

    public Assignment(String name, Date dueDate, String type) {
        this.name = name;
        this.dueDate = dueDate;
        this.type = type;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UniversityClass getUniClass() {
        return uniClass;
    }

    public void setUniClass(UniversityClass uniClass) {
        this.uniClass = uniClass;
        if (!uniClass.getAssignments().contains(this)) {
            uniClass.getAssignments().add(this);
        }
    }
    
}
