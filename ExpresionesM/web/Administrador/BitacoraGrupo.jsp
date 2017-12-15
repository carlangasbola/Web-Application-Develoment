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
        <title>Bitacora de grupos</title>
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
        <h3 align="center"> Bitacora de grupos </h3>
        <br>
        
        <div class="row" >
            <div class="col-4"></div>
            <div class="col-4" style="text-align: center">
                <div class="p-3 mb-2 bg-danger text-white" style="border-radius: 10px;">
                    <strong>
                        Crea con cuidado los grupos no se puede cambiar el nombre 
                    </strong>
                </div>
            </div>
            <div class="col-4"></div>
        </div>
        
        <br>
        
        <!-- Agregar grupo   -->
        <h3 align="center"> 
            <a href="InsertarGrupo.jsp">
                <button type="button" class="btn btn-outline-info" >
                    Agregar grupo
                </button>
            </a> 
        </h3> 
        <br>
        
        
        <!-- Tabla que despliega todos los grupos -->
        <table class="table table-striped" >
            
            <thead class="thead-dark">
                
                <tr scope="row" align="center">
                    <th scope="col">Nombre</th>
                    <th scope="col">Delete</th>
                    <th scope="col">Modify</th>
                </tr>
            </thead>
            
            <s:iterator value="lista_grupo">
                
                <!-- Borrar grupo -->
                <s:url action="borrar_grupo.action" var="url" >
                    <s:param name="nombregrupo">
                        <s:property value="nombregrupo" />
                    </s:param>
                </s:url>
                
                
                <tr scope="row" align="center">
                    <td> <s:property value="nombregrupo" /> </td>
                    <td> <a href="<s:property value="#url"/>" onclick = "return confirmBox();"> Borrar</a> </td>
                    <td> --- </td>
                </tr>
                
            </s:iterator>
            
        </table>
        
        <!-- Confirmación para borrar -->
        <script>
                function confirmBox() {
                var answer;
                answer = window.confirm("¿Estás seguro de realizar esta acción? No hay vuelta atras");
                if (answer == true) {
                    return true;
                } else {
                    return false;
                }
                }
        </script>
        
    </body>
</html>
