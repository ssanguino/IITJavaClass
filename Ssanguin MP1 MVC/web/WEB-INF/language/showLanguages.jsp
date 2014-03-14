<%-- 
    Document   : showLanguages
    Created on : Sep 22, 2013, 3:55:22 PM
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Languages</title>
    </head>
    <body>

        <h1>Languages</h1>
        <a href="<c:url value="/index.jsp"/>">Return Home</a>
        <a href="<c:url value="/languages/new"/>">New Language</a>
        
        <c:if test="${not empty problem}">
            <span style="color: red;">
                ${problem}
            </span>
        </c:if>
        
        <table border="1">
            <thead>
                <tr>
                    <th>CountryCode</th>
                    <th>Language</th>
                    <th>IsOfficial</th>
                    <th>Percentage</th>                        
                    <th>Delete Language</th>
                    <th>Update Language</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${requestScope.languages}" var="row">
                    <c:url value="/languages/delete" var="delurl">
                        <c:param name="countryCode" value="${row.countryCode}"/>
                        <c:param name="language" value="${row.language}"/>
                    </c:url>

                    <c:url value="/languages/update" var="updurl">
                        <c:param name="countryCode" value="${row.countryCode}"/>
                        <c:param name="language" value="${row.language}"/>
                    </c:url>
                    
                    <tr>
                        <td>${row.countryCode}</td>
                        <td>${row.language}</td>
                        <td>${row.isOfficial}</td>
                        <td>${row.percentage}</td>
                        <td><a href="${delurl}">Delete Language</a></td>
                        <td><a href="${updurl}">Update Language</a></td>
                    </tr>
                </c:forEach> 
            </tbody>
        </table>
</html>
