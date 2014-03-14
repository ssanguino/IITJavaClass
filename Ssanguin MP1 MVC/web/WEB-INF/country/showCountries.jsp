<%-- 
    Document   : showCountries
    Created on : Sep 22, 2013, 3:55:22 PM
    Author     : Sergio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Countries</title>
    </head>
    <body>

        <h1>Countries</h1>
        <a href="<c:url value="/index.jsp"/>">Return Home</a>
        <a href="<c:url value="/countries/new"/>">New Country</a>

        <c:if test="${not empty problem}">
            <span style="color: red;">
                ${problem}
            </span>
        </c:if>
        
        <table border="1">
            <thead>
                <tr>
                    <th>Code</th>
                    <th>Name</th>
                    <th>Continent</th>
                    <th>Region</th>
                    <th>SurfaceArea</th>
                    <th>IndepYear</th>
                    <th>Population</th>
                    <th>LifeExpectancy</th>
                    <th>GNP</th>
                    <th>GNPOld</th>
                    <th>GovernmentForm</th>
                    <th>HeadOfState</th>
                    <th>Capital</th>
                    <th>Code2</th>
                    <th>Delete Country</th>
                    <th>Update Country</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${countries}" var="row">
                    <c:url value="/countries/delete" var="delurl">
                        <c:param name="Code" value="${row.code}"/>
                        <c:param name="countryName" value="${row.name}"/>
                    </c:url>

                    <c:url value="/countries/update" var="updurl">
                        <c:param name="Code" value="${row.code}"/>
                    </c:url>
                    
                    <tr>
                        <td>${row.code}</td>
                        <td>${row.name}</td>
                        <td>${row.continent}</td>
                        <td>${row.region}</td>
                        <td>${row.surfaceArea}</td>
                        <td>${row.indepYear}</td>
                        <td>${row.population}</td>
                        <td>${row.lifeExpectancy}</td>
                        <td>${row.GNP}</td>
                        <td>${row.GNPOld}</td>
                        <td>${row.governmentForm}</td>
                        <td>${row.headOfState}</td>
                        <td>${row.capital}</td>
                        <td>${row.code2}</td>
                        <td><a href="${delurl}">Delete Country</a></td>
                        <td><a href="${updurl}">Update Country</a></td>
                    </tr>
                </c:forEach> 
            </tbody>
        </table>
</html>
