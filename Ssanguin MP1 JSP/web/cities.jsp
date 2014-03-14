<%-- 
    Document   : cities
    Created on : Sep 18, 2013, 7:39:20 PM
    Author     : Sergio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cities</title>
    </head>
    <body>
        <h1>Cities</h1>
        <a href="/SsanguinMP1JSP">Return Home</a>
        <a href="cityform.jsp">New City</a>
        <sql:query dataSource="jdbc/ssanguinMp1Jsp" var="cities" sql="select * from city"></sql:query>

            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>CountryCode</th>
                        <th>District</th>
                        <th>Population</th>
                        <th>Delete City</th>
                        <th>Update City</th>
                    </tr>
                </thead>
                
                <tbody>
                <c:forEach items="${cities.rows}" var="row">
                    
                    <c:url value="/deletecity.jsp" var="delurl">
                        <c:param name="ID" value="${row.ID}"/>
                    </c:url>

                    <c:url value="/cityform.jsp" var="updurl">
                        <c:param name="ID" value="${row.ID}"/>
                    </c:url>
                    
                    <tr>
                        <td>${row.ID}</td>
                        <td>${row.Name}</td>
                        <td>${row.CountryCode}</td>
                        <td>${row.District}</td>
                        <td>${row.Population}</td>
                        <td><a href="${delurl}">Delete City</a></td>
                        <td><a href="${updurl}">Update City</a></td>
                    </tr>
                </c:forEach>
                </tbody>
        </table>
        
    </body>
</html>
