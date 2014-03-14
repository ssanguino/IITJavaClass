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
import model.City;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author Sergio
 */
@Stateless
public class CityDAO {

    @Resource(lookup = "jdbc/ssanguinMp1Mvc")
    DataSource ds;

    public boolean create(City c) {
        String sql = "insert into city (name, countrycode, district, population) VALUES (?, ?, ?, ?)";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getCountryCode());
            pstmt.setString(3, c.getDistrict());
            pstmt.setInt(4, c.getPopulation());

            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public boolean delete(Integer cityCode) {
        String sql = "delete from city where ID = ?";
        
        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, cityCode);

            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    public boolean update(City c) {
        String sql = "update city set Name = ?, countryCode = ?, District = ?, Population = ? where ID = ?";

        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, c.getName());
            pstmt.setString(2, c.getCountryCode());
            pstmt.setString(3, c.getDistrict());
            pstmt.setInt(4, c.getPopulation());
            pstmt.setInt(5, c.getID());

            if (pstmt.executeUpdate() == 1) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    public City find(Integer cityCode) {
        String sql = "select * from city where ID =  ?";

        City c = null;
        try (Connection con = ds.getConnection()) {

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, cityCode);

            ResultSet rs = pstmt.executeQuery();

            
            while (rs.next()) {
                c = new City(rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getString("countryCode"),
                        rs.getString("district"),
                        rs.getInt("population"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return c;
    }

    public List<City> findAll() {
        String sql = "select * from city";

        List cities = new ArrayList<>();

        try (Connection con = ds.getConnection()) {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                City c = new City(rs.getInt("ID"),
                        rs.getString("name"),
                        rs.getString("countryCode"),
                        rs.getString("district"),
                        rs.getInt("population"));

                cities.add(c);

            }

        } catch (SQLException ex) {
            Logger.getLogger(CityDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

        return cities;
    }
}
