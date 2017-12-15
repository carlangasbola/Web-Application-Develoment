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
        <title>Bitacora de usuarios</title>
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
        <h3 align="center"> Bitacora de usuarios </h3>
        <br>
        
        <!-- Agregar Usuario   -->
        <h3 align="center"> 
            <a href="InsertarUsuario.jsp">
                <button type="button" class="btn btn-outline-info" >
                    Agregar Usuario
                </button>
            </a> 
        </h3> 
        <br>
        
        <table class="table table-striped" >
            
            <thead class="thead-dark">
                
                <tr scope="row" align="center">
                    <th scope="col">Nombre</th>
                    <th scope="col">Tipo</th> 
                    <!-- 
                    <th scope="col">Contraseña</th> 
                    -->
                    <th scope="col">Delete</th>
                    <th scope="col">Modify</th>
                </tr>
            </thead>
        
            <!-- Aqui vamos a iterar a los usuarios -->
            <s:iterator value="lista_usuarios">
                
                <!-- Borrar usuario 
                <s:url action="borrar_usuario.action" var="url" >
                    <s:param name="idUser">
                        <s:property value="idUser" />
                    </s:param>
                </s:url>
                
                <!-- Modificar usuario -->
                <s:url action="obtenerUsuario.action" var="url2">
                    <s:param name="idUser">
                        <s:property value="idUser" />
                    </s:param>
                </s:url>
                
                <tr scope="row" align="center">
                    <td> <s:property value="userNameIn" /> </td>
                    <!-- Validación del tipo de usuario -->
                    <s:if test="%{tipoIn == 'administrador'}">
                        <td class="table-danger"> <s:property value="tipoIn" /> </td>
                    </s:if>
                    <s:else>
                        <td>  <s:property value="tipoIn" /></td>
                    </s:else>
                    <!-- ESTA ETIQUETA MOSTRABA LA CONTRASEÑA 
                         LA COLOQUE PARA FINES PRACTICOS
                    <td> <%// <s:property value="passwordIn" /> %> </td>
                    -->
                    <td> <a href="<s:property value="#url"/>" onclick = "return confirmBox();"> Borrar</a> </td>
                    <td> <a href="<s:property value="#url2" />">Modificar</a> </td>
                </tr>
                
            </s:iterator>
            
        </table>
        
        
        </div>
       
        <br><br><br>
        
        
        <!-- Script de la validacion de borrado de usuario -->
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
