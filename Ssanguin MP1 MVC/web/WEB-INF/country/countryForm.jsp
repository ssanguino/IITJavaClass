<%-- 
    Document   : countryForm
    Created on : Sep 28, 2013, 5:01:56 PM
    Author     : Sergio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Country Form</title>
    </head>
    <body>        
        <c:choose>
            <c:when test="${pageContext.request.method == 'GET'}">
                <!-- if it is a GET, read the data and render update form -->
                <c:if test="${not empty param.Code}">
                    <form action="<c:url value="/countries/update"/>" method="post">
                </c:if>
                <c:if test="${empty param.Code}">
                    <form action="<c:url value="/countries/new"/>" method="post">
                </c:if>

                    <fieldset>
                        <c:choose>
                            <c:when test="${not empty param.Code}">
                                <h2>Update Country Form</h2>
                            </c:when>
                            <c:when test="${empty param.Code}">
                                <h2>New Country Form</h2>
                            </c:when>
                        </c:choose>
                        <div>
                            <label for="countryCode">Country Code:</label>
                            <input type="text" id="countryCode" name="countryCode" value="${param.Code}" <c:if test="${not empty param.Code}">readonly="readonly"</c:if>>
                        </div>
                        <div>
                            <label for="Name">Name:</label>
                            <input type="text" id="Name" name="Name" value="${country.name}">
                        </div>
                        <div>
                            <label for="Continent">Continent:</label>
                            <select name="Continent">
                                <option value="Asia" <c:if test="${country.continent == 'Asia'}">selected="true"</c:if>>Asia</option>
                                <option value="Europe" <c:if test="${country.continent == 'Europe'}">selected="true"</c:if>>Europe</option>
                                <option value="North America" <c:if test="${country.continent == 'North America'}">selected="true"</c:if>>North America</option>
                                <option value="South America" <c:if test="${country.continent == 'South America'}">selected="true"</c:if>>South America</option>
                                <option value="Africa" <c:if test="${country.continent == 'Africa'}">selected="true"</c:if>>Africa</option>
                                <option value="Oceania" <c:if test="${country.continent == 'Oceania'}">selected="true"</c:if>>Oceania</option>
                                <option value="Antarctica" <c:if test="${country.continent == 'Antarctica'}">selected="true"</c:if>>Antarctica</option>
                                </select>
                            </div>
                            <div>
                                <label for="Region">Region:</label>
                                <input type="text" id="Region" name="Region" value="${country.region}">
                        </div>
                        <div>
                            <label for="SurfaceArea">SurfaceArea:</label>
                            <input type="text" id="SurfaceArea" name="SurfaceArea" value="${country.surfaceArea}">
                        </div>
                        <div>
                            <label for="IndepYear">IndepYear:</label>
                            <input type="number" id="IndepYear" name="IndepYear" value="${country.indepYear}">
                        </div>
                        <div>
                            <label for="Population">Population:</label>
                            <input type="number" id="Population" name="Population" value="${country.population}">
                        </div>
                        <div>
                            <label for="LifeExpectancy">LifeExpectancy:</label>
                            <input type="text" id="LifeExpectancy" name="LifeExpectancy" value="${country.lifeExpectancy}">
                        </div>
                        <div>
                            <label for="GNP">GNP:</label>
                            <input type="text" id="GNP" name="GNP" value="${country.GNP}">
                        </div>
                        <div>
                            <label for="GNPOld">GNPOld:</label>
                            <input type="text" id="GNPOld" name="GNPOld" value="${country.GNPOld}">
                        </div>
                        <div>
                            <label for="GovernmentForm">GovernmentForm:</label>
                            <input type="text" id="GovernmentForm" name="GovernmentForm" value="${country.governmentForm}">
                        </div>
                        <div>
                            <label for="HeadOfState">HeadOfState:</label>
                            <input type="text" id="HeadOfState" name="HeadOfState" value="${country.headOfState}">
                        </div>
                        <div>
                            <label for="Capital">Capital:</label>
                            <input type="number" id="Capital" name="Capital" value="${country.capital}">
                        </div>
                        <div>
                            <label for="Code2">Code2:</label>
                            <input type="text" id="Code2" name="Code2" value="${country.code2}">
                        </div>

                        <input type="submit" value="Submit"/>
                        <a href="<c:url value="/countries"/>">Return To Countries</a>
                    </fieldset>
                </form>
            </c:when>
        </c:choose>

    </body>
</html>

