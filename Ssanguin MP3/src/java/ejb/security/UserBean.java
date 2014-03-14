/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.security;

import domain.security.User;
import ejb.AbstractBean;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Sergio
 */
@Stateless
public class UserBean extends AbstractBean<User>{

    /**
     *
     */
    public UserBean() {
    }

    /**
     *
     * @return
     */
    public List<User> findAll(){
        return super.findAll("select u from User u");
    }

}
