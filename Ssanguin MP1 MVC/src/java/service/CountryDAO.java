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
import model.Country;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Sergio
 */
@Stateless
public class CountryDAO {

    @Resource(lookup = "jdbc/ssanguinMp1Mvc")
    DataSource ds;

    public boolean create(Country c) {
        String sql = "insert into country (Code, Name, Continent, Region, SurfaceArea, IndepYear, " +
"                                    Population, LifeExpectancy, GNP, GNPOld, GovernmentForm, HeadOfState, Capital, Code2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, c.getCode());
            pstmt.setString(2, c.getName());
            pstmt.setString(3, c.getContinent());
            pstmt.setString(4, c.getRegion());
            pstmt.setFloat(5, c.getSurfaceArea());
            pstmt.setInt(6, c.getIndepYear());
            pstmt.setInt(7, c.getPopulation());
            pstmt.setFloat(8, c.getLifeExpectancy());
            pstmt.setFloat(9, c.getGNP());
            pstmt.setFloat(10, c.getGNPOld());
            pstmt.setString(11, c.getGovernmentForm());
            pstmt.setString(12, c.getHeadOfState());
            pstmt.setInt(13, c.getCapital());
            pstmt.setString(14, c.getCode2());

            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean delete(String code) {
        String sql = "delete from country where Code = ?";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, code);

            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean update(Country c) {
        String sql = "update country set Name = ?, Continent = ?, Region = ?, SurfaceArea = ?, IndepYear = ?, " +
                  "Population = ?, LifeExpectancy = ?, GNP = ?, GNPOld = ?, GovernmentForm = ?, HeadOfState = ?, Capital = ?, Code2 = ?  where Code = ?";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getContinent());
            pstmt.setString(3, c.getRegion());
            pstmt.setFloat(4, c.getSurfaceArea());
            pstmt.setInt(5, c.getIndepYear());
            pstmt.setInt(6, c.getPopulation());
            pstmt.setFloat(7, c.getLifeExpectancy());
            pstmt.setFloat(8, c.getGNP());
            pstmt.setFloat(9, c.getGNPOld());
            pstmt.setString(10, c.getGovernmentForm());
            pstmt.setString(11, c.getHeadOfState());
            pstmt.setInt(12, c.getCapital());
            pstmt.setString(13, c.getCode2());
            pstmt.setString(14, c.getCode());

            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public Country find(String code) {
        Country c = null;
        String sql = "select * from country where Code =  ?";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, code);

            ResultSet rs = pstmt.executeQuery();

            
            while (rs.next()) {
                c = new Country(rs.getString("code"),
                        rs.getString("name"),
                        rs.getString("continent"),
                        rs.getString("region"),
                        rs.getFloat("surfaceArea"),
                        rs.getInt("indepYear"),
                        rs.getInt("population"),
                        rs.getFloat("lifeExpectancy"),
                        rs.getFloat("GNP"),
                        rs.getFloat("GNPOld"),
                        rs.getString("localName"),
                        rs.getString("governmentForm"),
                        rs.getString("headOfState"),
                        rs.getInt("capital"),
                        rs.getString("code2"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    }

    public List<Country> findAll() {
        String sql = "select * from country";

        List countries = new ArrayList<>();

        try (Connection con = ds.getConnection()) {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Country c = new Country(rs.getString("code"),
                        rs.getString("name"),
                        rs.getString("continent"),
                        rs.getString("region"),
                        rs.getFloat("surfaceArea"),
                        rs.getInt("indepYear"),
                        rs.getInt("population"),
                        rs.getFloat("lifeExpectancy"),
                        rs.getFloat("GNP"),
                        rs.getFloat("GNPOld"),
                        rs.getString("localName"),
                        rs.getString("governmentForm"),
                        rs.getString("headOfState"),
                        rs.getInt("capital"),
                        rs.getString("code2"));

                countries.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CountryDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return countries;
    }
}
