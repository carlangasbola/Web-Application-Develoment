
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Loggin</title>
    </head>
    
    <body>
        <s:form action="ingreso" method="post">
            <s:textfield name="nombre"   label="Nombre"   />
            <s:password  name="password" label="password" />
            <s:submit value="Enviar"/>
        </s:form>
    </body>
    
</html>
