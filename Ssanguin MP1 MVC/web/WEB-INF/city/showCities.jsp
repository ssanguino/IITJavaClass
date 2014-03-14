<%-- 
    Document   : showCities
    Created on : Sep 20, 2013, 14:24:03 PM
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cities</title>
    </head>
    <body>

        <h1>Cities</h1>
        <a href="<c:url value="/index.jsp"/>">Return Home</a>
        <a href="<c:url value="/cities/new"/>">New City</a>
    
        <c:if test="${not empty problem}">
            <span style="color: red;">
                ${problem}
            </span>
        </c:if>
        
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
                <c:forEach items="${requestScope.cities}" var="row">
                    <c:url value="/cities/update" var="updateURL">
                        <c:param name="ID" value="${row.ID}"/>
                    </c:url>
                    <c:url value="/cities/delete" var="deleteURL">
                        <c:param name="ID" value="${row.ID}"/>
                    </c:url>

                    <tr>
                        <td>${row.ID}</td>
                        <td>${row.name}</td>
                        <td>${row.countryCode}</td>
                        <td>${row.district}</td>
                        <td>${row.population}</td>
                        <td><a href="${deleteURL}">Delete City</a></td>
                        <td><a href="${updateURL}">Update City</a></td>
                    </tr>
                </c:forEach> 
            </tbody>
        </table>
</html>
