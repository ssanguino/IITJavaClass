/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Sergio
 */
public class Language implements Serializable {

    private String countryCode;
    private String language;
    private String isOfficial;
    private float percentage;

    public Language() {
    }

    public Language(String countryCode,
            String language,
            String isOfficial,
            float percentage) {
        this.countryCode = countryCode;
        this.language = language;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
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
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * @return the isOfficial
     */
    public String getIsOfficial() {
        return isOfficial;
    }

    /**
     * @param isOfficial the isOfficial to set
     */
    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    /**
     * @return the percentage
     */
    public float getPercentage() {
        return percentage;
    }

    /**
     * @param percentage the percentage to set
     */
    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
