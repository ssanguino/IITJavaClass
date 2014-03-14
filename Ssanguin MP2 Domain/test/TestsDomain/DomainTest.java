package TestsDomain;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Address;
import domain.Assignment;
import domain.Instructor;
import domain.Student;
import domain.UniversityClass;
import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sergio
 */
public class DomainTest {
    
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Ssanguin_MP2_DomainPU");
    protected static EntityManager em;
    protected static EntityTransaction tx;
    
    public DomainTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        em = emf.createEntityManager();
        tx = em.getTransaction();

        Instructor instructor1 = new Instructor("Jeff","Smith", new GregorianCalendar(2000, 1, 20).getTime(), "1111111111");
        Instructor instructor2 = new Instructor("George","Washington", new GregorianCalendar(2001, 4, 12).getTime(), "2222222222");
        Instructor instructor3 = new Instructor("Mary","Poppins", new GregorianCalendar(2002, 1, 22).getTime(), "3333333333");
        
        Address addr1 = new Address("IIT", "Perlstein Hall", "Chicago", "IL", "60616", "USA");
        Address addr2 = new Address("IIT", "Stuart Building", "Chicago", "IL", "60616", "USA");
        Address addr3 = new Address("Midtown", "Loop", "Chicago", "IL", "60616", "USA");

        Student student1 = new Student("John", "Smith", "example1@example.com", addr1);
        Student student2 = new Student("Benjamin", "Franklin", "example2@example.com", addr2);
        Student student3 = new Student("Barack", "Obama", "example8@example.com", addr3);
        Student student4 = new Student("Cathy", "Perry", "example3@example.com", addr1);
        Student student5 = new Student("Avril", "Lavigne", "example4@example.com", addr2);
        Student student6 = new Student("Arya", "Stark", "example5@example.com", addr3);
        Student student7 = new Student("Jaime", "Lannister", "example6@example.com", addr1);
        Student student8 = new Student("Bilbo", "Baggins", "example7@example.com", addr2);

        Assignment assignment1 = new Assignment("MP1", new GregorianCalendar(2013, 10, 15).getTime(), "Coding");
        Assignment assignment2 = new Assignment("MP2", new GregorianCalendar(2013, 11, 20).getTime(), "Coding");
        Assignment assignment3 = new Assignment("Paper1", new GregorianCalendar(2014, 0, 5).getTime(), "Paper");
        Assignment assignment4 = new Assignment("Research", new GregorianCalendar(2014, 4, 12).getTime(), "Research");

        UniversityClass class1 = new UniversityClass("Java Programming", "CS", "LS111");
        UniversityClass class2 = new UniversityClass("Project Management", "Management", "SB25");
        UniversityClass class3 = new UniversityClass("HTML5 and CSS3", "Web Design", "PH111");
        UniversityClass class4 = new UniversityClass("Android App Dev", "Software", "E1");

        class1.addStudent(student8);
        class1.addStudent(student1);
        class1.addStudent(student2);
        class1.addStudent(student3);
        class2.addStudent(student4);
        class2.addStudent(student5);
        class2.addStudent(student6);
        class3.addStudent(student7);
        class3.addStudent(student8);
        class3.addStudent(student1);
        class3.addStudent(student2);
        class4.addStudent(student6);
        class4.addStudent(student7);
        class4.addStudent(student5);

        student3.addClass(class2);
        student4.addClass(class3);
        student5.addClass(class1);

        class1.addAssignment(assignment1);
        class1.addAssignment(assignment2);
        class2.addAssignment(assignment3);
        class3.addAssignment(assignment4);

        instructor1.addClass(class1);
        instructor1.addClass(class3);
        instructor2.addClass(class2);
        instructor3.addClass(class4);
        

