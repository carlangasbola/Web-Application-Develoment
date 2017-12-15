
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
        <title>Insertar Usuario</title>
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
        
        <h2> &nbsp;&nbsp; Modificar al usuario
            <img src="https://png.icons8.com/?id=14082&size=280" style="width: 30px;height: 30px;" /> 
        </h2>
        
        <p>
            A continuación llene los campos, se le muestran<br>
            vacios para que pueda cambiar el nombre, el tipo<br>
            o la contraseña si asi lo desea.<br>
        </p>
        
        
        <s:form action="modificar_usuario">
            
            <s:hidden name="id" value="%{lista_usuarios.get(0).getIdUser()}"></s:hidden>
            
            <s:textfield cssClass="form-control mx-sm-2" 
                         name="nombre" label="Usuario"
                         placeholder="Nuevo nombre"
                         required="required"/>
            
            <s:password  cssClass="form-control mx-sm-2" 
                         name="password"
                         label="Password" placeholder="Contraseña Nueva" required="required"/>
            
            <select name="tipo" class="custom-select mb-2 mr-sm-2 mb-sm-0">
                <option value="profesor">Profesor</option>
                <option value="administrador">Administrador</option>
                <option value="alumno">Alumno</option>
            </select>
            
            <s:submit value="Insertar Usuario" cssClass="btn btn-primary" align="left" />
            
        </s:form>
        
        </div>
        
        </div>
        
    </body>
</html>