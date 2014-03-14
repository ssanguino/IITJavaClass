/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Sergio
 */
@Entity
public class UniversityClass implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String specialization;
    private String classRoom;
    @ManyToMany(mappedBy = "classes")
    private List<Student> students = new ArrayList<>();
    @OneToMany(mappedBy = "uniClass")
    private List<Assignment> assignments = new ArrayList<>();
    @ManyToOne
    private Instructor instructor;

    public void addStudent(Student student) {
        if (!this.students.contains(student)) {
            this.students.add(student);
        }
        if (!student.getClasses().contains(this)) {
            student.getClasses().add(this);
        }
    }
    
    public void addAssignment(Assignment assignment) {
        if (!this.assignments.contains(assignment)) {
            this.assignments.add(assignment);
        }
        if (assignment.getUniClass()!= this) {
            assignment.setUniClass(this);
        }
    }
    
    public UniversityClass() {
    }

    public UniversityClass(String name, String specialization, String classRoom) {
        this.name = name;
        this.specialization = specialization;
        this.classRoom = classRoom;
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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
        if (!instructor.getClasses().contains(this)) {
            instructor.getClasses().add(this);
        }
    }
    
}
