<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Libreria para la manipulacion con ajax -->
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Bitacora de asignaciones </title>
    </head>
    <body>
        
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
            <p class="mb-0">Selecciona el usuario y el grupo al que deseas que se asigne.</p>
        </blockquote>
        
        <br>
        
        <!-- Vamos a solictar el nombre del usaurio y el grupo al que se asignará -->
        <s:form action="asignar">
            <sx:autocompleter cssClass="custom-select" 
                              list="lista1" 
                              name="nombre" 
                              label=" Selecciona el Alumno : " ></sx:autocompleter>
            
             <sx:autocompleter cssClass="custom-select"
                               list="lista2"   
                               name="nombregrupo"  
                               label=" Selecciona el Grupo  : " ></sx:autocompleter>
            
            <s:submit value="Asignar usuario" cssClass="btn btn-warning" align="left"></s:submit> 
            
        </s:form>
        
        <table class="table">
            <thead>
                <td>ID</td>
                <td>Usuario</td>
                <td>Grupo</td>
                <td>Elimiar</td>
            </thead>
            
            <!-- Manera de recuperacion de los usuarios y sus grupos pertenecientes -->
            Usuarios que estan asignados a grupos
            <s:set var="i" value="-1"></s:set>
            <s:set var="j" value="-1"></s:set>
            <s:set var="k" value="-1"></s:set>
            
            <s:iterator value="lista3">
                
                <tr>
                    <td><s:property value="lista3[#i=#i+1][0]" /></td>
                    <td><s:property value="lista3[#j=#j+1][1]" /></td>
                    <td><s:property value="lista3[#k=#k+1][2]" /></td>
                    <td> <a href='eliminaAsignacion.action?idUser=<s:property value="lista3[#i][0]"/>&nombregrupo=<s:property value="lista3[#k][2]" />'> Eliminar</a> </td>
                </tr>
            </s:iterator>
        
        </table>
            
           
            
       
      
        
    </body>
</html>
