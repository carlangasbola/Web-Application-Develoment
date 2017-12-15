<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <title>Inicio</title>
    </head>
    <body>
        
        <!-- Barra de navegacion  -->
        <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
            <a class="navbar-brand" href="#">Proyecto Final Web Application Develoment</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
        </nav>
        
        <br><br><br>
        
        <div class="col-5"> </div>
        <div class="col-5"> 
        <h2> Iniciar sessión </h2>
        
        <!-- Formulario de inicio de sesion -->
        <s:form action="Ingresar" cssClass="form-group">
            <s:textfield name="userName" label="Usuario" required="required" cssClass="form-control mx-sm-2"/>
            <s:password  name="password" label="Contraseña" required="required" cssClass="form-control mx-sm-2"/>
            <s:submit value="Ingresar" cssClass="btn btn-primary" align="left"></s:submit>    
        </s:form>
        
        <!-- Muestra un mensaje de error si no esta en la base de datos -->
        <s:if test="hasActionErrors()">
            <strong>
                <s:actionerror cssClass="text-danger"/>
            </strong>
        </s:if>
        
        </div>
        
        
        
    </body>
</html>
