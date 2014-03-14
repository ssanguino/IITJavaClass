/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
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
@WebServlet(name = "NewCity", urlPatterns = {"/cities/new"})
public class NewCity extends HttpServlet {

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
        
        List<Country> countries = countryDao.findAll();
        request.setAttribute("countries", countries);
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
        
        System.out.println(c.getCountryCode());

        if (cityDao.create(c)) {
            request.getRequestDispatcher("/cities").forward(request, response);
        } else {
            request.setAttribute("problem", "There was a problem creating the city.");
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
