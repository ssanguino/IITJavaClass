/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Country;
import service.CountryDAO;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "NewCountry", urlPatterns = {"/countries/new"})
public class NewCountry extends HttpServlet {

    
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
      
    private Country buildCountry(HttpServletRequest request) {
        Country c = new Country();

        c.setCapital(Integer.parseInt(trimParam(request.getParameter("Capital"))));
        c.setCode(trimParam(request.getParameter("countryCode")));
        c.setCode2(trimParam(request.getParameter("Code2")));
        c.setContinent(trimParam(request.getParameter("Continent")));
        c.setGNP(Float.parseFloat(trimParam(request.getParameter("GNP"))));
        c.setGNPOld(Float.parseFloat(trimParam(request.getParameter("GNPOld"))));
        c.setGovernmentForm(trimParam(request.getParameter("GovernmentForm")));
        c.setHeadOfState(trimParam(request.getParameter("HeadOfState")));
        c.setIndepYear(Integer.parseInt(trimParam(request.getParameter("IndepYear"))));
        c.setLifeExpectancy(Float.parseFloat(trimParam(request.getParameter("LifeExpectancy"))));
        c.setName(trimParam(request.getParameter("Name")));
        c.setPopulation(Integer.parseInt(trimParam(request.getParameter("Population"))));
        c.setRegion(trimParam(request.getParameter("Region")));
        c.setSurfaceArea(Float.parseFloat(trimParam(request.getParameter("SurfaceArea"))));
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

        request.getRequestDispatcher("/WEB-INF/country/countryForm.jsp").forward(request, response);
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
        Country c = buildCountry(request);
        
        if (countryDao.create(c)) {
            request.getRequestDispatcher("/countries").forward(request, response);
        } else {
            request.setAttribute("problem", "There was a problem creating the country.");
            request.getRequestDispatcher("/countries").forward(request, response);
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
