<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Principal</title>
    </head>
    <body>
        
        <!-- Barra de navegación -->
        <nav class="navbar navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">
                <img src="https://cdn3.iconfinder.com/data/icons/black-easy/512/538309-game_512x512.png" width="30" height="30" class="d-inline-block align-top" alt="nada">
                Proyecto Final 3CM9 
                </a>
            <a href="logout">
                <img src="https://cdn4.iconfinder.com/data/icons/basic-ui-elements/700/012_power-512.png" width="35" height="35" class="d-inline-block align-top" alt="nada">
                <button type="button" class="btn btn-info" > Cerrar Sesión </button></a>
            </div>
        </nav>
        
        <br><br>
        <!-- Contenedor : Solo muestra el nombre del profesor -->
        <div class="container">
            <div class="jumbotron" align="center">
                <h2>Bienvenido administrador : <i class="text-danger"> <s:property value="#session.userId" /> </i> </h2>
                <p class="lead">Seleccione alguna operación</p>
            </div>
        </div>  
        
        <!-- Asignacion de alumnos y profesores a grupos -->
        <h3 align="center"> 
            <a href="obtenerAsignaciones.action"> 
                <button type="button" class="btn btn-outline-dark btn-lg" >
                    Asignación de profesores o alumnos a grupos
                </button>
            </a>
        </h3>
                      
        <!-- Administrar usuarios -->
        <h3 align="center"> 
            <a href="obtenerUsuarios.action">
                <button type="button" class="btn btn-outline-success btn-lg" >
                    Crear / Borrar / Modificar Usuarios
                </button>
            </a> 
        </h3> 
        
        <!-- Administrar grupos -->
        <h3 align="center"> 
            <a href="obtenerGrupos.action"> 
                <button type="button" class="btn btn-outline-danger btn-lg" >
                    Administración de Grupos
                </button>
            </a>
        </h3>
        
                
        
    </body>
</html>
