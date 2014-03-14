/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.sql.DataSource;
import model.Language;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Sergio
 */
@Stateless
public class LanguageDAO {

    @Resource(lookup = "jdbc/ssanguinMp1Mvc")
    DataSource ds;

    public boolean create(Language l) {
        String sql = "insert into countrylanguage (countryCode, language, isOfficial, percentage) VALUES (?, ?, ?, ?)";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, l.getCountryCode());
            pstmt.setString(2, l.getLanguage());
            pstmt.setString(3, l.getIsOfficial());
            pstmt.setFloat(4, l.getPercentage());

            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LanguageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean delete(String countryCode, String language) {
        String sql = "delete from countryLanguage where countryCode = ? and language = ?";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, countryCode);
            pstmt.setString(2, language);

            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LanguageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean update(Language l) {
        String sql = "update countrylanguage set isOfficial = ?, Percentage = ? where countryCode = ? and language = ?";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);          
            pstmt.setString(1, l.getIsOfficial());
            pstmt.setFloat(2, l.getPercentage());
            pstmt.setString(3, l.getCountryCode());
            pstmt.setString(4, l.getLanguage());

            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LanguageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Language find(String countryCode, String language) {
        Language l = null;
        String sql = "select * from countryLanguage where countryCode = ? and language = ?";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, countryCode);
            pstmt.setString(2, language);

            ResultSet rs = pstmt.executeQuery();

            
            while (rs.next()) {
                l = new Language(rs.getString("countryCode"),
                        rs.getString("language"),
                        rs.getString("isOfficial"),
                        rs.getFloat("percentage"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return l;
    }

    public List<Language> findAll() {
        String sql = "select * from countryLanguage";

        List languages = new ArrayList<>();

        try (Connection con = ds.getConnection()) {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Language l = new Language(rs.getString("countryCode"),
                        rs.getString("language"),
                        rs.getString("isOfficial"),
                        rs.getFloat("percentage"));

                languages.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LanguageDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return languages;
    }
}
