<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<%Usuario mi_usuario = (Usuario) session.getAttribute("mi_usuario");%>
<%int session_id = (int) session.getAttribute("session_id");%>



<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="assets/css/main.css" />
	
<title>Mi Perfil</title>
</head>


<body class="is-preload">

    <%@ include file='header.jsp' %>

    <section id="main" class="container">
          <header>
            <h2>Hola <%= mi_usuario.getNombre()%>, </h2>
            <p>Estos son tus datos: </p>
          </header>


        <div class="col-6 col-12-mobilep" >
            <ul class="alt">
                <li>Nombre: <%= mi_usuario.getNombre() %></li>
                <li>Apellidos: <%= mi_usuario.getApellido1() %> <%= mi_usuario.getApellido2() %></li>
                <li>Email: <%= mi_usuario.getEmail() %></li>
                <li>Número de Telefono: <%= mi_usuario.getTelefono() %> </li>
                <li>Tipo de Usuario: <%= mi_usuario.getTipo_usuario() %> </li>
            </ul>
        </div>

        <p>¿Quieres cambiar tus datos? Estás a un click hacerlo.<p>
        <button class="button special small" onclick="document.getElementById('id02').style.display='block'" style="width:auto;">Editar Perfil</button>
        
        <%--FORMULARIO PARA CAMBIAR LOS DATOS--%>
        
        <div id="id02" class="modal">
            <form class="modal-content animate" method="post" autocomplete="off" action="perfil_actualizar">
            <!--Aspa de cerrar y avatar usuario-->
            <div class="imgcontainer">
                <span onclick="document.getElementById('id02').style.display='none'" class="close" title="Cerrar">&times;</span>
                <h3>Modifica tus datos</h3>
            </div>

            <!--Form propiamente dicho-->					    
            <div class="container">
                
                <div class="row gtr-uniform gtr-50">
    
                    <div class="col-6 col-12-mobilep">
                        <input type="text" placeholder="Nombre" id="nombre" name="nombre">
                    </div>
    
                    <div class="col-6 col-12-mobilep">
                        <input type="text" placeholder="Apellido" id="apellido1" name="apellido1">
                    </div>
                     <div class="col-6 col-12-mobilep">
                        <input type="text" placeholder="Segundo apellido" id="apellido2" name="apellido2">
                    </div>
    
                    <div class="col-6 col-12-mobilep">
                        <input type="email" placeholder="Dirección de email" autocomplete="off" id="email" name="email">
                    </div>
    
                    <div class="col-6 col-12-mobilep">
                        <input type="text" placeholder="Número de telefono" id="telefono" name="telefono">
                    </div>
                    
                    <div class="col-6 col-12-mobilep">

                    </div>
    
                    <div class="col-6 col-12-mobilep">
                        <input type="password" placeholder="Contraseña Actual" autocomplete="off" id="old_contrasenya" name="old_contrasenya">
                    </div>
                    
                    <div class="col-6 col-12-mobilep">
                        <input type="password" placeholder="Nueva Contraseña" autocomplete="off" id="new_contrasenya" name="new_contrasenya">
                    </div>
    
                <div class="col-12">
                    <ul class="actions">
                        <li><input type="submit" class="submitbutton" value="Guardar cambios"></li>
                        <li><button type="button" onclick="document.getElementById('id02').style.display='none'" class="cancelbutton">Cancelar</button></li>
                    </ul>
                </div>
            </div>

            </form>

        </div>
        
    </section>
    
    <%@ include file='footer.jsp' %>
    
    <script type="text/javascript"> 
        document.getElementById('nombre').value = '<%=mi_usuario.getNombre()%>';
        document.getElementById('apellido1').value = '<%=mi_usuario.getApellido1()%>';
        document.getElementById('apellido2').value = '<%=mi_usuario.getApellido2()%>';
        document.getElementById('email').value = '<%=mi_usuario.getEmail()%>';
        document.getElementById('telefono').value = '<%=mi_usuario.getTelefono()%>';
    </script>

</body>
</html>
