<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<% 
		Usuario mi_usuario = (Usuario) session.getAttribute("mi_usuario");
    int session_id = session.getAttribute("session_id");
%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    <link rel="stylesheet" href="/assets/css/main.css" />
	
<title><%= mi_usuario.getNombre()%></title>
</head>
<body class="is-preload">
  <section id="main" class="container">
          <header>
            <h2>Este es el perfil de: <%= mi_usuario.getNombre()%></h2>
          </header>


<div class="col-6 col-12-mobilep">
                      <ul>
                        <li>Nombre: <%= mi_usuario.getNombre() %></li>
                        <li>Apellidos: <%= mi_usuario.getApellido1() %> <%= mi_usuario.getApellido2() %></li>
                        <li>Email: <%= mi_usuario.getEmail() %></li>
                      </ul>
	</div>

 <%if(mi_usuario.getId() == session_id){ %>
<button class="button special small" onclick="editPerfil()">Editar Perfil</button>
 <% boolean mostrar = false; %>
<%
public void editPerfil() {
  mostrar = true;
} %>

<div class="EditarPerfil">
<% if (mostrar){ %>
//Fomrulario para editar el perfil
<form action="/perfil_actualizar" method="post" >

  Nombre:  
  <input type="text" name="nombre" value="Pablo">
  <br> primer apellido: 
  <input type="text" name="apellido1" value="dpz">
  <br> segundo apellido: 
  <input type="text" name="apellido2" value="De Paz">
  <br> Correo electrónico: 
  <input type="email" name="email">
  <br> Número de teléfono: 
  <input type="tel" name="telefono">
  <br> Contraseña: 
  <input type="password" name="contrasenya">
  <br><br>

  <input type="submit" value="Guardar Cambios">
</form> 
</div>
<% } %>


  <footer id="footer">
          <ul class="icons">
            <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
            <li><a href="#" class="icon fa-facebook"><span class="label">Facebook</span></a></li>
            <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
            <li><a href="#" class="icon fa-github"><span class="label">Github</span></a></li>
            <li><a href="#" class="icon fa-dribbble"><span class="label">Dribbble</span></a></li>
            <li><a href="#" class="icon fa-google-plus"><span class="label">Google+</span></a></li>
          </ul>
          <ul class="copyright">
            <li>All rights reserved.</li>
          </ul>
        </footer>
</body>
</html>
