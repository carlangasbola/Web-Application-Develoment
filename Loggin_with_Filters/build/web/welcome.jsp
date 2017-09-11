<%-- 
    Document   : welcome
    Created on : 11/09/2017, 12:27:50 PM
    Author     : carlos
--%>

<!-- Es una directiva  -->
<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Welcome! <%=session.getAttribute("userName") %> </h1>
    </body>
</html>

