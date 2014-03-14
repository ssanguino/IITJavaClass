/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sergio
 */
@Stateless
public class StudentBean extends AbstractBean<Student>{
    
    /**
     *
     */
    public StudentBean() {
    }

    /**
     *
     * @return
     */
    public List<Student> findAll(){
        return super.findAll("select s from Student s");
    }
    
     /**
     *
     * @param userName
     * @return
     */
    public Student findByUserName(String userName){
        TypedQuery<Student> query = getEntityManager().createNamedQuery("Student.findByUsername", Student.class);
        query.setParameter("userName", userName);
        return query.getSingleResult();
    }
    
}
