<%-- 
    Document   : languageform
    Created on : Sep 19, 2013, 8:27:46 PM
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
                <form action="languageform.jsp" method="post">

                    <sql:query var="countryCodes" dataSource="jdbc/ssanguinMp1Jsp" sql="select Code, Name from country">                                    
                    </sql:query>

                    <fieldset>
                        <c:choose>
                            <c:when test="${not empty param.lang}">
                                <h2>Update Language Form</h2>

                                <sql:query var="result" dataSource="jdbc/ssanguinMp1Jsp" sql="select * from countrylanguage where countryCode = ? and language = ?">                                    
                                    <sql:param value="${param.countryCode}"/>
                                    <sql:param value="${param.lang}"/>
                                </sql:query>                         

                                <c:set var="lang" value="${result.rows[0]}"/>
                                <input type="hidden" name="updating" value="1">
                            </c:when>
                            <c:when test="${empty param.lang}">
                                <h2>New Language Form</h2>
                            </c:when>
                        </c:choose>

                        <div>
                            <label for="language">Language:</label>
                            <input type="text" id="language" name="language" value="${lang.Language}" <c:if test="${not empty param.lang}">readonly="true"</c:if>>
                            </div>
                            <div>
                                <label for="countryCode">Country Code:</label>
                            <c:if test="${not empty param.lang}">
                                <input type="text" id="countryCode" name="countryCode" value="${lang.countryCode}" readonly="true">
                            </c:if>
                            <c:if test="${empty param.lang}">
                                <select name="countryCode">
                                    <c:forEach items="${countryCodes.rows}" var="row">
                                        <c:choose>
                                            <c:when test = "${row.Code == param.countryCode}">
                                                <option value="${row.Code}" selected="true">${row.Name}</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${row.Code}">${row.Name}</option>
                                            </c:otherwise>
                                        </c:choose>
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
                                <input type="text" id="Percentage" name="Percentage" value="${lang.Percentage}">
                            </div>
                        <input type="submit" value="Submit"/>
                        <a href="/SsanguinMP1JSP/languages.jsp">Return To Languages</a>
                    </fieldset>
                </form>
            </c:when>

            <c:when test="${pageContext.request.method == 'POST'}">
                <c:choose>
                    <c:when test="${not empty param.updating}">                           
                        <sql:update dataSource="jdbc/ssanguinMp1Jsp" var="result" sql="update countrylanguage set isOfficial = ?, Percentage = ? where countryCode = ? and language = ?">
                            <sql:param value="${param.official}"/>
                            <sql:param value="${param.Percentage}"/>
                            <sql:param value="${param.countryCode}"/>
                            <sql:param value="${param.language}"/>
                        </sql:update>
                    </c:when>

                    <c:when test="${empty param.updating}">                           
                        <sql:update dataSource="jdbc/ssanguinMp1Jsp" var="result" sql="insert into countrylanguage (countryCode, language, isOfficial, percentage) VALUES (?, ?, ?, ?)">
                            <sql:param value="${param.countryCode}"/>
                            <sql:param value="${param.language}"/>
                            <sql:param value="${param.official}"/>
                            <sql:param value="${param.Percentage}"/>
                        </sql:update>
                    </c:when>
                </c:choose>

                <c:redirect url="languages.jsp"></c:redirect>
            </c:when>
        </c:choose>

    </body>
</html>


