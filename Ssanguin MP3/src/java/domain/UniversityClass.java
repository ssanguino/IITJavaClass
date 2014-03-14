/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Sergio
 */
@Entity
public class UniversityClass extends CommonEntity implements Serializable {
    
    private String name;
    private String specialization;
    private String classRoom;
    @ManyToMany(mappedBy = "classes")
    private List<Student> students = new ArrayList<>();
    @OneToMany(mappedBy = "uniClass")
    private List<Assignment> assignments = new ArrayList<>();
    @ManyToOne
    private Instructor instructor;

    /**
     *
     * @param student
     */
    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            this.students.add(student);
        }
        if (!student.getClasses().contains(this)) {
            student.getClasses().add(this);
        }
    }
    
    /**
     *
     * @param assignment
     */
    public void addAssignment(Assignment assignment) {
        if (!this.assignments.contains(assignment)) {
            this.assignments.add(assignment);
        }
        if (assignment.getUniClass()!= this) {
            assignment.setUniClass(this);
        }
    }
    
    /**
     *
     */
    public UniversityClass() {
    }

    /**
     *
     * @param name
     * @param specialization
     * @param classRoom
     */
    public UniversityClass(String name, String specialization, String classRoom) {
        this.name = name;
        this.specialization = specialization;
        this.classRoom = classRoom;
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
    public String getSpecialization() {
        return specialization;
    }

    /**
     *
     * @param specialization
     */
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    /**
     *
     * @return
     */
    public String getClassRoom() {
        return classRoom;
    }

    /**
     *
     * @param classRoom
     */
    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    /**
     *
     * @return
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     *
     * @param students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     *
     * @return
     */
    public List<Assignment> getAssignments() {
        return assignments;
    }

    /**
     *
     * @param assignments
     */
    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    /**
     *
     * @return
     */
    public Instructor getInstructor() {
        return instructor;
    }

    /**
     *
     * @param instructor
     */
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
        if (!instructor.getClasses().contains(this)) {
            instructor.getClasses().add(this);
        }
    }
    
}
