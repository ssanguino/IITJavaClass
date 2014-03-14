<%-- 
    Document   : deletelanguage
    Created on : Sep 19, 2013, 4:33:24 PM
    Author     : Sergio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Language</title>
    </head>
    <body>
        <h1>Delete Language ${param.ID}</h1>
        
        <sql:update dataSource="jdbc/ssanguinMp1Jsp" sql="delete from countryLanguage where countryCode = ? and language = ?">
            <sql:param value="${param.countryCode}"></sql:param>
            <sql:param value="${param.language}"></sql:param>
        </sql:update>
        
        <c:redirect url="/languages.jsp"></c:redirect>
        
    </body>
</html>
