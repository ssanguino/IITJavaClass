/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import domain.security.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


/**
 *
 * @author Sergio
 */
@Entity
@NamedQuery(name = "Student.findByUsername", query = "select s from Student s where s.user.userName = :userName")
public class Student extends CommonEntity implements Serializable {
    
    private String firstName;
    private String lastName;
    private String email;
    @OneToOne
    @JoinColumn(name = "USERNAME")
    private User user;
    @Embedded
    private Address address;
    @ManyToMany
    private List<UniversityClass> classes = new ArrayList<>();

    /**
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param address
     */
    public Student(String firstName, String lastName, String email, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
    }
    
    /**
     *
     * @param uniClass
     */
    public void addClass(UniversityClass uniClass) {
        if (!this.classes.contains(uniClass)) {
            this.classes.add(uniClass);
        }
        if (!uniClass.getStudents().contains(this)) {
            uniClass.getStudents().add(this);
        }
    }

    /**
     *
     */
    public Student() {
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
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public Address getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
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
    public User getUser() {
        return user;
    }

    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
    
}
