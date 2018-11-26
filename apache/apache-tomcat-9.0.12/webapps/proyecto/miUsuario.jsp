<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<% 
		Usuario mi_usuario = (Usuario) session.getAttribute("mi_usuario");

%>


<!DOCTYPE html>
<html>
<head>

	
<title><%= mi_usuario.getNombre()%></title>
</head>

<body>

	<div class="InfoPersonal">
		<p>Nombre: <%= mi_usuario.getNombre() %></p>
		<p>Apellidos: <%= mi_usuario.getApellido1() %> <%= mi_usuario.getApellido2() %></p>
		<p>Email: <%= mi_usuario.getEmail() %></p>
	
	</div>

<%-- <%if(mi_usuario.getId() == SESSION ID){ %> --%>
<%--	<button onclick="editPerfil()">Editar Perfil</button>

 <% boolean mostrar = false; %>


<%
public void editPerfil() {
  mostrar = true;
}

%>
<div class="EditarPerfil">
<% if (mostrar){ %>
//Fomrulario para editar el perfil
<form action="/usuario_guardar" method="post" >

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
<% } %> --%>

</body>
</html>
