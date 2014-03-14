<%-- 
    Document   : cityForm
    Created on : Sep 26, 2013, 5:01:41 PM
    Author     : Sergio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>City Form</title>
    </head>
    <body>        
        <c:choose>
            <c:when test="${pageContext.request.method == 'GET'}">
                <!-- if it is a GET, read the data and render update form -->
                <c:if test="${not empty param.ID}">
                    <form action="<c:url value="/cities/update"/>" method="post">
                </c:if>
                <c:if test="${empty param.ID}">
                    <form action="<c:url value="/cities/new"/>" method="post">
                </c:if>

                    <fieldset>
                        <c:choose>
                            <c:when test="${not empty param.ID}">
                                <h2>Update City Form</h2>
                                <div>
                                    <label for="cityID">ID:</label>
                                    <input type="text" id="cityID" name="cityID" value="${city.ID}" readonly="readonly">
                                </div>
                            </c:when>
                            <c:when test="${empty param.ID}">
                                <h2>New City Form</h2>
                            </c:when>
                        </c:choose>

                        <div>
                            <label for="cityName">City Name:</label>
                            <input type="text" id="cityName" name="cityName" value="${city.name}">
                        </div>
                        <div>
                            <label for="countryCode">Country Code:</label>
                                <select name="countryCode">
                                    <c:forEach items="${countries}" var="row">
                                        <option value="${row.code}" <c:if test="${row.code == city.countryCode}">selected="true"</c:if>>${row.name}</option>
                                    </c:forEach>
                                </select>
                        </div>
                        <div>
                            <label for="District">District:</label>
                            <input type="text" id="District" name="District" value="${city.district}">
                        </div>
                        <div>
                            <label for="Population">Population:</label>
                            <input type="number" id="Population" name="Population" value="${city.population}">
                        </div>
                        <input type="submit" value="Submit"/>
                        <a href="<c:url value="/cities"/>">Return To Cities</a>
                    </fieldset>
                </form>
            </c:when>
        </c:choose>

    </body>
</html>
