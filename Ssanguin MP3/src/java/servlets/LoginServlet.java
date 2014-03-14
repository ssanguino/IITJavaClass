package servlets;

import domain.Instructor;
import domain.Student;
import ejb.InstructorBean;
import ejb.StudentBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sergio
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    @EJB
    private InstructorBean instructorBean;
    @EJB
    private StudentBean studentBean;

    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Student student = null;
        Instructor instructor = null;

        if (request.isUserInRole("INSTRUCTOR")) {
            instructor = instructorBean.findByUserName(request.getRemoteUser());
        }

        if (request.isUserInRole("STUDENT")) {
            student = studentBean.findByUserName(request.getRemoteUser());
        }
        
        if (student != null) {
            request.setAttribute("student", student);
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/protected/account.jsp");
            rd.forward(request, response);
        }
        
        if (instructor != null) {
            request.setAttribute("instructor", instructor);
            ServletContext sc = getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/protected/account.jsp");
            rd.forward(request, response);
        }
              
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
