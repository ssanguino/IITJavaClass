<%-- 
    Document   : countryform
    Created on : Sep 20, 2013, 3:17:15 PM
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
                <form action="countryform.jsp" method="post">

                    <fieldset>
                        <c:choose>
                            <c:when test="${not empty param.Code}">
                                <h2>Update Country Form</h2>

                                <sql:query var="result" dataSource="jdbc/ssanguinMp1Jsp" sql="select * from country where Code = ?">                                    
                                    <sql:param value="${param.Code}"/>
                                </sql:query>

                                <c:set var="country" value="${result.rows[0]}"/>  
                                <input type="hidden" name="updating" value="1">
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
                            <input type="text" id="Name" name="Name" value="${country.Name}">
                        </div>
                        <div>
                            <label for="Continent">Continent:</label>
                            <select name="Continent">
                                <option value="Asia" <c:if test="${country.Continent == 'Asia'}">selected="true"</c:if>>Asia</option>
                                <option value="Europe" <c:if test="${country.Continent == 'Europe'}">selected="true"</c:if>>Europe</option>
                                <option value="North America" <c:if test="${country.Continent == 'North America'}">selected="true"</c:if>>North America</option>
                                <option value="South America" <c:if test="${country.Continent == 'South America'}">selected="true"</c:if>>South America</option>
                                <option value="Africa" <c:if test="${country.Continent == 'Africa'}">selected="true"</c:if>>Africa</option>
                                <option value="Oceania" <c:if test="${country.Continent == 'Oceania'}">selected="true"</c:if>>Oceania</option>
                                <option value="Antarctica" <c:if test="${country.Continent == 'Antarctica'}">selected="true"</c:if>>Antarctica</option>
                                </select>
                            </div>
                            <div>
                                <label for="Region">Region:</label>
                                <input type="text" id="Region" name="Region" value="${country.Region}">
                        </div>
                        <div>
                            <label for="SurfaceArea">SurfaceArea:</label>
                            <input type="text" id="SurfaceArea" name="SurfaceArea" value="${country.SurfaceArea}">
                        </div>
                        <div>
                            <label for="IndepYear">IndepYear:</label>
                            <input type="number" id="IndepYear" name="IndepYear" value="${country.IndepYear}">
                        </div>
                        <div>
                            <label for="Population">Population:</label>
                            <input type="number" id="Population" name="Population" value="${country.Population}">
                        </div>
                        <div>
                            <label for="LifeExpectancy">LifeExpectancy:</label>
                            <input type="text" id="LifeExpectancy" name="LifeExpectancy" value="${country.LifeExpectancy}">
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
                            <input type="text" id="GovernmentForm" name="GovernmentForm" value="${country.GovernmentForm}">
                        </div>
                        <div>
                            <label for="HeadOfState">HeadOfState:</label>
                            <input type="text" id="HeadOfState" name="HeadOfState" value="${country.HeadOfState}">
                        </div>
                        <div>
                            <label for="Capital">Capital:</label>
                            <input type="number" id="Capital" name="Capital" value="${country.Capital}">
                        </div>
                        <div>
                            <label for="Code2">Code2:</label>
                            <input type="text" id="Code2" name="Code2" value="${country.Code2}">
                        </div>

                        <input type="submit" value="Submit"/>
                        <a href="/SsanguinMP1JSP/countries.jsp">Return To Countries</a>
                    </fieldset>
                </form>
            </c:when>

            <c:when test="${pageContext.request.method == 'POST'}">
                <c:choose>
                    <c:when test="${not empty param.updating}">                           
                        <sql:update dataSource="jdbc/ssanguinMp1Jsp" var="result" sql="update country set Name = ?, Continent = ?, Region = ?, SurfaceArea = ?, IndepYear = ?,
                                    Population = ?, LifeExpectancy = ?, GNP = ?, GNPOld = ?, GovernmentForm = ?, HeadOfState = ?, Capital = ?, Code2 = ?  where Code = ?">
                            <sql:param value="${param.Name}"/>
                            <sql:param value="${param.Continent}"/>
                            <sql:param value="${param.Region}"/>
                            <sql:param value="${param.SurfaceArea}"/>
                            <sql:param value="${param.IndepYear}"/>
                            <sql:param value="${param.Population}"/>
                            <sql:param value="${param.LifeExpectancy}"/>
                            <sql:param value="${param.GNP}"/>
                            <sql:param value="${param.GNPOld}"/>
                            <sql:param value="${param.GovernmentForm}"/>
                            <sql:param value="${param.HeadOfState}"/>
                            <sql:param value="${param.Capital}"/>
                            <sql:param value="${param.Code2}"/>
                            <sql:param value="${param.countryCode}"/>
                        </sql:update>
                    </c:when>

                    <c:when test="${empty param.updating}">                           
                        <sql:update dataSource="jdbc/ssanguinMp1Jsp" var="result" sql="insert into country (Code, Name, Continent, Region, SurfaceArea, IndepYear,
                                    Population, LifeExpectancy, GNP, GNPOld, GovernmentForm, HeadOfState, Capital, Code2) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)">
                            <sql:param value="${param.countryCode}"/>
                            <sql:param value="${param.Name}"/>
                            <sql:param value="${param.Continent}"/>
                            <sql:param value="${param.Region}"/>
                            <sql:param value="${param.SurfaceArea}"/>
                            <sql:param value="${param.IndepYear}"/>
                            <sql:param value="${param.Population}"/>
                            <sql:param value="${param.LifeExpectancy}"/>
                            <sql:param value="${param.GNP}"/>
                            <sql:param value="${param.GNPOld}"/>
                            <sql:param value="${param.GovernmentForm}"/>
                            <sql:param value="${param.HeadOfState}"/>
                            <sql:param value="${param.Capital}"/>
                            <sql:param value="${param.Code2}"/>
                        </sql:update>
                    </c:when>
                </c:choose>

                <c:redirect url="cities.jsp"></c:redirect>
            </c:when>
        </c:choose>

    </body>
</html>
