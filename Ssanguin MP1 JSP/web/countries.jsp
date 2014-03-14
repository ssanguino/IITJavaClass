<%-- 
    Document   : countries
    Created on : Sep 18, 2013, 7:40:34 PM
    Author     : Sergio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Countries</title>
    </head>
    <body>
        <h1>Countries</h1>
        <a href="/SsanguinMP1JSP">Return Home</a>
        <a href="countryform.jsp">New Country</a>
        <sql:query dataSource="jdbc/ssanguinMp1Jsp" var="columns" sql="select column_name from information_schema.columns where table_name='country' limit 3, 200"></sql:query>
        <sql:query dataSource="jdbc/ssanguinMp1Jsp" var="countries" sql="select * from country"></sql:query>

            <table border="1">
                <thead>
                    <tr>
                        <c:forEach items="${columns.rows}" var="row">
                            <th>${row.column_name}</th>
                        </c:forEach>
                        <th>Delete City</th>
                        <th>Update City</th>
                    </tr>
                </thead>
                
                <tbody>
                <c:forEach items="${countries.rows}" var="row">
                    
                    <c:url value="/deletecountry.jsp" var="delurl">
                        <c:param name="Code" value="${row.Code}"/>
                        <c:param name="countryName" value="${row.Name}"/>
                    </c:url>

                    <c:url value="/countryform.jsp" var="updurl">
                        <c:param name="Code" value="${row.Code}"/>
                    </c:url>
                    
                    <tr>
                        <td>${row.Code}</td>
                        <td>${row.Name}</td>
                        <td>${row.Continent}</td>
                        <td>${row.Region}</td>
                        <td>${row.SurfaceArea}</td>
                        <td>${row.IndepYear}</td>
                        <td>${row.Population}</td>
                        <td>${row.LifeExpectancy}</td>
                        <td>${row.GNP}</td>
                        <td>${row.GNPOld}</td>
                        <td>${row.LocalName}</td>
                        <td>${row.GovernmentForm}</td>
                        <td>${row.HeadOfState}</td>
                        <td>${row.Capital}</td>
                        <td>${row.Code2}</td>
                        <td><a href="${delurl}">Delete Country</a></td>
                        <td><a href="${updurl}">Update Country</a></td>
                    </tr>
                </c:forEach>
                </tbody>
        </table>
        
    </body>
</html>
