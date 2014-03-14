/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Address;
import domain.Assignment;
import domain.Instructor;
import domain.Student;
import domain.UniversityClass;
import domain.security.Group;
import domain.security.User;
import ejb.security.GroupBean;
import ejb.security.UserBean;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author Sergio
 */
@Singleton
@Startup
public class DatabasePopulator {
    
    @EJB
    private UserBean userBean;
    
    @EJB
    private GroupBean groupBean;
    
    @EJB
    private UniversityClassBean universityClassBean;
    
    @EJB
    private InstructorBean instructorBean;
    
    @EJB
    private AssignmentBean assignmentBean;
    
    @EJB
    private StudentBean studentBean;
    
    @PostConstruct
    private void populateDB() {
        
        Group studentsGroup = new Group("STUDENTS", "The group for the students of the university");
        Group instructorsGroup = new Group("INSTRUCTORS", "The group for the instructors");
        User studentUser1 = new User("jlannister", "k1ngslay3r");
        User studentUser2 = new User("bobama", "y3swec4n");
        User studentUser3 = new User("bbaggins", "mypreciou5");
        User instructorUser1 = new User("poppins", "bestmaidever");
        User instructorUser2 = new User("jsmith", "thisisfun");
        User instructorUser3 = new User("washington", "usa!usa!");
        studentUser1.addGroup(studentsGroup);
        studentUser2.addGroup(studentsGroup);
        studentUser3.addGroup(studentsGroup);
        instructorUser1.addGroup(instructorsGroup);
        instructorUser2.addGroup(instructorsGroup);
        instructorUser3.addGroup(instructorsGroup);
        groupBean.create(studentsGroup);
        groupBean.create(instructorsGroup);
        userBean.create(studentUser1);
        userBean.create(studentUser2);
        userBean.create(studentUser3);
        userBean.create(instructorUser1);
        userBean.create(instructorUser2);
        userBean.create(instructorUser3);
              
        Address addr1 = new Address("IIT", "Perlstein Hall", "Chicago", "IL", "60616", "USA");
        Address addr2 = new Address("IIT", "Stuart Building", "Chicago", "IL", "60616", "USA");
        Address addr3 = new Address("Midtown", "Loop", "Chicago", "IL", "60616", "USA");
        
        Instructor instructor1 = new Instructor("Jeff","Smith", new GregorianCalendar(2000, 1, 20).getTime(), "1111111111");
        Instructor instructor2 = new Instructor("George","Washington", new GregorianCalendar(2001, 4, 12).getTime(), "2222222222");
        Instructor instructor3 = new Instructor("Mary","Poppins", new GregorianCalendar(2002, 1, 22).getTime(), "3333333333");
        
        instructor1.setUser(instructorUser2);
        instructor2.setUser(instructorUser3);
        instructor3.setUser(instructorUser1);
        
        UniversityClass class1 = new UniversityClass("Java Programming", "CS", "LS111");
        UniversityClass class2 = new UniversityClass("Project Management", "Management", "SB25");
        UniversityClass class3 = new UniversityClass("HTML5 and CSS3", "Web Design", "PH111");
        UniversityClass class4 = new UniversityClass("Android App Dev", "Software", "E1");

        Assignment assignment1 = new Assignment("MP1", new GregorianCalendar(2013, 10, 15).getTime(), "Coding");
        Assignment assignment2 = new Assignment("MP2", new GregorianCalendar(2013, 11, 20).getTime(), "Coding");
        Assignment assignment3 = new Assignment("Paper1", new GregorianCalendar(2014, 0, 5).getTime(), "Paper");
        Assignment assignment4 = new Assignment("Research", new GregorianCalendar(2014, 4, 12).getTime(), "Research");
      
        class1.addAssignment(assignment1);
        class1.addAssignment(assignment2);
        class2.addAssignment(assignment3);
        class3.addAssignment(assignment4);
        
        Student student1 = new Student("John", "Smith", "example1@example.com", addr1);
        Student student2 = new Student("Benjamin", "Franklin", "example2@example.com", addr2);
        Student student3 = new Student("Barack", "Obama", "example8@example.com", addr3);
        Student student4 = new Student("Cathy", "Perry", "example3@example.com", addr1);
        Student student5 = new Student("Avril", "Lavigne", "example4@example.com", addr2);
        Student student6 = new Student("Arya", "Stark", "example5@example.com", addr3);
        Student student7 = new Student("Jaime", "Lannister", "example6@example.com", addr1);
        Student student8 = new Student("Bilbo", "Baggins", "example7@example.com", addr2);
        student3.addClass(class2);
        student4.addClass(class3);
        student5.addClass(class1);
        
        student3.setUser(studentUser2);
        student7.setUser(studentUser1);
        student8.setUser(studentUser3);
        
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

        instructor1.addClass(class1);
        instructor1.addClass(class3);
        instructor2.addClass(class2);
        instructor3.addClass(class4);
        
        studentBean.create(student1);
        studentBean.create(student2);
        studentBean.create(student3);
        studentBean.create(student4);
        studentBean.create(student5);
        studentBean.create(student6);
        studentBean.create(student7);
        studentBean.create(student8);
        
        instructorBean.create(instructor1);
        instructorBean.create(instructor2);
        instructorBean.create(instructor3);
        
        universityClassBean.create(class1);
        universityClassBean.create(class2);
        universityClassBean.create(class3);
        universityClassBean.create(class4);

        assignmentBean.create(assignment1);
        assignmentBean.create(assignment2);
        assignmentBean.create(assignment3);
        assignmentBean.create(assignment4);
}

}
