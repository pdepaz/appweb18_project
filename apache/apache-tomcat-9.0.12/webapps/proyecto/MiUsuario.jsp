<%@ page language='java' contentType='text/html;charset=utf-8'%>

<%@ page import='proyecto.*'%>
<%@ page import='java.util.List, java.io.*, java.util.*'%>

<% 
		Usuario miusuario = (Usuario) session.getAttribute("miusuario")

%>


<!DOCTYPE html>
<html>
<head>

	
<title>Mi Perfil</title>
</head>

<body>

	<div class="InfoPersonal">
		name = <%= user.getName() %>
		appellidos = <%= user.getApellido1() %> <%= user.getApellido2()%>
		email = <%= getEmail()%>
		<br></br>
	
	</div>


	<button onclick="editPerfil()">Editar Perfil</button>

<% boolean mostrar = false; %>
<%
public void editPerfil() {
  mostrar = true;
}

%>
<div class="EditarPerfil">
<% if (mostrar){ %>
//Fomrulario para editar el perfil
<form action="/Usuario_Control" method="post" >

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



</body>
</html>
