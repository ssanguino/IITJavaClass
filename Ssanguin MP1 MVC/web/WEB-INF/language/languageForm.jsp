<%-- 
    Document   : languageForm
    Created on : Sep 28, 2013, 5:02:04 PM
    Author     : Sergio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Language Form</title>
    </head>
    <body>        
        <c:choose>
            <c:when test="${pageContext.request.method == 'GET'}">
                <!-- if it is a GET, read the data and render update form -->
                <c:if test="${not empty param.language}">
                    <form action="<c:url value="/languages/update"/>" method="post">
                </c:if>
                <c:if test="${empty param.language}">
                    <form action="<c:url value="/languages/new"/>" method="post">
                </c:if>

                        <fieldset>
                            <c:choose>
                                <c:when test="${not empty param.language}">
                                    <h2>Update Language Form</h2>                      
                                </c:when>
                                <c:when test="${empty param.language}">
                                    <h2>New Language Form</h2>
                                </c:when>
                            </c:choose>

                            <div>
                                <label for="language">Language:</label>
                                <input type="text" id="language" name="language" value="${lang.language}" <c:if test="${not empty param.lang}">readonly="true"</c:if>>
                                </div>
                                <div>
                                    <label for="countryCode">Country Code:</label>
                                <c:if test="${not empty param.language}">
                                    <input type="text" id="countryCode" name="countryCode" value="${lang.countryCode}" readonly="true">
                                </c:if>
                                <c:if test="${empty param.language}">
                                    <select name="countryCode">
                                        <c:forEach items="${countries}" var="row">
                                            <option value="${row.code}">${row.name}</option>
                                        </c:forEach>
                                    </select>
                                </c:if>
                            </div>
                            <div>
                                <label for="official">Is official?</label>
                                <input type="radio" name="official" value="T" <c:if test="${lang.isOfficial == 'T'}">checked="true"</c:if>/>True
                                <input type="radio" name="official" value="F" <c:if test="${lang.isOfficial == 'F'}">checked="true"</c:if>/>False
                                </div>
                                <div>
                                    <label for="Percentage">Percentage(Ex 45.4):</label>
                                    <input type="text" id="Percentage" name="Percentage" value="${lang.percentage}">
                            </div>
                            <input type="submit" value="Submit"/>
                            <a href="<c:url value="/languages"/>">Return To Languages</a>
                        </fieldset>
                    </form>
                </c:when>
            </c:choose>

    </body>
</html>