        tx.begin();
        em.persist(instructor1);
        em.persist(instructor2);
        em.persist(instructor3);
        em.persist(student1);
        em.persist(student2);
        em.persist(student3);
        em.persist(student4);
        em.persist(student5);
        em.persist(student6);
        em.persist(student7);
        em.persist(student8);
        em.persist(assignment1);
        em.persist(assignment2);
        em.persist(assignment3);
        em.persist(assignment4);
        em.persist(class1);
        em.persist(class2);
        em.persist(class3);
        em.persist(class4);
        tx.commit();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void domainTest() {
        TypedQuery<UniversityClass> query = em.createQuery("select c from UniversityClass c", UniversityClass.class);
        List<UniversityClass> allClasses = query.getResultList();
        assertNotNull(allClasses);
        
        System.out.println("\n\nList of Classes, with the registered students, the instructor and the assignments for each of them:\n***********************\n");
        for (UniversityClass c : allClasses) {
            System.out.println("---------UniversityClass: " + c.getName() + "-----------");
            System.out.println("**Instructor: " + c.getInstructor().getFirstName() + " " + c.getInstructor().getLastName());
            System.out.println("**Specialization: " + c.getSpecialization());
            System.out.println("**Classroom: " + c.getClassRoom());
            System.out.println("***Registered Students:-----------");
            List<Student> classStudents = c.getStudents();
            for (Student s : classStudents) {
                System.out.println("Name: " + s.getFirstName() + " " + s.getLastName());
            }
            System.out.println("***Assignments:-----------");
            List<Assignment> assignments = c.getAssignments();
            for (Assignment a : assignments) {
                System.out.println("Assignment: " + a.getName());
            }
            System.out.println("\n");
        }
        
        TypedQuery<Instructor> queryInstructors = em.createQuery("select i from Instructor i", Instructor.class);
        List<Instructor> allInstructors = queryInstructors.getResultList();
        assertNotNull(allInstructors);
        System.out.println("List of Instructors, with the classes they are assigned to teach (as per the 'Users' part of the assignment):\n***********************\n");
        for (Instructor i : allInstructors) {
            System.out.println("---------Instructor: " + i.getFirstName() + " " + i.getLastName() + "-----------");
            System.out.println("**Employee since: " + i.getEmployeeSince().toString());
            System.out.println("**Phone number: " + i.getPhoneNumber());
            System.out.println("***Teaches classes:-----------");
            List<UniversityClass> classesList = i.getClasses();
            for (UniversityClass c : classesList) {
                System.out.println(c.getName());
            }
            System.out.println("\n");
        }
        
        TypedQuery<Student> queryStudents = em.createQuery("select s from Student s", Student.class);
        List<Student> allStudents = queryStudents.getResultList();
        assertNotNull(allStudents);
        System.out.println("List of Students, with the classes they are enrolled in (as per the 'Users' part of the assignment):\n***********************\n");
        for (Student s : allStudents) {
            System.out.println("---------Student: " + s.getFirstName() + " " + s.getLastName() + "-----------");
            System.out.println("**Email: " + s.getEmail());
            System.out.println("**" + s.getAddress().toString());
            System.out.println("***Enrolled in classes:-----------");
            List<UniversityClass> classesList = s.getClasses();
            for (UniversityClass c : classesList) {
                System.out.println(c.getName());
            }
            System.out.println("\n");
        }
        
        
        tx.begin();
        TypedQuery<Student> studentQuery = em.createQuery("select s from Student s where s.firstName = 'Avril'", Student.class);
        Student studentToUpdate = studentQuery.getSingleResult();
        assertNotNull(studentToUpdate);
        System.out.println("Trying to update the email of the student called 'Avril':\n***********************\n");
        System.out.println("Current Email: " + studentToUpdate.getEmail());
        studentToUpdate.setEmail("canadarulz@example.com");
        tx.commit();
        Student studentUpdated = studentQuery.getSingleResult();
        System.out.println("Updated Email: " + studentUpdated.getEmail() + "\n");

        tx.begin();
        Assignment someAssignment = em.find(Assignment.class, 1);
        System.out.println("Trying to remove the assignment with the ID '1'(previously there were four assignments):\n***********************\n");
        assertNotNull(someAssignment);
        em.remove(someAssignment);
        tx.commit();
        TypedQuery<Assignment> queryAssignments = em.createQuery("select a from Assignment a", Assignment.class);
        List<Assignment> allAssignments = queryAssignments.getResultList();
        assertNotNull(allAssignments);
        System.out.println("Updated list of assignments:***********************");
        for (Assignment a : allAssignments) {
            System.out.println("**Name: " + a.getName());
            System.out.println("**Type: " + a.getType());
            System.out.println("**Class: " + a.getUniClass().getName());
            System.out.println("\n");
        }
        
    }
}