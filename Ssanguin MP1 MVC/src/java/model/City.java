package model;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Sergio
 */
public class City implements Serializable {
    
    private int ID;
    private String name;
    private String countryCode;
    private String district;
    private int population;
    
    public City() {
    }

    public City(int ID,
            String name,
            String countryCode,
            String district,
            int population) {
        this.name = name;
        this.ID = ID;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    /**
     * @return the ID
     */
    public int getID() {
        return ID;
    }

    /**
     * @param ID the ID to set
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode the countryCode to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * @param population the population to set
     */
    public void setPopulation(int population) {
        this.population = population;
    }
    
}
