/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.Assignment;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Sergio
 */
@Stateless
public class AssignmentBean extends AbstractBean<Assignment>{

    /**
     *
     */
    public AssignmentBean() {
    }

    /**
     *
     * @return
     */
    public List<Assignment> findAll(){
        return super.findAll("select a from Assignment a");
    }

}
