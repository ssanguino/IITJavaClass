<%-- 
    Document   : createcity
    Created on : Sep 19, 2013, 6:38:08 PM
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
                <form action="cityform.jsp" method="post">

                    <sql:query var="countryCodes" dataSource="jdbc/ssanguinMp1Jsp" sql="select Code, Name from country">                                    
                    </sql:query>

                    <fieldset>
                        <c:choose>
                            <c:when test="${not empty param.ID}">
                                <h2>Update City Form</h2>

                                <sql:query var="result" dataSource="jdbc/ssanguinMp1Jsp" sql="select * from city where ID = ?">                                    
                                    <sql:param value="${param.ID}"/>
                                </sql:query>

                                <c:set var="city" value="${result.rows[0]}"/>
                                <div>
                                    <label for="cityID">ID:</label>
                                    <input type="text" id="cityID" name="cityID" value="${city.ID}" readonly="readonly">
                                </div>
                                <input type="hidden" name="updating" value="1">
                            </c:when>
                            <c:when test="${empty param.ID}">
                                <h2>New City Form</h2>
                            </c:when>
                        </c:choose>

                        <div>
                            <label for="cityName">City Name:</label>
                            <input type="text" id="cityName" name="cityName" value="${city.Name}">
                        </div>
                        <div>
                            <label for="countryCode">Country Code:</label>
                            <select name="countryCode">
                                <c:forEach items="${countryCodes.rows}" var="row">
                                    <c:choose>
                                        <c:when test = "${row.Code == city.Code}">
                                            <option value="${row.Code}" selected="true">${row.Name}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${row.Code}">${row.Name}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <div>
                            <label for="District">District:</label>
                            <input type="text" id="District" name="District" value="${city.District}">
                        </div>
                        <div>
                            <label for="Population">Population:</label>
                            <input type="number" id="Population" name="Population" value="${city.Population}">
                        </div>
                        <input type="submit" value="Submit"/>
                        <a href="/SsanguinMP1JSP/cities.jsp">Return To Cities</a>
                    </fieldset>
                </form>
            </c:when>

            <c:when test="${pageContext.request.method == 'POST'}">
                <c:choose>
                    <c:when test="${not empty param.updating}">                           
                        <sql:update dataSource="jdbc/ssanguinMp1Jsp" var="result" sql="update city set Name = ?, countryCode = ?, District = ?, Population = ? where ID = ?">
                            <sql:param value="${param.cityName}"/>
                            <sql:param value="${param.countryCode}"/>
                            <sql:param value="${param.District}"/>
                            <sql:param value="${param.Population}"/>
                            <sql:param value="${param.cityID}"/>
                        </sql:update>
                    </c:when>

                    <c:when test="${empty param.updating}">                           
                        <sql:update dataSource="jdbc/ssanguinMp1Jsp" var="result" sql="insert into city (name, countrycode, district, population) VALUES (?, ?, ?, ?)">
                            <sql:param value="${param.cityName}"/>
                            <sql:param value="${param.countryCode}"/>
                            <sql:param value="${param.District}"/>
                            <sql:param value="${param.Population}"/>
                        </sql:update>
                    </c:when>
                </c:choose>

                <c:redirect url="cities.jsp"></c:redirect>
            </c:when>
        </c:choose>

    </body>
</html>

