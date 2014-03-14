/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.City;
import model.Country;
import service.CityDAO;
import service.CountryDAO;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "UpdateCity", urlPatterns = {"/cities/update"})
public class UpdateCity extends HttpServlet {

    @EJB
    CityDAO cityDao;
    @EJB
    CountryDAO countryDao;
   
    private boolean isEmpty(String param) {
        if (param == null || param.trim().equals("")) {
            return true;
        }
        return false;
    }
    
    private String trimParam(String param) {
        if (isEmpty(param)) {
            return null;
        } else {
            return param.trim();
        }
    }
      
    private City buildCity(HttpServletRequest request) {
        City c = new City();

        c.setID(Integer.parseInt(trimParam(request.getParameter("cityID"))));
        c.setCountryCode(trimParam(request.getParameter("countryCode")));
        c.setDistrict(trimParam(request.getParameter("District")));
        c.setName(trimParam(request.getParameter("cityName")));
        c.setPopulation(Integer.parseInt(trimParam(request.getParameter("Population"))));

        return c;
    } 
    
        /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int ID = Integer.parseInt(request.getParameter("ID"));
        City city = cityDao.find(ID);
        List<Country> countries = countryDao.findAll();
        request.setAttribute("countries", countries);
        request.setAttribute("city", city);
        request.getRequestDispatcher("/WEB-INF/city/cityForm.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        City c = buildCity(request);
        
        if (cityDao.update(c)) {
            request.getRequestDispatcher("/cities").forward(request, response);
        } else {
            request.setAttribute("problem", "There was a problem updating the city.");
            request.getRequestDispatcher("/cities").forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
