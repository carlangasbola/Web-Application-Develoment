
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1> Hubo un error </h1>
        
        <s:if test="hasActionErrors()">
            <strong>
                <s:actionerror cssClass="text-danger"/>
            </strong>
        </s:if>
        
    </body>
</html>
