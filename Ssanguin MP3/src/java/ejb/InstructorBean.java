/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Instructor;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

/**
 *
 * @author Sergio
 */
@Stateless
public class InstructorBean extends AbstractBean<Instructor>{

    /**
     *
     */
    public InstructorBean() {
    }

    /**
     *
     * @return
     */
    public List<Instructor> findAll(){
        return super.findAll("select i from Instructor i");
    }

     /**
     *
     * @param userName
     * @return
     */
    public Instructor findByUserName(String userName){
        TypedQuery<Instructor> query = getEntityManager().createNamedQuery("Instructor.findByUsername", Instructor.class);
        query.setParameter("userName", userName);
        return query.getSingleResult();
    }
    
}
