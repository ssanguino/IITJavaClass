<%-- 
    Document   : index
    Created on : Sep 20, 2013, 7:13:04 PM
    Author     : Sergio
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MP1 JSP Index Page</title>
    </head>
    <body>
        <div>
            <ul>
                <li><a href="<c:url value="/cities.jsp"/>">Show Cities</a></li>               
                <li><a href="<c:url value="/countries.jsp"/>">Show Countries</a></li>
                <li><a href="<c:url value="/languages.jsp"/>">Show Country Languages</a></li>
                <li><a href="<c:url value="/README.pdf"/>">README</a></li>
            </ul>
        </div>
    </body>
</html>
