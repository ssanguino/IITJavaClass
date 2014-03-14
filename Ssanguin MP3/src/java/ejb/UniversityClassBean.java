/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import domain.UniversityClass;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Sergio
 */
@Stateless
public class UniversityClassBean extends AbstractBean<UniversityClass>{

    /**
     *
     */
    public UniversityClassBean() {
    }

    /**
     *
     * @return
     */
    public List<UniversityClass> findAll(){
        return super.findAll("select c from UniversityClass c");
    }

}
