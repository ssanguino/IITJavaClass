<%-- 
    Document   : account
    Created on : Nov 4, 2013, 6:31:59 PM
    Author     : Sergio
--%>

<%@page import="java.util.Iterator"%>
<%@page import="domain.UniversityClass"%>
<%@page import="java.util.List"%>
<%@page import="domain.Instructor"%>
<%@page import="domain.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>MP3 Accounts Page</title>
        <link href="/Ssanguin_MP3/css/bootstrap.css" rel="stylesheet">
        <link href="/Ssanguin_MP3/css/justified-nav.css" rel="stylesheet">
    </head>
    <body>
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.jsp">ITMD515 MP3</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="index.jsp">Home</a></li>
                        <li><a href="/Ssanguin_MP3/javadoc/index.html">Javadoc</a></li>
                        <li><a href="/Ssanguin_MP3/README.pdf">README</a></li>
                        <li><a href="mailto:ssanguin@hawk.iit.edu">Contact</a></li>
                    </ul>
                    <div class="navbar-right">
                        <ul class="nav navbar-nav">
                            <li><a href="/Ssanguin_MP3/logout">Logout</a></li>
                        </ul>
                    </div>
                </div><!--/.navbar-collapse -->
            </div>
        </div>
        
        <div class="container">
            <br>
            <%
                Student student = (Student) request.getAttribute("student");
                Instructor instructor = (Instructor) request.getAttribute("instructor");
                String firstName = "";
                String lastName = "";
                List<UniversityClass> classes = null;
                if (student != null) {
                    firstName = student.getFirstName();
                    lastName = student.getLastName();
                    classes = student.getClasses();
                } else if (instructor != null) {
                    firstName = instructor.getFirstName();
                    lastName = instructor.getLastName();
                    classes = instructor.getClasses();
                }
            %>
            <h1>Welcome, you are <% if(student!=null) {%> a STUDENT! <% } else { %> an INSTRUCTOR! <% } %></h1>
            <h4>Your name is <%=firstName%> <%=lastName%> and you are <% if(student!=null) {%> enrolled in <% } else { %> teaching <% } %> the following classes:</h4>
            <table class="table table-striped table-bordered">
                <tr>
                    <th>Name</th>
                    <th>Classroom</th>
                    <th>Specialization</th>
                    <th>Instructor</th>
                </tr>
                <% for (Iterator<UniversityClass> i = classes.iterator(); i.hasNext();) {
                        UniversityClass item = i.next(); %>
                        <tr>
                            <td><%=item.getName()%></td>
                            <td><%=item.getClassRoom()%></td>
                            <td><%=item.getSpecialization()%></td>
                            <td><%=item.getInstructor().getFirstName()%> <%=item.getInstructor().getLastName()%></td>
                        </tr> 
                  <% } %>
            </table>    

                  <% if (instructor != null) {%>
                  <br><br>
                  <h4>Here is a list of students per class:</h4>
                  <% for (Iterator<UniversityClass> i = classes.iterator(); i.hasNext();) {
                            UniversityClass item = i.next();%>
                  <legend><%=item.getName()%></legend>
                  <table class="table table-striped table-bordered">
                      <tr>
                          <th>FirstName</th>
                          <th>LastName</th>
                          <th>Email</th>
                      </tr>
                      <% for (Iterator<Student> s = item.getStudents().iterator(); s.hasNext();) {
                              Student inClass = s.next();%>
                      <tr>
                          <td><%=inClass.getFirstName()%></td>
                          <td><%=inClass.getLastName()%></td>
                          <td><%=inClass.getEmail()%></td>
                      </tr> 
                      <% } %>
                  </table> 
                  <% } %>
                  <% } %>
            
            <br><br><br><footer class="footer" style="text-align:center">
                <p>&copy; Sergio Sanguino Serrano 2013</p>
            </footer>
        </div>
           
    </body>
</html>
