/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sergio
 */
@Entity
public class Instructor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date employeeSince;
    private String phoneNumber;
    @OneToMany(mappedBy = "instructor")
    private List<UniversityClass> classes = new ArrayList<>();

    public void addClass(UniversityClass uniClass) {
        if (!this.classes.contains(uniClass)) {
            this.classes.add(uniClass);
        }
        if (uniClass.getInstructor() != this) {
            uniClass.setInstructor(this);
        }
    }
    
    public Instructor() {
    }

    public Instructor(String firstName, String lastName, Date employeeSince, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeSince = employeeSince;
        this.phoneNumber = phoneNumber;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public List<UniversityClass> getClasses() {
        return classes;
    }

    public void setClasses(List<UniversityClass> classes) {
        this.classes = classes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getEmployeeSince() {
        return employeeSince;
    }

    public void setEmployeeSince(Date employeeSince) {
        this.employeeSince = employeeSince;
    }    

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
