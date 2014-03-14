/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.security;

import domain.security.Group;
import ejb.AbstractBean;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Sergio
 */
@Stateless
public class GroupBean extends AbstractBean<Group> {

    /**
     *
     */
    public GroupBean() {
    }

    /**
     *
     * @return
     */
    public List<Group> findAll(){
        return super.findAll("select g from Groups g");
    }

}
