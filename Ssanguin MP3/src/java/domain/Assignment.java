/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sergio
 */
@Entity
public class Assignment extends CommonEntity implements Serializable {

    private String name;
    @Temporal(TemporalType.DATE)
    private Date dueDate;
    private String type;
    @ManyToOne
    private UniversityClass uniClass;

    /**
     *
     */
    public Assignment() {
    }

    /**
     *
     * @param name
     * @param dueDate
     * @param type
     */
    public Assignment(String name, Date dueDate, String type) {
        this.name = name;
        this.dueDate = dueDate;
        this.type = type;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     *
     * @param dueDate
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public UniversityClass getUniClass() {
        return uniClass;
    }

    /**
     *
     * @param uniClass
     */
    public void setUniClass(UniversityClass uniClass) {
        this.uniClass = uniClass;
        if (!uniClass.getAssignments().contains(this)) {
            uniClass.getAssignments().add(this);
        }
    }
    
}
