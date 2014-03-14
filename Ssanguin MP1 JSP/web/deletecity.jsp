<%-- 
    Document   : deletecity
    Created on : Sep 19, 2013, 4:23:00 PM
    Author     : Sergio
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete City</title>
    </head>
    <body>
        <h1>Delete City ${param.ID}</h1>
        
        <sql:update dataSource="jdbc/ssanguinMp1Jsp" sql="delete from city where ID = ?">
            <sql:param value="${param.ID}"></sql:param>
        </sql:update>
        
        <c:redirect url="/cities.jsp"></c:redirect>
        
    </body>
</html>
