<%-- 
    Document   : index
    Created on : Nov 4, 2013, 7:28:41 PM
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (request.isUserInRole("STUDENT") || request.isUserInRole("INSTRUCTOR")) {
        response.sendRedirect("LoginServlet");
    }
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>MP3 Index Page</title>
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
                    <form action="j_security_check" method="POST" class="navbar-form navbar-right">
                        <div class="form-group">
                            <input id="userName" name="j_username" type="text" placeholder="User" class="form-control" required="">
                        </div>
                        <div class="form-group">
                            <input id="password" name="j_password" type="password" placeholder="Password" class="form-control" required="">
                        </div>
                        <button type="submit" class="btn btn-success">Sign in</button>
                    </form>
                </div><!--/.navbar-collapse -->
            </div>
        </div>
        
        <div class="container">
            <!-- Jumbotron -->
            <br><div class="jumbotron">
                <h1>ITMD515 - MP3</h1>
                <p class="lead">Welcome! Please sign in using the form in the upper right corner of the page to access to your account.</p>
            </div>
                 
            <br><br><br><footer class="footer" style="text-align:center">
                <p>&copy; Sergio Sanguino Serrano 2013</p>
            </footer>
        </div>
           
    </body>
</html>
