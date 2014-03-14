<%-- 
    Document   : deletecountry
    Created on : Sep 19, 2013, 4:30:19 PM
    Author     : Sergio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Country</title>
    </head>
    <body>
        <h1>Deleting Country ${param.countryName}</h1>
        <a href="/SsanguinMP1JSP">Return Home</a>       
        <a href="/SsanguinMP1JSP/countries.jsp">Return to countries</a>
        <br>
        <c:catch var="exception">
            <sql:update dataSource="jdbc/ssanguinMp1Jsp" var="updatedTable" sql="delete from country where Code = ?">
                <sql:param value="${param.Code}"></sql:param>
            </sql:update>

            <c:if test="${updatedTable>=1}">
                <c:redirect url="/countries.jsp"></c:redirect>
            </c:if>
        </c:catch>
        <c:if test="${exception!=null}">
            <c:out value="Can't delete the country ${param.countryName}. Please remove any cities or languages associated with it first (Code: ${param.Code})." />
        </c:if>
        
        
    </body>
</html>
