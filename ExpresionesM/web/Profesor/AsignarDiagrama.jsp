<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>  Asignar Diagrama </title>
    </head>
    <body>
        <!-- Asignar diagramas -->
        
        <nav class="navbar navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                    <img src="https://cdn3.iconfinder.com/data/icons/black-easy/512/538309-game_512x512.png" width="30" height="30" class="d-inline-block align-top" alt="nada">
                    Proyecto Final 3CM9 
                </a>
                <a href="logout">
                    <img src="https://cdn4.iconfinder.com/data/icons/basic-ui-elements/700/012_power-512.png" width="35" height="35" class="d-inline-block align-top" alt="nada">
                    <button type="button" class="btn btn-info" > 
                        Cerrar Sesión 
                    </button>
                </a>
            </div>
        </nav>
        
        <br>
        
        <div class="row">
        <div class="col-4"></div>
            
        <div class="col-4">
            
        <h2> Bitacora de asignaciones </h2>
        
        <blockquote class="blockquote">
            <p class="mb-0">Selecciona el grupo y el diagrama al que deseas que se asigne.</p>
        </blockquote>
        
        <br>
        
        <s:form action="insertarAsignacionDiagrama">
            <sx:autocompleter cssClass="custom-select" 
                              list="lista1" 
                              name="nombregrupo" 
                              label=" Selecciona el Grupo : " ></sx:autocompleter>
            
             <sx:autocompleter cssClass="custom-select"
                               list="lista2"   
                               name="idDiagrama"  
                               label=" Selecciona el Diagrama  : " ></sx:autocompleter>
            
            <s:submit value="Crear asignación" cssClass="btn btn-warning" align="left"></s:submit> 
            
        </s:form>
        
        
        
    </body>
</html>
