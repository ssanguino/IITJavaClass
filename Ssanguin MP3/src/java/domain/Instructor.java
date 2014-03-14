/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.security.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sergio
 */
@Entity
@NamedQuery(name = "Instructor.findByUsername", query = "select i from Instructor i where i.user.userName = :userName")
public class Instructor extends CommonEntity implements Serializable {

    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date employeeSince;
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;
    @OneToMany(mappedBy = "instructor")
    private List<UniversityClass> classes = new ArrayList<>();

    /**
     *
     * @param uniClass
     */
    public void addClass(UniversityClass uniClass) {
        if (!this.classes.contains(uniClass)) {
            this.classes.add(uniClass);
        }
        if (uniClass.getInstructor() != this) {
            uniClass.setInstructor(this);
        }
    }
    
    /**
     *
     */
    public Instructor() {
    }

    /**
     *
     * @param firstName
     * @param lastName
     * @param employeeSince
     * @param phoneNumber
     */
    public Instructor(String firstName, String lastName, Date employeeSince, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeSince = employeeSince;
        this.phoneNumber = phoneNumber;
    }
    
    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    /**
     *
     * @return
     */
    public List<UniversityClass> getClasses() {
        return classes;
    }

    /**
     *
     * @param classes
     */
    public void setClasses(List<UniversityClass> classes) {
        this.classes = classes;
    }

    /**
     *
     * @return
     */
    public Date getEmployeeSince() {
        return employeeSince;
    }

    /**
     *
     * @param employeeSince
     */
    public void setEmployeeSince(Date employeeSince) {
        this.employeeSince = employeeSince;
    }    

    /**
     *
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     *
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
        /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

}
