/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Language;
import service.LanguageDAO;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "UpdateLanguage", urlPatterns = {"/languages/update"})
public class UpdateLanguage extends HttpServlet {

    @EJB
    LanguageDAO languageDao;
   
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
      
    private Language buildLanguage(HttpServletRequest request) {
        Language l = new Language();

        l.setLanguage(trimParam(request.getParameter("language")));
        l.setCountryCode(trimParam(request.getParameter("countryCode")));
        l.setIsOfficial(trimParam(request.getParameter("official")));
        l.setPercentage(Float.parseFloat(trimParam(request.getParameter("Percentage"))));

        return l;
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
        
        String countryCode = request.getParameter("countryCode");
        String language = request.getParameter("language");
        Language lang = languageDao.find(countryCode, language);
        request.setAttribute("lang", lang);
        request.getRequestDispatcher("/WEB-INF/language/languageForm.jsp").forward(request, response);
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
        Language l = buildLanguage(request);

        if (languageDao.update(l)) {
            request.getRequestDispatcher("/languages").forward(request, response);
        } else {
            request.setAttribute("problem", "There was a problem updating the language.");
            request.getRequestDispatcher("/languages").forward(request, response);
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
