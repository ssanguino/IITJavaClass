<%-- 
    Document   : languages
    Created on : Sep 18, 2013, 7:41:50 PM
    Author     : Sergio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Country Languages</title>
    </head>
    <body>
        <h1>Country Languages</h1>
        <a href="/SsanguinMP1JSP">Return Home</a>
        <a href="languageform.jsp">New Country Language</a>
        <sql:query dataSource="jdbc/ssanguinMp1Jsp" var="languages" sql="select * from countryLanguage"></sql:query>

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
                <c:forEach items="${languages.rows}" var="row">
                    
                    <c:url value="/deletelanguage.jsp" var="delurl">
                        <c:param name="countryCode" value="${row.CountryCode}"/>
                        <c:param name="language" value="${row.Language}"/>
                    </c:url>

                    <c:url value="/languageform.jsp" var="updurl">
                        <c:param name="countryCode" value="${row.CountryCode}"/>
                        <c:param name="lang" value="${row.Language}"/>
                    </c:url>
                    
                    <tr>
                        <td>${row.CountryCode}</td>
                        <td>${row.Language}</td>
                        <td>${row.IsOfficial}</td>
                        <td>${row.Percentage}</td>
                        <td><a href="${delurl}">Delete Language</a></td>
                        <td><a href="${updurl}">Update Language</a></td>
                    </tr>
                </c:forEach>
                </tbody>
        </table>
        
    </body>
</html>
