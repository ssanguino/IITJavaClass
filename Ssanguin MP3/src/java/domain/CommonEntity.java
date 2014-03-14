package domain;

import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;

/**
 *
 * @author Sergio
 */
@MappedSuperclass
public class CommonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date activityDate;

    @PrePersist
    @PreUpdate
    @PreRemove
    private void registerTimestamp(){
        this.activityDate = new Date();
    }
    
    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the value of activityDate
     *
     * @return the value of activityDate
     */
    public Date getActivityDate() {
        return activityDate;
    }

    /**
     * Set the value of activityDate
     *
     * @param activityDate new value of activityDate
     */
    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }
}
